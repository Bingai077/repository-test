package com.bingai.day12.demo06.StringBuilder;
/*
StringBuilder类的成员方法：
        public StringBuilder append(...)：添加任意类型数据的字符串形式，并返回当前对象自身。
        参数：
            可以是任意数据类型

        public String toString()：将当前StringBuilder对象转换为String对象。
 */
public class Demo02Append {
    public static void main(String[] args) {
        //创建一个StringBuilder对象
        StringBuilder builder = new StringBuilder();
        //使用append方法往StringBuilder中添加数据
        //append方法返回的是this，调用方法的对象
        StringBuilder builder1 = builder.append("bingai");
        System.out.println(builder);//bingai
        System.out.println(builder1);//bingai
        System.out.println(builder == builder1);//true 两个对象是同一个对象

        //使用append方法无需接受返回值
        builder1.append("bin");
        builder1.append("love");
        builder1.append(1);
        builder1.append(9.9);
        builder1.append("陈");
        System.out.println(builder1);

        /*
        链式编程：方法的返回值是一个对象，可以根据对象继续调用方法
         */
        System.out.println(builder1.append(1252).append("dshffgf").append('c').append("dshf"));

    }
}
