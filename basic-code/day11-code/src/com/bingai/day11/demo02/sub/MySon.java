package com.bingai.day11.demo02.sub;

import com.bingai.day11.demo02.MyClass;//不存在子包的概念，不在同一个包下，需导包

public class MySon extends MyClass {


    public void methodSon() {
//        System.out.println(super.num1);//private不可以
//        System.out.println(super.num2);//默认的不可以
        System.out.println(super.num3);//protected可以
        System.out.println(super.num4);//public可以


    }
}
