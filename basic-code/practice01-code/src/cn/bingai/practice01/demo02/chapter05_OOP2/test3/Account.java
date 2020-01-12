package cn.bingai.practice01.demo02.chapter05_OOP2.test3;

/*
写一个名为 Account 的类模拟账户。该类的属性和方法如下图所示。该类包括的属性：
账号 id，余额 balance，年利率 annualInterestRate；包含的方法：访问器方法（getter 和
setter 方法），返回月利率的方法 getMonthlyInterest()，取款方法 withdraw()，存款方法
deposit()。
 */
public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;

    public Account() {
    }

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInterest() {
        return this.annualInterestRate / 12;
    }

    //取钱
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("余额不足，请充值！");
        } else {
            balance -= amount;
            System.out.println("取钱成功，请拔卡！");
        }
        System.out.println("您的账户余额为：" + balance);
    }

    //存钱
    public void deposit(double amount) {
        if (amount <= 0){
            System.out.println("输入有误，请重输！");
        }else{
            balance += amount;
            System.out.println("成功存入，请拔卡！");
        }
        System.out.println("您的账户余额为：" + balance);
        System.out.println("您的月利率为：" + getAnnualInterestRate());
    }


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", annualInterestRate=" + annualInterestRate +
                '}';
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
}
