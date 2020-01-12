package cn.bingai.practice01.demo02.chapter03_array;

import java.util.Arrays;

/*
【冒泡排序法】对数组进行排序
for (int i = 0; i < arr.length; i++) {
            for (int j = 0; 【j < arr.length - i - 1】; j++) {
                if (【arr[j] > arr[j + 1]】) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
 */
public class Test14pro {
    public static void main(String[] args) {
        int[] arr = {1, 2, 44, 5, 4, 221, 6, 2552, 252, 1021, 52, 402, 22, 520, 21};
        System.out.println("排序前" + Arrays.toString(arr));
        //从小到大
        int[] arr1 = Order(arr);
        System.out.println("排序后" + Arrays.toString(arr1));
    }

    private static int[] Order(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
