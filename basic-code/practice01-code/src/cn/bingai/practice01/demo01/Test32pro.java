package cn.bingai.practice01.demo01;

import java.util.Scanner;

/*
题目：取一个整数a从右端开始的4～7位。
(1)先使a右移4位。
(2)设置一个低4位全为1,其余全为0的数。可用~(~0<<4)
(3)将上面二者进行&运算。



 */
public class Test32pro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个长整数：");
        Long num = sc.nextLong();
        sc.close();

        String str = num.toString();
        char[] ch = str.toCharArray();
        int n = ch.length;
        if (n < 7) {
            System.out.println("输入的整数不够长，请重新输入！");
        } else {
            System.out.print("整数从右端开始的4～7位为：" + ch[n - 4] + ch[n - 5] + ch[n - 6] + ch[n - 7]);
        }


        //方法二，题中所提方法，用右移4位，然后 &1111，即为所求
//        System.out.println("                   ");
//        System.out.println("====================");
//        long num1 = 15;
//        num = num >> 4;//  >> 表示按位右移
//        long result = num & num1;
//
//        if (n < 7) {
//            System.out.println("输入的整数不够长，请重新输入！");
//        } else {
//            System.out.print("整数从右端开始的4～7位为：" + result);
//        }


        //方法三：直接从Long型整数中取index索引编号
        System.out.println("                   ");
        System.out.println("====================");
        String s = String.valueOf(num);
        int n1 = s.length();
            System.out.println("整数从右端开始的4～7位为：" + s.charAt(n1 - 4)+ s.charAt(n1 - 5)+ s.charAt(n1 - 6)+ s.charAt(n1 - 7) );


    }

}
