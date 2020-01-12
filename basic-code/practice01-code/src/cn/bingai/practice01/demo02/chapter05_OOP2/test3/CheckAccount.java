package cn.bingai.practice01.demo02.chapter05_OOP2.test3;
/*
创建 Account 类的一个子类 CheckAccount 代表可透支的账户，该账户中定义一个属性
overdraft 代表可透支限额。在 CheckAccount 类中重写 withdraw 方法，其算法如下：

如果（取款金额<账户余额），
可直接取款
如果（取款金额>账户余额），
计算需要透支的额度
判断可透支额 overdraft 是否足够支付本次透支需要，如果可以
将账户余额修改为 0，冲减可透支金额
如果不可以
提示用户超过可透支额的限额


（1） 子类 CheckAccount 的构造方法需要将从父类继承的 3 个属性和子类自己的属性全
部初始化。
（2） 父类Account的属性balance被设置为private，但在子类CheckAccount的withdraw
方法中需要修改它的值，因此应修改父类的 balance 属性，定义其为 protected。

 */
public class CheckAccount extends Account {

    private double overdraft;

    public CheckAccount(double overdraft) {
        this.overdraft = overdraft;
    }

    public CheckAccount(int id, double balance, double annualInterestRate, double overdraft) {
        super(id, balance, annualInterestRate);
        this.overdraft = overdraft;
    }


    @Override
    //取钱
    public void withdraw(double amount) {
        /*if (amount > getBalance()) {
            double od = amount - getBalance();
            if(overdraft >= od){
                double odye = overdraft - od;
                super.setBalance(0);
                this.setOverdraft(odye);
                System.out.println("您的可透支余额为：" + this.getOverdraft());
                System.out.println("您的账户余额为：" + super.getBalance() + "\n");
            }else{
                System.out.println("您已超过透支额度，请及时充值！！" + "\n");
            }
        } else {
            //方式一：改父类权限
            //方式二：
            //setBalance(getBalance() - amount);
            //方式三：
            super.withdraw(amount);
            System.out.println("取钱成功，请拔卡！");
            System.out.println("您的账户余额为：" + super.getBalance());
            System.out.println("您的可透支余额为：" + this.getOverdraft() + "\n");
        }*/

        if (amount <= getBalance()) {
            //方式一：改父类权限
            //方式二：
            //setBalance(getBalance() - amount);
            //方式三：
            super.withdraw(amount);
            System.out.println("取钱成功，请拔卡！");
            System.out.println("您的账户余额为：" + super.getBalance());
            System.out.println("您的可透支余额为：" + this.getOverdraft() + "\n");
        } else if(overdraft >= amount - getBalance()){//透支+余额足够消费
            overdraft -= (amount - getBalance());
            setBalance(0);
            //或者取光所有
            super.withdraw(getBalance());
            System.out.println("您的可透支余额为：" + this.getOverdraft());
            System.out.println("您的账户余额为：" + super.getBalance() + "\n");
        }else{
            System.out.println("您已超过透支额度，请及时充值！！" + "\n");
        }

    }


    @Override
    public String toString() {
        return "CheckAccount{" +
                "overdraft=" + overdraft +
                '}';
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }
}
