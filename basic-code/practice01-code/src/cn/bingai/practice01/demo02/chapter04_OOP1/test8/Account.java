package cn.bingai.practice01.demo02.chapter04_OOP1.test8;

/*
写一个名为 Account 的类模拟账户。该类的属性和方法如下图所示。该类包括的属性：
账号 id，余额 balance，年利率 annualInterestRate；包含的方法：访问器方法（getter 和 setter
方法），取款方法 withdraw()，存款方法 deposit()。

 在提款方法 withdraw 中，需要判断用户余额是否能够满足提款数额的要求，如果不
能，应给出提示。
 */
public class Account {
    private int id;//账号
    private double balance;//余额
    private double annualInterestRate;//年利率

    public Account() {
    }

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", annualInterestRate=" + annualInterestRate +
                '}';
    }
}
