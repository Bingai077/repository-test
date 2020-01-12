package cn.bingai.practice01.demo02.chapter02_flowcontrol;

import java.util.Scanner;

/*
编写程序：从键盘上输入2019年的“month”和“day”，要求通过程序
           输出输入的日期为2019年的第几天。
         2.15: 31 + 15
         5.7: 32 + 28 + 31 + 30 + 7

 */
public class Test19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入2019年的month：");
        int month = sc.nextInt();
        System.out.println("请输入2019年的day：");
        int day = sc.nextInt();

        int sumDays = 0;
        switch (month) {
            case 12:
                sumDays += 31;
            case 11:
                sumDays += 30;
            case 10:
                sumDays += 31;
            case 9:
                sumDays += 30;
            case 8:
                sumDays += 31;
            case 7:
                sumDays += 31;
            case 6:
                sumDays += 30;
            case 5:
                sumDays += 31;
            case 4:
                sumDays += 30;
            case 3:
                sumDays += 31;
            case 2:
                sumDays += 28;
            case 1:
                sumDays += day;
        }

        System.out.println("2019年" + month + "月" + day + "日" + "是当年的第" + sumDays + "天");

    }
}
