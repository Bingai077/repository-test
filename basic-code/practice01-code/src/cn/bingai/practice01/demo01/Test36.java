package cn.bingai.practice01.demo01;

import java.util.Arrays;
import java.util.Scanner;

/*
题目：有n个整数，使其前面各数顺序向后移m个位置，最后m个数变成最前面的m个数

程序分析：在原来数组的基础上还要创建一个和原来数组大小一样的数组

根据要移动的位数把原来的数组分割成两个部分分别赋值给新的数组

 */
public class Test36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组元素个数：");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("请输入数组元素：");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("请输入移动位数：");
        int m = sc.nextInt();
        sc.close();

        //方法一：
        if (m >= n) {
            System.out.println("输入有误，请重新输入！");
        } else {
            int[] arr1 = new int[n];
            for (int i = 0; i < arr.length; i++) {

                //if( n-m+i<arr.length){
                if (i < m) {
                    arr1[i] = arr[n - m + i];
                } else {
                    arr1[i] = arr[i - m];
                }
            }
            System.out.println(Arrays.toString(arr1));
        }

        //方法二：分为两部分再for循环,m可以大于n
        System.out.println("============================");
        m = m % n;//n个一循环
        int[] arr2 = new int[n];
        int k = m;
        for (int i = m; i < arr.length; i++) {//后一半
            arr2[i] = arr[i - m];
        }
        for (int i = 0; i < m; i++) {//前一半
            arr2[i] = arr[arr.length - k];
            k--;
        }
        System.out.println(Arrays.toString(arr2));


    }


}

