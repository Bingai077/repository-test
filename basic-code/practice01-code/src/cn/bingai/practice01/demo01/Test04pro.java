package cn.bingai.practice01.demo01;

import java.util.Scanner;

/*
题目：将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。

程序分析：对n进行分解质因数，应先找到一个最小的质数k，然后按下述步骤完成：
  1、如果这个质数恰等于n，则说明分解质因数的过程已经结束，打印出即可。
  2、如果n<>k，但n能被k整除，则应打印出k的值，并用n除以k的商,作为新的正整数n,重复执行第一步。
  3、如果n不能被k整除，则用k+1作为k的值,重复执行第一步。

 */
public class Test04pro {
    public static void main(String[] args) {
        System.out.println("请输入一个正整数：");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        System.out.print(input + "=");
        //方法一：
//        for (int i = 2; i <= input; i++) {
//
//            while(input % i == 0){
//                if(input != i){
//                    System.out.print(i + "*");
//                    input = input/i;
//                }else{
//                    break;
//                }
//            }
//
//            if(input == i){
//                    System.out.print(i);
//                    break;
//                }
//        }


        //方法二：
//        for (int i = 2; i <= input; i++) {
//            while (input % i == 0 && input != i) {//2~(input-1)能够被整除，一直往下除
//                System.out.print(i + "*");
//                input = input / i;
//            }
//            if (input == i) {//上面都不能被整除，说明这是一个质数
//                System.out.print(i);
//                break;
//            }
//
//        }


        //方法三 ：
//        int k = 2;
//        if(input == 1){
//            System.out.println(input);
//        }else{
//            while(k<=input){
//                if(k == input){
//                    System.out.print(k);
//                    break;
//                }else if(input % k == 0){
//                    System.out.print(k+"*");
//                    input = input/k;
//                }else{
//                    k++;
//                }
//
//            }
//       }
//       sc.close();





        //方法四：
        deposition(input);
        sc.close();
    }

    public static void deposition(int n){
        if(n==1){//判断该数是否为1，若是，直接打印。
            System.out.print(n);
        }else{
            for (int i = 2; i <= n; i++) {
                if(n%i==0){// 如果n能够被从2开始的i整除，则i即为n的最小质数。
                    if(i==n){//如果此时n == i说明n的最小质数即为本身
                        System.out.print(i);
                        break;
                    }else{
                        System.out.print(i+"*");
                        deposition(n/i); //使用迭代寻找商的最小质数。
                        break;
                    }
                }
            }

        }

    }



}
