package cn.bingai.practice01.demo02.chapter02_flowcontrol;

import java.util.Scanner;

/*
判断用户输入月份的季节

【注意】switch语句中，case语句结束后有个break，最后尽量用default语句收尾
switch (month){
            case 12:
            case 1:
            case 2:
                s = "冬季";
                break;
           default:
}

 */
public class Test06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入月份：");
        int month = sc.nextInt();
        sc.close();

        String s = null;
        switch (month){
            case 12:
            case 1:
            case 2:
                s = "冬季";
                break;
            case 3:
            case 4:
            case 5:
                s = "春季";
                break;
            case 6:
            case 7:
            case 8:
                s = "夏季";
                break;
            case 9:
            case 10:
            case 11:
                s = "秋季";
                break;
            default:
                s ="您的输入有误！";
        }

        System.out.println(s);


    }
}
