package cn.bingai.practice01.demo02.chapter02_flowcontrol;

import java.util.Scanner;

/*
    从键盘读入个数不确定的整数，并判断读入的正数和负数的个数，输入
    为0时结束程序。
 */
public class Test22 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int countPos = 0;
        int countNeg = 0;
        while (true) {
            System.out.println("请输入一个整数");
            int num = sc.nextInt();
            if (num > 0) {
                countPos++;
            } else if (num < 0) {
                countNeg++;
            } else {
                break;
            }
        }
        System.out.println("输入的正整数有" + countPos + "个");
        System.out.println("输入的负整数有" + countNeg + "个");



    }
}
