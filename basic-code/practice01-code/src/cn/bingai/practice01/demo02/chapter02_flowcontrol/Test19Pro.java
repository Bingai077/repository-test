package cn.bingai.practice01.demo02.chapter02_flowcontrol;

import java.util.Scanner;

/*
编写程序：从键盘分别输入年、月、日，判断这一天是当年的第几天
        注：判断一年是否是闰年的标准：
        1）可以被4整除，但不可被100整除
        或
        2）可以被400整除
 */
public class Test19Pro {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入year：");
        int year = sc.nextInt();
        System.out.println("请输入month：");
        int month = sc.nextInt();
        System.out.println("请输入day：");
        int day = sc.nextInt();
        sc.close();

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
                if (year % 4 == 0 || year % 400 == 0 && year % 100 != 0) {
                    sumDays += 29;
                } else {
                    sumDays += 28;
                }
            case 1:
                sumDays += day;
        }

        System.out.println(year + "年" + month + "月" + day + "日" + "是当年的第" + sumDays + "天");

    }







}
