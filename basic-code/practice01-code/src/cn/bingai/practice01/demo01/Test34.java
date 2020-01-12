package cn.bingai.practice01.demo01;

import java.util.Arrays;
import java.util.Scanner;

/*
题目：输入3个数a,b,c，按大小顺序输出。

 */
public class Test34 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入三个数：");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        sc.close();

        int[] num = {a, b, c};
        Arrays.sort(num);
        System.out.println("从小到大为：");
        System.out.println(Arrays.toString(num));//从小到大

        System.out.println("从大到小为：");
        for (int i = num.length - 1; i >= 0; i--) {
            System.out.print(num[i] + " ");
        }

        //方法二：
        System.out.println("               ");
        System.out.println("===============");
        int t = 0;
        if (a < b) {
            t = a;
            a = b;
            b = t;
        }
        if (a < c) {
            t = a;
            a = c;
            c = t;
        }

        if (b < c) {
            t = b;
            b = c;
            c = t;
        }
        System.out.println("从大到小顺序为：" + a + " " + b + " " + c);


    }

}
