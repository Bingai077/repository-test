package com.bingai.day12.demo02.Date;

import java.util.Date;

public class Demo02Date {
    public static void main(String[] args) {

        demo01();
        demo02();

        /*
        Date类的成员方法：
        long getTime()  把日期转换为毫秒(相当于System.currentTimeMills())
          返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。

         */
        demo03();

    }
/*
       Date类的空参数构造方法：
          Date() 获取的就是当前系统的日期和时间
 */
    private static void demo01(){
        Date date = new Date();
        System.out.println(date);//Tue Oct 08 12:22:50 CST 2019
    }

/*
        Date类的带参数构造方法：
            Date(long date):传递毫秒值，把毫秒直接转换为Date日期
 */
    private static void demo02(){
        Date date = new Date(0L);//long型
        System.out.println(date);//Thu Jan 01 08:00:00 CST 1970

        Date date1 = new Date(15114454102115L);
        System.out.println(date1);//Wed Dec 16 03:28:22 CST 2448
    }

    private static void demo03(){
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);//1570509908022
    }
}
