package cn.bingai.practice01.demo02.chapter04_OOP1.test11;
/*
    定义银行账户类Account，有属性：卡号cid，余额balance，所属用户Customer

 */
public class Account {
    private int cid;
    private double balance;
    private Customer customer;

    public Account() {
    }

    public Account(int cid, double balance, Customer customer) {
        this.cid = cid;
        this.balance = balance;
        this.customer = customer;
    }

    //取钱
    public boolean withdraw(double account) {
        if(balance >= account){
            balance -= account;
            System.out.println("取钱成功");
            return true;
        }else {
            System.out.println("取钱失败");
            return false;
        }
    }

    //存钱
    public boolean save(double account) {
        if(account > 0){
            balance += account;
            System.out.println("存钱成功");
            return true;
        }else {
            System.out.println("存钱失败");
            return false;
        }
    }



    public String getInfo() {
        return "Account{" +
                "cid=" + cid +
                ", balance=" + balance +
                ", customer=" + customer.say() +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
