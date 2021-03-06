package com.bingai.day12.demo02.Date;
/*
    java.util.Date: 表示日期和时间的类
    类 Date 表示特定的瞬间，精确到毫秒。
    毫秒：千分之一秒 1000毫秒=1秒
    特定的瞬间：一个时间点，一刹那的瞬间
    2088-08-08 09:55:33:333 瞬间
    2088-08-08 09:55:33:334 瞬间
    2088-08-08 09:55:33:335 瞬间
    ...

    毫秒值的作用：可以对时间和日期进行计算
    2099-01-03到2088-01-01 中间一共有多少天
    可以把日期转换为毫秒进行计算，计算完毕，再把毫秒转换为日期

    把日期转换为毫秒
        当前的日期：2088-01-01
        时间原点(0毫秒)：1970 年 1 月 1日 00:00:00（英国格林威治）
        就是计算当前日期到时间原点之间一共经历了多少毫秒（1570508009891L）long型
    注意：
        中国属于东八区，会把时间增加8小时
        1970 年 1 月 1日 08:00:00

    把毫秒转换为日期：
        1 天 = 24 × 60 × 60 = 86400 秒 = 86400 x 1000 = 86400000毫秒


 */
public class Demo01Date {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());//1570507948527，获取当前系统到时间原点经历了多少毫秒
        System.out.println(System.currentTimeMillis());//1570508009891




    }
}
