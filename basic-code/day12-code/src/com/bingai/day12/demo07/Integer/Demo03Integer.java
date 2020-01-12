package com.bingai.day12.demo07.Integer;
/*
    基本数据类型与字符串之间的转换
    基本类型 --> 字符串
        1.基本类型数据的值 + ""   最简单的方式（工作中常用）
        2.使用包装类中的静态方法
            static String toString(int i)  返回一个表示指定整数的 String 对象。
        3.使用String类中的静态方法
            static String valueOf(int i)   返回 int 参数的字符串表示形式。

    字符串 --> 基本类型
        使用包装类的静态方法parseXX("字符串")
            Integer类： static int parseInt(String s)  将字符串参数作为有符号的十进制整数进行解析。
            Double类：  static double parseDouble(String s) 返回一个新的 double 值，该值被初始化为用指定 String 表示的值，这与 Double 类的 valueOf 方法一样。
            ...
 */
public class Demo03Integer {
    public static void main(String[] args) {
        //基本类型 --> 字符串，方式一:加空字符串
        String s1 = 100 + "";
        System.out.println(s1 + 200);//100200
        //方式二：包装类中toString方法
        String s2 = Integer.toString(200);
        System.out.println(s2 + 300);//200300
        //方式三：String类中valueOf方法
        String s3 = String.valueOf(500);
        System.out.println(s3 + 500);//500500

        //字符串 --> 基本类型，parseXXX方法（Character除外）
        int i = Integer.parseInt("100");
        System.out.println(i + 200);//300

//        int i1 = Integer.parseInt("a");//NumberFormatException 数字格式化异常





    }
}
