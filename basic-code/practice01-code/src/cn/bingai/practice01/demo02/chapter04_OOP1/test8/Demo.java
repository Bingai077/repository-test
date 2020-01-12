package cn.bingai.practice01.demo02.chapter04_OOP1.test8;
/*
写一个测试程序。
（1） 创建一个 Customer ，名字叫 Jane Smith, 他有一个账号为 1000，余额为 2000 元，
年利率为 1.23％ 的账户。
（2） 对 Jane Smith 操作。
存入 100 元，再取出 960 元。 再取出 2000 元。
打印出 Jane Smith 的基本信息
 */
public class Demo {
    public static void main(String[] args) {

        Customer customer = new Customer("Jane","Smith");
        Account account = new Account(1000, 2000, 0.0123);

        customer.setAccount(account);

        customer.getAccount().deposit(100);
        customer.getAccount().withdraw(960);
        customer.getAccount().withdraw(2000);

        System.out.println(customer);


    }
}
