package cn.bingai.practice01.demo02.chapter06_OOP3.test13;

import cn.bingai.practice01.demo02.chapter06_OOP3.test11.Animal;

public class Cat implements cn.bingai.practice01.demo02.chapter06_OOP3.test13.Animal {
    public Cat() {
    }

    @Override
    public void shout() {
        System.out.println("猫会喵喵叫");
    }
}
