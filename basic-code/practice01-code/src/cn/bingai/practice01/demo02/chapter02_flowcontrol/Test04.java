package cn.bingai.practice01.demo02.chapter02_flowcontrol;

import java.util.Scanner;

/*
    根据收入情况计算个人所得税
 */
public class Test04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的工资(减五险一金后)：" );
        double i = sc.nextDouble();
        sc.close();

        double s = 0;//税钱
        if(i <= 3500){
            System.out.println("您不需要纳税");
        }else if(i > 3500 && i <= 5000){
            s = (i - 3500) * 0.03;
        }else if(i > 5000 && i <= 8000){
            s = (i - 3500) * 0.1 - 105;
        }else if(i > 8000 && i <= 12500){
            s = (i - 3500) * 0.2 - 555;
        }else if(i > 12500 && i <= 38500){
            s = (i - 3500) * 0.25 - 1005;
        }else if(i > 38500 && i <= 58500){
            s = (i - 3500) * 0.3 - 2775;
        }else if(i > 58500 && i <= 83500){
            s = (i - 3500) * 0.35 - 5505;
        }else{
            s = (i - 3500) * 0.45 - 13505;
        }

        System.out.println("您需要缴税的金额为：" + s);

    }
}
