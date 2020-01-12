package cn.bingai.practice01.demo02.chapter02_flowcontrol;

import java.math.BigDecimal;

/*
    计算1 + 1/2！ + 1/3！ + ... + 1/10!的值

    BigDecimal类型的数字可以用来存储最大的浮点数运算
    BigDecimal调用对象add(),neegate(),multiply(),divide()方法实现加减乘除

 */
public class Test09 {
    public static void main(String[] args) {
        float sum = 0;
        float a = 1;
        for (float i = 1; i <= 10; i++) {
            a = a * i;
            sum = sum + 1 / a;
        }
        System.out.println("1 + 1/2！ + 1/3！ + ... + 1/10! = " + sum);//1 + 1/2！ + 1/3！ + ... + 1/10! = 1.7182816

        System.out.println("=======================");
        //高精度
        BigDecimal sum1 = new BigDecimal(0.0);
        BigDecimal a1 = new BigDecimal(1.0);
        for (int i = 1; i <= 10; i++) {
            a1 = a1.multiply(new BigDecimal(1.0 / i));
            sum1 = sum1.add(a1);
        }
        System.out.println("1 + 1/2！ + 1/3！ + ... + 1/10! = " + sum1);

    }
}
