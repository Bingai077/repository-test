package cn.bingai.practice01.demo02.chapter02_flowcontrol;

import java.util.Scanner;

/*
    编写一个程序，为一个给定的年份找出其对应的中国生肖。
    中国的生肖基于12年一个周期，每年用一个动物代表：
	rat（鼠）、ox（牛）、tiger（虎）、rabbit（兔）、dragon（龙）、snake（蛇）、
    horse（马）、sheep（羊）、monkey（候）、rooster（鸡）、dog（狗）、pig（猪）。
提示：2019年：猪   2019 % 12 == 3

 */
public class Test28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年份:");
        int year = sc.nextInt();
        sc.close();

        String str = "";
        switch (year % 12) {
            case 0:
                str = "猴年";
                break;
            case 1:
                str = "鸡年";
                break;
            case 2:
                str = "狗年";
                break;
            case 3:
                str = "猪年";
                break;
            case 4:
                str = "鼠年";
                break;
            case 5:
                str = "牛年";
                break;
            case 6:
                str = "虎年";
                break;
            case 7:
                str = "兔年";
                break;
            case 8:
                str = "龙年";
                break;
            case 9:
                str = "蛇年";
                break;
            case 10:
                str = "马年";
                break;
            case 11:
                str = "羊年";
                break;
        }
        System.out.println(year + "年是" + str);

    }
}
