package cn.bingai.practice01.demo01;

import java.util.Scanner;

/*
题目：编写一个函数，输入n为偶数时，调用函数求1/2+1/4+...+1/n,当输入n为奇数时，调用函数1/1+1/3+...+1/n(利用指针函数)

程序分析：

1、先判断是奇数还是偶数

2、分数分子都是一，偶数分母从2开始，奇数的分母从1开始，分母差值都为2

 【特别注意】：数据类型转换，不然结果不对
 */

public class Test39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个正整数：");
        int n = sc.nextInt();
        sc.close();

//        double t = 0;
        double sum = 0;
        if (n % 2 == 0) {
            for (/*int*/double i = 2; i <= n; i = i + 2) {//数据类型为double
//                t = 1/i;
//                sum = sum + t;
                sum += 1 / i;//或者sum += (double)1/i;

                //输出等式
                if(i == n){
                    System.out.print("1/" + (int) i);
                }else{
                    System.out.print("1/" + (int) i + "+");
                }


            }
        } else {
            for (/*int*/double i = 1; i <= n; i = i + 2) {
//                t = 1 / i;
//                sum = sum + t;
                sum += 1 / i;
                if(i == n){
                    System.out.print("1/" + (int) i);
                }else{
                    System.out.print("1/" + (int) i + "+");
                }
            }
        }
        System.out.println("=" + sum);
    }

    /*public static int method1(int n){
        return 1;

    }

    public static int method2(int n){
        return 1;

    }*/
}
