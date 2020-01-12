package cn.bingai.practice01.demo02.chapter02_flowcontrol;

import java.util.Scanner;

/*
判断某一年是否为闰年

四年一闰 百年不闰 四百年再闰

运算符的优先级：   !   >   &&   >    ||


 */
public class Test01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年份：");
        int year = scanner.nextInt();
        scanner.close();

        if(year % 4 == 0  && year % 100 != 0 || year% 400 ==0){
            System.out.println("该年为闰年");
        }else{
            System.out.println("该年不为闰年");

        }

    }
}
