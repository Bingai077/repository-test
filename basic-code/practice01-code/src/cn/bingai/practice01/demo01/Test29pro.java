package cn.bingai.practice01.demo01;

import java.util.Arrays;
import java.util.Scanner;

/*
    题目：求一个3*3矩阵对角线元素之和

    程序分析：利用双重for循环控制输入二维数组，再将a[i][i]累加后输出。

     */
public class Test29pro {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入9个矩阵元素：");

        //输入矩阵元素
        int[][] arr = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        //打印二维矩阵元素
        System.out.println("输入的矩阵为：" );
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        //方法二：打印二维数组元素，deepToString()方法
        System.out.println(Arrays.deepToString(arr));;

        //输出对角线之和
        int sum = 0;
        int sum1 =0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i == j){
                    sum = sum + arr[i][j];
                }
                if(i + j == 2){
                    sum1 = sum1 + arr[i][j];
                }
            }
        }
        System.out.println("矩阵主对角线之和为：" + sum);
        System.out.println("矩阵副对角线之和为：" + sum1);
        sc.close();


    }
}
