package cn.bingai.practice01.demo02.chapter06_OOP3.test13;

public class Dog implements Animal {
    public Dog() {
    }

    @Override
    public void shout() {
        System.out.println("狗会汪汪叫");
    }
}
