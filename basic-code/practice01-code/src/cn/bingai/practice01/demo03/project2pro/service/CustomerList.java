package cn.bingai.practice01.demo03.project2pro.service;

import cn.bingai.practice01.demo03.project2pro.bean.Customer;

/**
 * @Description CustomerList为Customer对象的管理模块，
 * 内部用数组管理一组Customer对象，
 * 并提供相应的添加、修改、删除和遍历方法，供CustomerView调用
 */
public class CustomerList {
    private Customer[] customers;//用来保存客户对象的数组
    private int total;//记录已保存客户对象的数量

    /**
     * @param totalCustomer：指定customers数组的最大空间
     * @Description 构造器，用来初始化customers数组
     */
    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    /**
     * @param customer：customer指定要添加的客户对象
     * @return 添加成功返回true；false表示数组已满，无法添加
     * @Description 将参数customer添加到数组中最后一个客户对象记录之后
     */
    public boolean addCustomer(Customer customer) {
        if (total < customers.length) {
            /*customers[total] = customer;
            total++;*/
            customers[total++] = customer;
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param index：customer指定替换的新客户对象
     * @param cust：index指定所替换对象在数组中的位置，从0开始
     * @return 替换成功返回true；false表示索引无效，无法替换
     * @Description 用参数customer替换数组中由index指定的对象
     */
    public boolean replaceCustomer(int index, Customer cust) {
        if (index >= 0 && index < customers.length) {
            //if (index >= 0 && index <= total){
            customers[index] = cust;
            return true;
        } else {
            return false;
        }

    }

    /**
     * @param index ： index指定所删除对象在数组中的索引位置，从0开始
     * @return 删除成功返回true；false表示索引无效，无法删除
     * @Description 从数组中删除参数index指定索引位置的客户对象记录
     */
    public boolean deleteCustomer(int index) {
        //if (index >= 0 && index < customers.length){
        if (index >= 0 && index <= total) {
            for (int i = index; i < total - 1; i++) {
                customers[i] = customers[i + 1];//后一个替换前一个
            }
            //最后一个需要置为null
            /*customers[total -1] = null;
            total--;*/
            customers[--total] = null;
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return ： Customer[] 数组中包含了当前所有客户对象，该数组长度与对象个数相同。
     * @Description 返回数组中记录的所有客户对象
     */
    public Customer[] getAllCustomers() {
        //return customers;
        //需要进行复制操作，原数组（大）到现数组（小）
        Customer[] custs = new Customer[total];
        for (int i = 0; i < custs.length; i++) {
            custs[i] = customers[i];
        }
        return custs;
    }

    /**
     * @param index ： index指定所要获取的客户在数组中的索引位置，从0开始
     * @return 封装了客户信息的Customer对象
     * @Description 返回参数index指定索引位置的客户对象记录
     */
    public Customer getCustomer(int index) {

        if (index >= 0 && index <= total) {
            return customers[index];
        }else{
            return null;
        }

    }

    public int getTotal() {
        return total;
    }
}
