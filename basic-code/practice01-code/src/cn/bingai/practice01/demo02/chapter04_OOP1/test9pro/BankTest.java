package cn.bingai.practice01.demo02.chapter04_OOP1.test9pro;



public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.addCustomers("bin","gai");

        bank.getCustomers(0).setAccount(new Account(2000));

        bank.getCustomers(0).getAccount().withdraw(500);

        double balance = bank.getCustomers(0).getAccount().getBalance();
        System.out.println("客户："+ bank.getCustomers(0).getFirstName()+"的账户余额为："+balance);

        System.out.println("================");
        bank.addCustomers("Coco","Ming");

        System.out.println("银行客户个数为：" + bank.getNumberOfCustomers());


    }
}
