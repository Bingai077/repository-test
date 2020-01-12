package cn.bingai.practice01.demo01;

import java.util.Scanner;

/*
题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，
小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，
问每个月的兔子总数为多少？

分析：
兔子的规律为数列:1,1,2,3,5,8,13,21....
a[n]=a[n-1]+a[n-2]
第一第二项都知道了，后面的值也可以求得
 */
public class Test01pro {
    public static void main(String[] args) {
        System.out.println("请输入你想知道的月份：");
        Scanner sc = new Scanner(System.in);//new一个Scanner类
        int num = sc.nextInt();//使用Scanner类中的一个方法


        if (num == 1 || num == 2) {
            System.out.println("第" + num + "个月兔子的总对数为：1");
        } else if (num >= 3) {
            int a = 1, b = 1;
            int c;
            for (int i = 3; i < num; i++) {
                c = b;
                b = a + c;
                a = c;
            }
            System.out.println("第" + num + "个月兔子的总对数为：" + b);
        } else {
            System.out.println("输入有误，请重新输入！");
        }


        System.out.println("方法二");
        System.out.println("请输入你想知道的月份：");
        Scanner sc1 = new Scanner(System.in);
        int num1 = sc.nextInt();
        if(num1 > 0){
            System.out.println("第" + num1 +"个月兔子的总数为：" + fun(num1));
        }else{
            System.out.println("输入月份有误，请重新输入！");
        }



    }


    public static int fun(int n){
        if(n == 1 || n ==2){
            return 1;
        }else{
            return fun(n-1) + fun(n-2);
        }

    }



}




