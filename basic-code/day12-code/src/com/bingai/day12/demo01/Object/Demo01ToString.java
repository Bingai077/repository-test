package com.bingai.day12.demo01.Object;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
    java.lang.Object类
    类 Object 是类层次结构的根(最顶层)类。每个类都使用 Object 作为超(父)类。所有对象（包括数组）都实现这个类的方法。

 */
public class Demo01ToString {
    public static void main(String[] args) {
        /*
        Person类默认继承了Object类，所以可以使用Object中的toString方法

        String toString() 返回该对象的字符串表示

         */

        Person p = new Person("斌改",18);
        String s = p.toString();
        System.out.println(s);//Person@2ac1fdc4//Person{name='斌改', age=18}

        //直接打印对象的名字，其实就是在调用对象的toString()方法
        System.out.println(p);//Person@2ac1fdc4//Person{name='斌改', age=18}

        /*
        看一个类是否重写了toString方法，直接打印这个类对应的对象名字即可
            如果没有重写toString方法，那么打印的就是对象的地址值（默认）
            如果重写了toString方法，那么就是按照重写的方式打印
         */

        //Random类没有重写toString方法
        Random r = new Random();
        System.out.println(r);//java.util.Random@34ce8af7

        //Scanner类重写了toString方法
        Scanner sc = new Scanner(System.in);
        System.out.println(sc);//java.util.Scanner[delimiters=\p{javaWhitespace}+]...

        //ArrayList重写了toString方法
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list);//[1, 2]






    }
}
