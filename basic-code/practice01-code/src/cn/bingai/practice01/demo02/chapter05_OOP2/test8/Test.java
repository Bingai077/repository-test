package cn.bingai.practice01.demo02.chapter05_OOP2.test8;

public class Test {
    public static void main(String[] args) {
        Order order1 = new Order(18, "bingai");
        Order order2 = new Order(18, "bingai");

        System.out.println(order1 == order2);//false
        System.out.println(order1.equals(order2));//true


    }
}
