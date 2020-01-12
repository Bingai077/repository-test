package com.bingai.day12.demo01.Object;

import java.util.Random;

/*


 */
public class Demo02Equals {
    public static void main(String[] args) {

        /*
        Person类默认继承了Object类，所以可以使用Object类的equals方法

        boolean equals(Object obj)  指示其他某个对象是否与此【对象】“相等”。
        源码：
        public boolean equals(Object obj) {
        return (this == obj);
           参数：  Object obj：可以传递任意的对象
           方法体： ==：比较运算符，返回的是一个布尔值  true/false
                   基本数据类型：比较的是值
                   引用数据类型：比较的是两个对象的地址值
            this： 哪个对象调用方法，方法中的this就是那个对象
                   p1调用的是equals方法，所以this就是p1，obj就是传递过来的参数p2
                   this == obj  --> p1 == p2

    }
         */

        Person p1 = new Person("斌",18);
        Person p2 = new Person("斌",18);
//        p1 = p2;//p2的地址给p1
        System.out.println(p1);//Person@2ac1fdc4
        System.out.println(p2);//Person@5f150435


        Random r = new Random();



        boolean b = p1.equals(p2);
//        boolean b1 = p1.equals(r);
//        boolean b2 = p1.equals(null);
        boolean b3 = p1.equals(p1);
        System.out.println(b);//false//true


    }
}
