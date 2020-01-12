package com.bingai.review01.Point01.Array;

/*
数组的查找(线性查找、二分法查找)
 */
public class ArrayTest4Find {
    public static void main(String[] args) {
        String[] arr = {"bai", "gai", "bingai", "bin", "Coco", "ming"};

        String str = "bingai";

        boolean isFlag = true;

        for (int i = 0; i < arr.length; i++) {
            if (str.equals(arr[i])) {
                System.out.println("找到了指定的元素，位置为：" + i);
                isFlag = false;
                break;
            }
        }

        if (isFlag) {
            System.out.println("很遗憾，没找到!");
        }

        //二分法查找：
        //前提：所要查找的数组必须有序
        int[] arr1 = {1, 2, 3, 45, 67, 89, 744, 2556, 5254, 56231};

        int dest = 550;
        int head = 0;//初始的索引值
        int end = arr1.length - 1;//末尾的索引值
        boolean isFlag1 = true;
        while(head <= end){
            int middle = (head + end)/2;
            if(dest == arr1[middle]){
                System.out.println("找到了指定的元素，位置为：" + middle);
                isFlag1 = false;
                break;
            }else if(arr1[middle] > dest){
                end = middle - 1;
            }else{//arr1[middle] < dest
                head = middle + 1;
            }
        }
        if(isFlag1){
            System.out.println("很遗憾，没找到!");
        }


    }
}
