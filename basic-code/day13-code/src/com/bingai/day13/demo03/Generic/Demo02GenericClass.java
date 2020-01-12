package com.bingai.day13.demo03.Generic;

public class Demo02GenericClass {
    public static void main(String[] args) {
        //不写泛型默认为Object类型
        GenericClass  gc = new GenericClass();
        gc.setName("只能是字符串");
        Object obj = gc.getName();

        //创建GenericClass对象，泛型使用Integer类型
        GenericClass<Integer> gc2 = new GenericClass<>();
        gc2.setName(1);
        System.out.println(gc2.getName());//1

        //创建GenericClass对象，泛型使用String类型
        GenericClass<String> gc3 = new GenericClass<>();
        gc3.setName("bingai");
        System.out.println(gc3.getName());//bingai

    }
}
