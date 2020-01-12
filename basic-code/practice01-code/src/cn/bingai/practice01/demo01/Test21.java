package cn.bingai.practice01.demo01;
/*
题目：求1+2!+3!+...+20!的和

程序分析：此程序只是把累加变成了累乘。

1、先求该项阶乘的值

2、累加求求

 */
public class Test21 {

    public static void main(String[] args) {
//        int a = 1 ;
        int temp = 1;
        int sum =0;
        for (int i = 1; i <= 20; i++) {
            temp = temp * i;
            sum = sum + temp;
        }
        System.out.println("和为："+ sum);

    }

}
