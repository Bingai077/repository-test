package cn.bingai.practice01.demo02.chapter09_constantClass;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 创建BigDecimalDemo类，
 * 在类中分别定义add(),sub(),mul()和div()方法
 * 实现加、减、乘、除运算，并输出运算结果。
 * 要求除法，可以处理商的精度。
 * @author bingai
 * @create 2019-11-03 11:17
 */
public class Test09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数字：");
        Integer num1 = sc.nextInt();
        System.out.println("请输入第二个数字：");
        Integer num2 = sc.nextInt();
        sc.close();

        BigDecimal bd1 = new BigDecimal(num1);
        BigDecimal bd2 = new BigDecimal(num2);

        System.out.println("两数相加为：" + bd1.add(bd2));
        System.out.println("两数相减为：" + bd1.subtract(bd2));
        System.out.println("两数相乘为：" + bd1.multiply(bd2));
        System.out.println("两数相除（保留12位小数）为：" + bd1.divide(bd2,12,BigDecimal.ROUND_HALF_UP));
    }
}

