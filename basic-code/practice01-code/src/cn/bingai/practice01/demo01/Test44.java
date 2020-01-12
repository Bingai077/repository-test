package cn.bingai.practice01.demo01;

import java.util.Scanner;

import static java.lang.Math.sqrt;

/*
题目：一个偶数总能表示为两个素数之和。

程序分析：判断两个加数是不是素数

素数的判断前面做过很多了，不说了！

 */
public class Test44 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个偶数：");
        int num = sc.nextInt();
        sc.close();

        if (num % 2 == 0) {
            for (int i = 0; i <= num; i++) {
                for (int j = 0; j <= num / 2; j++) {
                    if (isPrime(i) && isPrime(j) && num == (i + j)) {
                        System.out.println(num + "能表示为两个素数之和" + num + "=" + i + "+" + j);

                    }
                }

            }


        } else {
            System.out.println("输入的数不是偶数，请重新输入！");
        }

    }

    //只能被自己和1整除
    public static boolean isPrime(int n) {
        boolean flag = false;
        for (int i = 2; i <= sqrt(n); i++) {
            if (n % i == 0) {
                flag = false;
            } else {
                flag = true;
            }
        }
        return flag;
    }

}
