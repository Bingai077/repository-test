package cn.bingai.practice01.demo02.chapter03_array;

import java.util.Scanner;

/*
    回形数格式方阵的实现
    从键盘输入一个整数（1~20）
    则以该数字为矩阵的大小，把1,2,3…n*n 的数字按照顺时针螺旋的形式填入其中。例如： 输入数字2，则程序输出：
    1 2
    4 3
    输入数字3，则程序输出：
    1 2 3
    8 9 4
    7 6 5
    输入数字4， 则程序输出：
    1   2   3   4
    12  13  14  5
    11  16  15  6
    10  9   8   7

 */
public class Test11Pro {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入矩阵规模(行数或者列数)：");
        int n = scanner.nextInt();
        scanner.close();

        int[][] arrays = new int[n][n];
        int count = 1;
        //k表示圈数
        for (int i = 0; i < n / 2; i++) {
            //绘制第一条线（上）
            for (int j = i, k = i; k < n - i - 1; k++) {
                arrays[j][k] = count++;
            }
            //绘制第二条线（右）
            for (int j = i, k = n - i - 1; j < n - i - 1; j++) {
                arrays[j][k] = count++;
            }
            //绘制第三条线（下）
            for (int j = n - i - 1, k = n - i - 1; k > i; k--) {
                arrays[j][k] = count++;
            }
            //绘制第四条线（左）
            for (int j = n - i - 1, k = i; j > i; j--) {
                arrays[j][k] = count++;
            }

        }
        //奇数阵，中心填充
        if (n % 2 == 1) {
            arrays[n / 2][n / 2] = count;
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
