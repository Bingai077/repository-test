package com.bingai.day12.demo06.StringBuilder;
/*
    StringBuilder与String可以相互转换
        String --> StringBuilder:可以使用StringBuilder的构造方法
             public StringBuilder(String str)：构造一个StringBuilder容器，并将字符串添加进去。
        StringBuilder --> String：可以使用StringBuilder中的toString方法

 */
public class Demo03ToString {
    public static void main(String[] args) {
//        String --> StringBuilder
        String str = "Hello";
        System.out.println(str);//Hello
        StringBuilder builder = new StringBuilder(str);
        System.out.println(builder.append(" World"));//Hello World

        //StringBuilder --> String
        String string = builder.toString();
        System.out.println(string);//Hello World
    }
}
