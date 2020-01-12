package cn.bingai.practice01.demo02.chapter08_thread.test2;

/**
 *
 *银行有一个账户。
 有两个储户分别向同一个账户存3000元， 每次存1000， 存3次。每次存完打
 印账户余额。
 问题： 该程序是否有安全问题，如果有，如何解决？
 【提示】
 1，明确哪些代码是多线程运行代码，须写入run()方法 ---两个储户
 2， 明确什么是共享数据。--有，账户
 3，明确多线程运行代码中哪些语句是操作共享数据的。--同步机制：三种方式
 *
 * @author bingai
 * @create 2019-10-31 11:42
 */

class Account{
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public Account() {
    }

    public double getBalance() {
        return balance;
    }

    //public synchronized void deposit(double amt){
    public void deposit(double amt){

        if(amt > 0){
            balance += amt;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ":存钱成功，余额为：" + balance);
        }
    }
}

class Customer extends Thread{
    private Account acct;

    public Customer(Account acct) {
        this.acct = acct;
    }

    public Customer(String name, Account acct) {
        super(name);
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acct.deposit(1000);
        }
    }
}



public class AccountTest {
    public static void main(String[] args) {
        Account acct = new Account();

        Customer c1 = new Customer("甲",acct);
        Customer c2 = new Customer("乙",acct);

        c1.start();
        c2.start();




    }
}
