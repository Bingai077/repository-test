package com.bingai.review01.Point01.Array;

import java.util.Arrays;

/*
定义一个int型的一维数组，包含10个元素，分别赋一些随机整数，
然后求出所有元素的最大值， 最小值，和值， 平均值， 并输出出来。
要求：所有的随机数都是两位数

[10,99]
公式:(int)(Math.random ()*(99-10+1)+10)//(0,1)*90+10
 */
public class ArrayTest1 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (99 - 10 + 1) + 10);

        }

        System.out.println("数组是：" + Arrays.toString(arr));
        //最大值
        int maxValue = arr[0];
        for (int i : arr) {
            if (maxValue < i) {
                maxValue = i;
            }
        }
        System.out.println("最大值是：" + maxValue);

        //最小值
        int minValue = arr[0];
        for (int i : arr) {
            if (minValue > i) {
                maxValue = i;
            }
        }
        System.out.println("最小值是：" + minValue);

        //和值
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        System.out.println("和是：" + sum);


        //平均值
        int avg = sum / arr.length;
        System.out.println("平均值是：" + avg);

    }
}
