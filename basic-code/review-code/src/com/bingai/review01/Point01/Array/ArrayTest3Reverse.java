package com.bingai.review01.Point01.Array;

import java.util.Arrays;

/*
数组的复制、反转、查找(线性查找、二分法查找)

 */
public class ArrayTest3Reverse {
    public static void main(String[] args) {

        String[] arr = {"bai","gai","bingai","bin","Coco","ming"};


        //数组的复制(区别于数组的赋值，arr1 = arr)
        String[] arr1 = new String[arr.length];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[i];
        }

        //数组的反转，方法一
        String[] arr2 = new String[arr.length];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i]=arr[arr.length - i -1];
            System.out.print(arr2[i] + " ");
        }

        //反转方法二
        for (int i = 0; i < arr.length/2; i++) {
            String temp = arr[i];
            arr[i] = arr[arr.length - i -1];
            arr[arr.length-i-1] = temp;
        }
        System.out.println();
        System.out.println(Arrays.toString(arr));

        //方法三：
        for (int i = 0,j = arr.length-1;  i < j; i++,j--) {
            String temp = arr1[i];
            arr1[i] = arr1[j];
            arr1[j] = temp;
        }
        System.out.println(Arrays.toString(arr1));





    }
}
