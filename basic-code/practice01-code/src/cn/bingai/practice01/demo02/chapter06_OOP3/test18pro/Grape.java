package cn.bingai.practice01.demo02.chapter06_OOP3.test18pro;

public class Grape implements Fruit {
    @Override
    public void grow() {
        System.out.println("葡萄生长");
    }

    @Override
    public void harvest() {
        System.out.println("葡萄收获");
    }

    @Override
    public void plant() {
        System.out.println("葡萄种植");
    }
}
