package cn.bingai.practice01.demo01;

import java.util.Scanner;

/*
题目：一个5位数，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同。
这个程序跟上一个程序类似。
创建一个五位数的数组
逐次取位
组后判断条件就可以了
 */
public class Test25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个五位数：");
        int num = sc.nextInt();

        if (num > 99999 || num < 10000) {
            System.out.println("输入有误，请重新输入！");
        } else {

            String str = Integer.toString(num);
            char[] chars = str.toCharArray();
            if (chars[0] == chars[4] && chars[1] == chars[3]) {
                System.out.println("它是回文数");
                } else {
                System.out.println("它不是回文数");
                }

                sc.close();

//            boolean temp = false;
//            for (int i = 0; i < chars.length; i++) {
//                if (chars[0] == chars[4] && chars[1] == chars[3]) {
//                    temp = true;
//                } else {
//                    temp =false;
//                }
//            }
//
//            if (temp){
//                System.out.println("它是回文数");
//            }else{
//                System.out.println("它不是回文数");
//
//            }


            //拓展：
//            int j=ch.length;     
//            for(int i=0; i<j/2; i++) {     
//                if(ch[i]!=ch[j-i-1]) {
//                is=false;
//            }     
//            }     
//            if(is==true){
//                System.out.println("这是一个回文数");
//            } else {
//                System.out.println("这不是一个回文数");
//            }     
//        }


        }

    }

}
