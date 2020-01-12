package cn.bingai.practice01.demo02.chapter05_OOP2.test3;
/*
写一个用户程序测试 CheckAccount 类。在用户程序中，创建一个账号为 1122、余
额为 20000、年利率 4.5%，可透支限额为 5000 元的 CheckAccount 对象。
使用 withdraw 方法提款 5000 元，并打印账户余额和可透支额。
再使用 withdraw 方法提款 18000 元，并打印账户余额和可透支额。
再使用 withdraw 方法提款 3000 元，并打印账户余额和可透支额
 */
public class CheckAccountTest {
    public static void main(String[] args) {

        CheckAccount checkAccount = new CheckAccount(1122, 20000, 0.045, 5000);
        checkAccount.withdraw(5000);
        checkAccount.withdraw(18000);
        checkAccount.withdraw(3000);
        System.out.println("您的账户余额：" + checkAccount.getBalance());
        System.out.println("您的可透支余额为：" + checkAccount.getOverdraft());

    }

}

