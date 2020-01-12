package cn.bingai.practice01.demo02.chapter03_array;

import java.util.Scanner;

/*
    矩阵,Z形矩阵,S形矩阵,回形矩阵的java实现，矩阵的形式很多

 */
public class Test12pro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入矩阵规模(行数或者列数)：");
        int n = scanner.nextInt();
        scanner.close();

        System.out.println("==========正常矩阵=========");
        mat1(n);
        System.out.println("==========S型矩阵=========");
        mat2(n);
    }

    private static void mat1(int n) {
        int[][] arrays = new int[n][n];
        int count = 1;
        //赋值
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                arrays[i][j] = count++;
            }
        }
        //遍历
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                System.out.print(arrays[i][j] + "\t");
            }
            System.out.println();
        }


    }

    //S型
    private static void mat2(int n) {
        int[][] arrays = new int[n][n];
        int count = 1;
        //赋值
        for (int i = 0; i < arrays.length; i++) {

            for (int j = 0; j < arrays[i].length; j++) {
                if (i % 2 == 0) {
                    arrays[i][j] = count++;
                } else {
                    arrays[i][n - j - 1] = count++;
                }
            }
        }

        //遍历
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                System.out.print(arrays[i][j] + "\t");
            }
            System.out.println();
        }

    }



    }
