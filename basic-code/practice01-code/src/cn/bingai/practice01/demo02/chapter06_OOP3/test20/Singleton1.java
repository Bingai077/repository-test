package cn.bingai.practice01.demo02.chapter06_OOP3.test20;
//饿汉式
public class Singleton1 {
    private Singleton1(){

    }

    private static Singleton1 instance = new Singleton1();

    public static Singleton1 getInstance() {
        return instance;
    }
}
