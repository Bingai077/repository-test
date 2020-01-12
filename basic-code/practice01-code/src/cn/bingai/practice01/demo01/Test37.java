package cn.bingai.practice01.demo01;

import java.util.ArrayList;
import java.util.Scanner;

/*
题目：有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，问最后留下的是原来第几号的那位。
关键问题是怎么移除》？:布尔值确定，如果被选中被赋值为false

从第一个人开始判断，如果他在圈内，那么报数，再判断他报的数是否是3，如果是的话移出圈外
接着判断下一个人，是否到了最末，如果是的话，从零开始不断循环，直到最后剩下1个人


 */
public class Test37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入总人数：");
        int N = sc.nextInt();
        sc.close();

        boolean[] arr = new boolean[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = true;
        }

        int countNum = N;//总人数
        int index = 0;//索引
        int count = 0;//计数
        while (countNum > 1) {
            if (arr[index]) {
                count++;
                if (count == 3) {
                    arr[index] = false;
                    count = 0;
                    countNum--;//总人数在这减
                }
            }

            index++;//索引在前面加
            //if (index == countNum) //会出现数组越界异常
            if (index == N) {//一轮一循环
                index = 0;
            }

//            index++;
//            countNum--;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                System.out.println("最终剩余第" + (i + 1) + "号");

            }

        }


        //方法二：把编号放入集合，使用集合添加、删除
        System.out.println("=================");
        method(N);


    }

    public static void method(int N) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(i + 1);//1,2,3,4...
        }

//        int countNum = N;//总人数
        int index = 0;//索引
        int count = 1;//计数

        while (list.size() > 1) {
            if (index == list.size()) {
                index = 0;
            }
            if (count == 3) {
                list.remove(index);
                count = 1;
                index--;
            } else {
                count++;
            }
            index++;
        }
        System.out.println("最终剩余第" + list + "号");


    }


}
