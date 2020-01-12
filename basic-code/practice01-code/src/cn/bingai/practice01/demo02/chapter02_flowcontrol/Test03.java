package cn.bingai.practice01.demo02.chapter02_flowcontrol;

import java.util.Scanner;

/*
QQ等级活跃天数计算器


 */
public class Test03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入QQ等级：");
        int i = sc.nextInt();
        sc.close();

        if(i == 1){
            System.out.println("您的活跃天数为5天");
        }else if(i == 4){
            System.out.println("您的活跃天数为32天");
        }else if(i == 8){
            System.out.println("您的活跃天数为96天");
        }else if(i == 12){
            System.out.println("您的活跃天数为192天");
        }else if(i == 16){
            System.out.println("您的活跃天数为320天");
        }else if(i == 32){
            System.out.println("您的活跃天数为1152天");
        }else if(i == 48){
            System.out.println("您的活跃天数为2496天");
        }else if(i == 64){
            System.out.println("您的活跃天数为4352天");
        }else {
            System.out.println("您的活跃天数暂时未知！");
        }

    }
}
