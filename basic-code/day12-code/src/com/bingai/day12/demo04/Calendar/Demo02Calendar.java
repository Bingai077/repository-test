package com.bingai.day12.demo04.Calendar;

import java.util.Calendar;
import java.util.Date;

/*
    Calendar类的成员方法：
- public int get(int field)：返回给定日历字段的值。
- public void set(int field, int value)：将给定的日历字段设置为给定值。
- public abstract void add(int field, int amount)：根据日历的规则，为给定的日历字段添加或减去指定
的时间量。
- public Date getTime()：返回一个表示此Calendar时间值（从历元到现在的毫秒偏移量）的Date对象。

成员方法的参数：
    int field：日历类的字段，可以使用Canlendar类的静态成员变量获取
    public static final int YEAR = 1;    年
    public static final int MONTH = 2;    月
    public static final int DATE = 5;    月中的某一天
    public static final int DAY_OF_MONTH = 5;    月中的某一天
    public static final int HOUR = 10;      时
    public static final int MINUTE = 12;    分
    public static final int SECOND = 13;    秒

 */
public class Demo02Calendar {
    public static void main(String[] args) {

        demo01();
        System.out.println("====");
        demo02();
        System.out.println("====");
        demo03();
        System.out.println("====");
        demo04();
    }
    /*
    public int get(int field)：返回给定日历字段的值。
    参数：传递指定的日历字段(YEAR,MONTH...)
    返回值：日历字段代表具体的值
     */
    private static void demo01(){
        //使用getInstance方法获取Calendar对象
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        System.out.println(year);//2019

        int month = calendar.get(Calendar.MONTH);
        System.out.println(month + 1);//9,西方月份0-11，东方：1-12

        int day = calendar.get(Calendar.DATE);
        System.out.println(day);//8

        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));//8
        System.out.println(calendar.get(Calendar.HOUR));//3
        System.out.println(calendar.get(Calendar.MINUTE));//55
        System.out.println(calendar.get(Calendar.SECOND));//43
    }


/*
        public void set(int field, int value)：将给定的日历字段设置为给定值。
        参数：
        int field：传递指定的日历字段(YEAR,MONTH...)
        int value：传递的字段设置的具体的值

 */
    private static void demo02(){
        //使用getInstance方法获取Calendar对象
        Calendar calendar = Calendar.getInstance();

        //设置年为2088年
        calendar.set(Calendar.YEAR,2088);
        System.out.println(calendar.get(Calendar.YEAR));//2088
        //设置月为9月
        calendar.set(Calendar.MONTH,8);
        System.out.println(calendar.get(Calendar.MONTH));//8
        //设置日为9
        calendar.set(Calendar.DATE,9);
        System.out.println(calendar.get(Calendar.DATE));//9

        // 同时设置年月日
        calendar.set(8888,8,8);
        System.out.println(calendar.get(Calendar.YEAR) + " " + calendar.get(Calendar.MONTH) + " " + calendar.get(Calendar.DATE));

    }

    /*
    public abstract void add(int field, int amount)：根据日历的规则，为给定的日历字段添加或减去指定
的时间量。
    把指定的字段增加或减少指定的值
    参数：
        int field：传递指定的日历字段(YEAR,MONTH...)
        int amout：增加/减少的值
            正数：增加
            负数：减少
     */
    private static void demo03(){
        //使用getInstance方法获取Calendar对象
        Calendar calendar = Calendar.getInstance();

        //把年增加两年,月减少3个月，日增加5天
        calendar.add(Calendar.YEAR,2);
        calendar.add(Calendar.MONTH,-3);
        calendar.add(Calendar.DATE,5);

        System.out.println(calendar.get(Calendar.YEAR));//2021
        System.out.println(calendar.get(Calendar.MONTH));//6
        System.out.println(calendar.get(Calendar.DATE));//13
    }


    /*
    public Date getTime()：返回一个表示此Calendar时间值（从历元到现在的毫秒偏移量）的Date对象。
            把日历对象转化为日期对象

     */
    private static void demo04(){
        //使用getInstance方法获取Calendar对象
        Calendar calendar = Calendar.getInstance();

        Date date = calendar.getTime();
        System.out.println(date);//Tue Oct 08 16:21:48 CST 2019

    }

}
