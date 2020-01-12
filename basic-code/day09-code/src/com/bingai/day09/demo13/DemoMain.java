package com.bingai.day09.demo13;

public class DemoMain {
    public static void main(String[] args) {
//        Animal animal = new animal();//error
//        Dog dog = new Dog();//error,也是抽象类

        Dog2Ha ha = new Dog2Ha();
        ha.eat();
        ha.sleep();
        System.out.println("========");

        DogGolden golden = new DogGolden();
        golden.eat();
        golden.sleep();
    }
}
