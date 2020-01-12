package com.bingai.day12.demo03.Datemat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
请使用日期时间相关的API，计算出一个人已经出生了多少天。
**思路：**
1.使用Scanner类中的方法next，获取出生日期
2.使用DateFormat类中的方法parse，把字符串的出生日期解析为Date模式
3.把Date格式的出生日期转换为毫秒值
4.获取当前日期，转换为毫秒值
5.使用当前日期的毫秒值 - 出生日期的毫秒值
6.把毫秒值的差值转换为天（s/1000/60/60/24）

 */
public class Demo02Test {
    public static void main(String[] args) throws ParseException {
//        1.使用Scanner类中的方法next，获取出生日期
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入出生日期，格式为yyyy-MM-dd");
        String birthdayDateStr = sc.next();

//        2.使用DateFormat类中的方法parse，把字符串的出生日期解析为Date模式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdayDate = sdf.parse(birthdayDateStr);

//        3.把Date格式的出生日期转换为毫秒值
        long birthdayDateTime = birthdayDate.getTime();

//        4.获取当前日期，转换为毫秒值
        long todayTime = new Date().getTime();

//        5.使用当前日期的毫秒值 - 出生日期的毫秒值
        long time = todayTime - birthdayDateTime;

//        6.把毫秒值的差值转换为天（s/1000/60/60/24）
        long birthdayTime = time / 1000 / 60 / 60 / 24 ;
        System.out.println(birthdayTime);//9602

    }
}
