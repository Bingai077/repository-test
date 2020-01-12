package cn.bingai.practice01.demo02.chapter04_OOP1.test9pro;

import java.util.Arrays;

/*
 addCustomer 方法必须依照参数（姓，名）构造一个新的 Customer 对象，然后把
它放到 customer 数组中。还必须把 numberOfCustomer 属性的值加 1。

 getNumOfCustomers 方法返回 numberofCustomers 属性值。
 getCustomer 方法返回与给出的 index 参数相关的客户。

 */
public class Bank {
    private Customer[] customers = new Customer[10];//存放多个客户的数组
    private int numberOfCustomers;//记录客户的个数



    public Bank() {
    }

    public Bank(int numberOfCustomers, Customer[] customers) {
        this.numberOfCustomers = numberOfCustomers;
        this.customers = customers;
    }

    public void addCustomers(String firstName, String lastName) {
        Customer customer = new Customer(firstName, lastName);
        /*customers[numberOfCustomers] = customer;
        numberOfCustomers++;*/
        customers[numberOfCustomers++] = customer;

    }


    @Override
    public String toString() {
        return "Bank{" +
                "numberOfCustomers=" + numberOfCustomers +
                ", customers=" + Arrays.toString(customers) +
                '}';
    }

    //获取指定位置上的客户
    public Customer getCustomers(int index) {
        if(index >= 0 && index <= numberOfCustomers){
            return customers[index];
        }
        return null;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    //获取客户的个数
    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }

    public void setNumberOfCustomers(int numberOfCustomers) {
        this.numberOfCustomers = numberOfCustomers;
    }
}
