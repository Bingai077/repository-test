package cn.bingai.practice01.demo01;

import java.util.Arrays;
import java.util.Scanner;

/*
题目：输入数组，最大的与第一个元素交换，最小的与最后一个元素交换，输出数组。


程序分析：1、找到该数组的最大值和最小值,找到该数组最大项把它和第一位交换，找到该数值的最小项把它和最后一项交换

这里有一点值得注意：不能把最大值和最小值先找出来，再连续执行两次操作交换，会出错！

还有一点要注意：没叫到要交换的数值的位置不变，我在网上查了的都会有乱序的

 */
public class Test35 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组长度：");
        int n = sc.nextInt();

        System.out.println("请输入一个数组：");
        int[] arr = new int[n];
//        int n = 0;
//        while(sc.hasNextInt()){//判断下一个输入是否是int
//            arr[n++] = sc.nextInt();//不断往数组中存值
//            if(n == 10 ){
//                break;
//            }
//        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();//关闭IO流

       // int[] arr = {1, 2, 0,520,888,120,1,23,1,5,1,23};


        //找到最大值
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        //最大值与第一个元素交换
        for (int i = 0; i < arr.length; i++) {
            int temp = 0;
            if(arr[i] == max){
                temp = arr[i];
                arr[i] = arr[0];
                arr[0] = temp;
            }
        }


        //找到最小值
        int min = arr[1];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min){
                min = arr[i];
            }
        }
        //最小的与最后一个元素交换
        for (int i = 0; i < arr.length; i++) {
            int temp = 0;
            if(arr[i] == min){
                temp = arr[i];
                arr[i] = arr[arr.length - 1];
                arr[arr.length-1] = temp;
            }
        }

        System.out.println(Arrays.toString(arr));



    }
}
