package cn.bingai.practice01.demo02.chapter01_grammar;

import java.util.Scanner;

/*
判断一个数的奇偶性

【注意】：sc.close();输入完毕后关闭io流

三元运算符 表达式1 ? 表达式2 ： 表达式3
等价于 if...else...
 */
public class Test08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入任意数字：");
        int i = sc.nextInt();
        sc.close();

//        if(i % 2 == 0){
//            System.out.println("输入的数是偶数！！");
//        }else{
//            System.out.println("输入的数是奇数！");
//        }
        String str = (i % 2 == 0) ? "输入的数是偶数！！" : "输入的数是奇数！";
        System.out.println(str);


    }

}
