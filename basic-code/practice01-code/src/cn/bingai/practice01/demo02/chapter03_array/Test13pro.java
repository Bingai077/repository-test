package cn.bingai.practice01.demo02.chapter03_array;

import java.util.Arrays;

/*
  【选择排序法】对数组进行排序

  for (int i = 0; i < arr.length; i++) {
           for (【int j = i + 1】; j < arr.length; j++) {
                if (【arr[i] < arr[j]】) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
 */
public class Test13pro {
    public static void main(String[] args) {
        int[] arr = {1, 2, 44, 5, 4, 221, 6, 2552, 252, 1021, 52, 42, 22, 520, 21};
        System.out.println("排序前" + Arrays.toString(arr));
        //从小到大
        int[] arr1 = descOrder(arr);
        System.out.println("排序后" + Arrays.toString(arr1));

        //从大到小
        int[] arr2 = escOrder(arr);
        System.out.println("排序后" + Arrays.toString(arr2));

    }

    private static int[] escOrder(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    private static int[] descOrder(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;

    }


}
