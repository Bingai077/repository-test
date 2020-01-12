package cn.bingai.practice01.demo02.chapter01_grammar;

import java.util.Scanner;

/*
不借助第三者实现两个变量值的互换

异或^运算符：
    参与运算的两数各对应二进位相异或，当两对应的二进位相异时，结果为1。

 */
public class Test09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int A = sc.nextInt();
        System.out.println("请输入另外一个数：");
        int B = sc.nextInt();
        System.out.println("输入的数是：" + "A=" + A + "  B=" + B);
        sc.close();
        A = A ^ B;
        B = B ^ A;
        A = A ^ B;
        System.out.println("输出的数是：" + "A=" + A + "  B=" + B);

    }
}
