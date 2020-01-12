package cn.bingai.practice01.demo01;

import java.util.Scanner;

/*
题目：给一个不多于5位的正整数，要求：一、求它是几位数，二、逆序打印出各位数字。

程序分析：创建一个五位数数的数组，把输入数字的每位数的值赋值到数组里面
把输入 数字从个位起获取，并且每获取一次之后/10，这样就能分别获取十位百位千位了
把数字打印出来就是题目所求了
 */
public class Test24pro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入任意的数字（范围：0~10000）：");
        int num = sc.nextInt();

        if (num < 0 || num >= 10000) {
            System.out.println("输入有误，请重新输入！");
        } else {

//            int a = num / 1000;//千位
//            int b = (num - a * 1000) / 100;//百位
//            int c = (num - a * 1000 - b * 100) / 10;//十位
//            int d = num - a * 1000 - b * 100 - c*10;//个位
//
//            if(a == 0){
//                System.out.println();
//            }

            String str = Integer.toString(num);
            char[] ch = str.toCharArray();
            System.out.println("它是" + ch.length + "位数");
            System.out.println("它的逆序排列为：");

            for (int i = ch.length - 1; i >= 0; i--) {
                System.out.print(ch[i] + " ");
            }


            //方法二：
//            int[] arr = new int[5];
//            int i = 0;
//            for (i = 0; i < 5; i++) {//循环储存
//                arr[i] = num % 10;
//                num = num / 10;
//                if (num == 0) {
//                    break;
//                }
//            }
//            System.out.println("输入数字的位数是：" + (i + 1));
//            System.out.println("逆序排列为：");
//            for (int j = 0; j <= i; j++) {
//                System.out.print(arr[j] + " ");
//
//            }


        }

    }
}
