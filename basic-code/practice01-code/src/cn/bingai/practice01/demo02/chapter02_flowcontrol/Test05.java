package cn.bingai.practice01.demo02.chapter02_flowcontrol;

import java.util.Scanner;

/*
你的公司有多少奖金

 */
public class Test05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入当月利润(万元)：");
        double i = sc.nextDouble();
        sc.close();

        double j = 0;
        if (i <= 10) {
            j = i * 0.1;
        } else if (/*i > 10 && */i <= 20) {
            j = (i - 10) * 0.075 + 10 * 0.1;
        } else if (/*i > 20 &&*/ i <= 40) {
            j = (i - 20) * 0.05 + 10 * 0.075 + 10 * 0.1;
        } else if (/*i > 40 &&*/ i <= 60) {
            j = (i - 40) * 0.03 + 20 * 0.05 + 10 * 0.075 + 10 * 0.1;
        } else if (/*i > 60 &&*/ i <= 100) {
            j = (i - 60) * 0.015 + 20 * 0.03 + 20 * 0.05 + 10 * 0.075 + 10 * 0.1;
        } else {
            j = (i - 100) * 0.01 + 40 * 0.015 + 20 * 0.03 + 20 * 0.05 + 10 * 0.075 + 10 * 0.1;
        }

        System.out.println("当月奖金为(万元)：" + j);


    }
}
