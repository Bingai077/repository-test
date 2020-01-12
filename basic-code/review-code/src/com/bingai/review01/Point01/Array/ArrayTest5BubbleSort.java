package com.bingai.review01.Point01.Array;

/*
数组的排序：【冒泡排序】
思想：
    1. 比较相邻的元素。如果第一个比第二个大（升序），就交换他们两个。
    2. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步
    做完后，最后的元素会是最大的数。
    3. 针对所有的元素重复以上的步骤，除了最后一个。
    4. 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要
    比较为止。
 */
public class ArrayTest5BubbleSort {
    public static void main(String[] args) {
        int[] arr = {12, 124, 5, 5, 4, 4, 512, 5, 5, 2145, 142, 523, 2, 5, 5632, 535, 2};

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        //冒泡排序
        for (int i = 0; i < arr.length - 1; i++) {//经过n-1轮比较
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }


        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
