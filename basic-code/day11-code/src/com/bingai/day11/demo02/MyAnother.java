package com.bingai.day11.demo02;

public class MyAnother {
    public void anotherMethod(){
//        System.out.println(new MyClass().num1);//private不行
        System.out.println(new MyClass().num2);//默认可以
        System.out.println(new MyClass().num3);//protect可以
        System.out.println(new MyClass().num4);//public可以
    }

}
