package cn.bingai.practice01.demo02.chapter04_OOP1.test5;

import java.util.Arrays;

/*
定义一个int型的数组： int[] arr = new int[]{12,3,3,34,56,77,432};
让数组的每个位置上的值去除以首位置的元素，得到的结果，作为该位置上的
新值。遍历新的数组。
 */
public class Demo {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 3, 3, 34, 56, 77, 432};

        //error
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / arr[0];
        }
        System.out.println(Arrays.toString(arr));

        //right
        int[] arr1 = new int[]{12, 3, 3, 34, 56, 77, 432};
        for (int i = arr1.length - 1; i >= 0; i--) {
            arr1[i] = arr1[i] / arr1[0];
        }
        System.out.println(Arrays.toString(arr1));

        //right
        int[] arr2 = new int[]{12, 3, 3, 34, 56, 77, 432};
        int temp = arr2[0];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] /= temp;
        }
        System.out.println(Arrays.toString(arr2));


    }


}
