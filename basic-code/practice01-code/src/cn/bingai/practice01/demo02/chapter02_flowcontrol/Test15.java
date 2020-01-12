package cn.bingai.practice01.demo02.chapter02_flowcontrol;

import java.util.Scanner;

/*
    假设你想开发一个玩彩票的游戏，程序随机地产生一个两位数的彩票，提示用户输入
    一个两位数，然后按照下面的规则判定用户是否能赢。
    1)如果用户输入的数匹配彩票的实际顺序，奖金10 000美元。
    2)如果用户输入的所有数字匹配彩票的所有数字，但顺序不一致，奖金 3 000美元。
    3)如果用户输入的一个数字仅满足顺序情况下匹配彩票的一个数字，奖金1 000美元。
    4)如果用户输入的一个数字仅满足非顺序情况下匹配彩票的一个数字，奖金500美元。
    5)如果用户输入的数字没有匹配任何一个数字，则彩票作废。

 */
public class Test15 {
    public static void main(String[] args) {
        System.out.println("请输入一个两位数：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int num = (int) (Math.random() * 90 + 10);
        int bonus = 0;
        if (n == num) {
            bonus = 10000;
            System.out.println("恭喜您，获得了" + bonus + "美元奖金");
        } else if (n / 10 == num % 10 && n % 10 == num / 10) {
            bonus = 3000;
            System.out.println("恭喜您，获得了" + bonus + "美元奖金");
        } else if (n / 10 == num / 10 || n % 10 == num % 10) {
            bonus = 1000;
            System.out.println("恭喜您，获得了" + bonus + "美元奖金");
        } else if (n / 10 == num % 10 || n % 10 == num / 10) {
            bonus = 500;
            System.out.println("恭喜您，获得了" + bonus + "美元奖金");
        } else {

            System.out.println("谢谢惠顾！再来一张");
        }

        System.out.println("中奖号码为：" + num);


    }
}
