package com.bingai.day12.exam01;

public class Test01 {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(str.toString());//abc,默认调用toString()方法
        //String类已经重写了toString()方法


        Student s = new Student("斌改",23);
        //System.out.println(s.toString());//com.bingai.day12.exam01.Student@2ac1fdc4
        System.out.println(s);//Student{name='斌改', age=23}，重写后
    }
}
