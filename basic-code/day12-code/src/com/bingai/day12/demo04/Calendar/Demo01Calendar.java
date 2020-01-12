package com.bingai.day12.demo04.Calendar;

import java.util.Calendar;

/*
    java.util.Calendar类：日历类
    Canlendar类是一个抽象类，里边提供了许多操作日历字段的方法（YEAR、MONTH、DAY_OF_MONTH、HOUR ）
    Canlendar类无法直接创建对象使用，里面有一个静态方法叫做getInstance()，该方法返回了Calendar类的子类对象
    
    static Calendar getInstance()
          使用默认时区和语言环境获得一个日历。 
 */
public class Demo01Calendar {
    public static void main(String[] args) {
        Calendar calander = Calendar.getInstance();//多态
        System.out.println(calander);

    }
}
