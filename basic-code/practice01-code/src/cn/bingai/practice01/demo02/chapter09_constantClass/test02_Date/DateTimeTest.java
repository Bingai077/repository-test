package cn.bingai.practice01.demo02.chapter09_constantClass.test02_Date;

import org.junit.Test;

import java.util.Date;

/**
 * JDK 8之前日期和时间的API测试
 *
 * @author bingai
 * @create 2019-11-02 2:47
 */
public class DateTimeTest {


    /*
    java.util.Date类
             |--- java.sql.Date类
    1.两个构造器的使用
        构造器一：Date()：创建了一个对应当前时间的Date对象
        构造器二：创建指定毫秒数的Date对象

    2.两个方法的使用
        toString():显示当前的年月日，时分秒
        getTime():获取当前对象的毫秒数/时间戳

    3.java.sql.Date:对应数据库中的日期类型变量
        如何实例化？
        java.sql.Date对象 ---> java.util.Date对象:直接赋值
        java.util.Date对象 ---> java.sql.Date对象:

     */
    @Test
    public void test2(){
        //构造器一：Date()：创建了一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());//Sat Nov 02 02:59:41 CST 2019

        System.out.println(date1.getTime());//1572634889358

        //构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(1572634889358L);
        System.out.println(date2);//Sat Nov 02 03:01:29 CST 2019

        //创建java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(1572634889358L);
        System.out.println(date3);//2019-11-02

        // java.util.Date对象 ---> java.sql.Date对象
//        情况一：
//        Date date4 = new java.sql.Date(1572634889358L);
//        java.sql.Date date5 = (java.sql.Date)date4;

        //情况二：
        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());

    }








    //1.System类中的currentTimeMillis()
    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
        //称为时间戳
        System.out.println(time);//1572634168326
    }
}
