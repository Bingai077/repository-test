package cn.bingai.practice01.demo01;

import java.util.Arrays;
import java.util.Scanner;

/*
题目：写一个函数，求一个字符串的长度，在main函数中输入字符串，并输出其长度。

 */
public class Test38 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串:");
        String str = sc.nextLine();
        sc.close();

        System.out.println("字符串的长度为：" + str.length());
    }
}
