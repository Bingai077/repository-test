package com.bingai.day13.demo03.Generic;
/*
    测试含有泛型的接口
 */
public class Demo04GenericInterface {
    public static void main(String[] args) {
        //创建GenericInterfaceImpl1对象
        GenericInterfaceImpl1 impl1 = new GenericInterfaceImpl1();
        impl1.method("字符串");

        //创建GenericInterfaceImpl2对象
        GenericInterfaceImpl2<Integer> impl2 = new GenericInterfaceImpl2<>();
        impl2.method(10);

        GenericInterfaceImpl2<Double> impl3 = new GenericInterfaceImpl2<>();
        impl3.method(0.0112235);


    }
}
