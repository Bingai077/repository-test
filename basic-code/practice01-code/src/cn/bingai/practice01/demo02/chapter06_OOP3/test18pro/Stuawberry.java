package cn.bingai.practice01.demo02.chapter06_OOP3.test18pro;

public class Stuawberry implements Fruit {
    @Override
    public void grow() {
        System.out.println("草莓生长");
    }

    @Override
    public void harvest() {
        System.out.println("草莓收获");
    }

    @Override
    public void plant() {
        System.out.println("草莓种植");
    }
}
