package com.bingai.day11.demo02.sub;

import com.bingai.day11.demo02.MyClass;

public class Stranger {

    public void methodStranger(){
//        System.out.println(new MyClass().num1);//private不可以
//        System.out.println(new MyClass().num2);//默认的不可以
//        System.out.println(new MyClass().num3);//protected不可以
        System.out.println(new MyClass().num4);//public可以
    }
}
