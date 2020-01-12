package cn.bingai.practice01.demo01;

import java.util.Arrays;
import java.util.Scanner;

/*
题目：某个公司采用公用电话传递数据，数据是四位的整数，在传递过程中是加密的，
加密规则如下：每位数字都加上5,然后用和除以10的余数代替该数字，再将第一位和第四位交换，第二位和第三位交换。

程序分析：

1、数字取位，个十百千位分别求出:
例如：4587 % 10 = 7(取个位)
     4587 / 10 % 10 = 8(取十位)
     4587 / 100 % 10 = 5(取百位)
     4587 / 1000 % 10 = 4(取千位)
2、按要求替换

3、按要求交换
 */
public class Test48pro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入4位整数：");
        int num = sc.nextInt();
        System.out.println("加密前的整数为：" + num);

        int[] arr = new int[4];
        for (int i = arr.length -1; i >= 0; i--) {
            arr[i] = (num % 10 + 5) % 10;
            num = num / 10;
        }

        //交换
        int temp = 0;
        temp = arr[0];
        arr[0] = arr[3];
        arr[3] = temp;

        temp = arr[1];
        arr[1] = arr[2];
        arr[2] = temp;

        System.out.println("加密后的整数为：" + arr[0] + arr[1] + arr[2] + arr[3]);



    }
}
