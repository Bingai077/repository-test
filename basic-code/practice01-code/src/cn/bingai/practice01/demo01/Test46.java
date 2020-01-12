package cn.bingai.practice01.demo01;

import java.util.Scanner;

/*
题目：两个字符串连接程序

程序分析：考察程序的基本常识吗？

 */
public class Test46 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个字符串：");
        String str1 = sc.next();
        System.out.println("输入的第一个字符串为：" + str1);
        System.out.println("请输入第二个字符串：");
        String str2 = sc.next();
        System.out.println("输入的第二个字符串为：" + str1);

        System.out.println("字符串连接为：" + str1 + str2);


    }

}
