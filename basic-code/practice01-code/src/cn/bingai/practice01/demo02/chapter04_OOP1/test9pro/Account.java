package cn.bingai.practice01.demo02.chapter04_OOP1.test9pro;
/*
在提款方法 withdraw()中，需要判断用户余额是否能够满足提款数额的要求，如果不能，
应给出提示。 deposit()方法表示存款。
 */
public class Account {
    private double balance;

    public Account() {
    }

    public Account(double balance) {
        this.balance = balance;
    }


    public void withdraw(double amount) {//取钱
        if (balance < amount) {
            System.out.println("您的账户余额不足，请充值!");
        } else {
            balance -= amount;
            System.out.println("您成功取出了：" + amount + "元");
        }

    }

    public void deposit(double amount) {//存钱
        if (amount > 0){
            balance += amount;
            System.out.println("您成功存入了：" + amount + "元");
        }else{
            System.out.println("对不起，存入不成功，请重新输入！");
        }

    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
