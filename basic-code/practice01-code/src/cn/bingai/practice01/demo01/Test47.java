package cn.bingai.practice01.demo01;

import java.util.Arrays;
import java.util.Scanner;

/*
题目：读取7个数（1—50）的整数值，每读取一个值，程序打印出该值个数的＊。

程序分析：简单方法的调用而已！
 */
public class Test47 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入七个整数(1~50)：");
        int[] arr = new int[7];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();


        for (int i = 0; i < arr.length; i++) {
            System.out.println("输入的数为：" + arr[i]);
            printStar(arr[i]);
        }


    }

    public static void printStar(int n){
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println("                    ");
        System.out.println("====================");
    }




}
