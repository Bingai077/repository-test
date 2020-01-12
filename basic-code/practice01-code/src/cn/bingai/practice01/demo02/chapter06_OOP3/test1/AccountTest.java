package cn.bingai.practice01.demo02.chapter06_OOP3.test1;

public class AccountTest {


    public static void main(String[] args) {

        Account acc1 = new Account();
        Account acc2 = new Account("123456", 10000);

        Account.setInterestRate(0.035);
        Account.setMinMoney(100);

        System.out.println(acc1);
        System.out.println(acc2);
        System.out.println(acc1.getInterestRate());
        System.out.println(acc2.getMinMoney());

    }

}
