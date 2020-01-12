package cn.bingai.practice01.demo02.chapter08_thread;

import java.util.Objects;

/**
 * 模拟银行取钱的问题
 * 1.定义一个Account类
 * 1）该Account类封装了账户编号（String）和余额（double）两个属性
 * 2）设置相应属性的getter和setter方法
 * 3）提供无参和有两个参数的构造器
 * 4） 系统根据账号判断与用户是否匹配，需提供hashCode()和equals()方法的重写
 * 2.提供两个取钱的线程类：小明、小明’s wife
 * 1）提供了Account类的account属性和double类的取款额的属性
 * 2） 提供带线程名的构造器
 * 3） run()方法中提供取钱的操作
 * 3.在主类中创建线程进行测试。考虑线程安全问题。
 *
 * @author bingai
 * @create 2019-11-01 17:57
 */
class Account {
    private String Id;
    private double balance;

    public Account() {
    }


    public Account(String id, double balance) {
        Id = id;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "Id='" + Id + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(account.balance, balance) == 0 &&
                Objects.equals(Id, account.Id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(Id, balance);
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class withdrawThread extends Thread {
    private Account acc;
    private double withdraw;

    public withdrawThread() {
    }

    public withdrawThread(String name, Account acc, double withdraw) {
        super(name);
        this.acc = acc;
        this.withdraw = withdraw;
    }

    @Override
    public  void run() {
        synchronized (acc) {
            if (withdraw <= acc.getBalance()) {
                acc.setBalance(acc.getBalance() - withdraw);
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName() + "取钱成功，您的取款金额为：" + withdraw);
            } else {
                System.out.println("取钱失败，余额不足！");
            }
            System.out.println("您的账户余额为：" + acc.getBalance());
        }

    }
}

public class Test15 {
    public static void main(String[] args) {
        Account acc = new Account("6213051", 10000);
        new withdrawThread("小明",acc,8000).start();
        new withdrawThread("小明’s wife",acc,8000).start();


    }

}
