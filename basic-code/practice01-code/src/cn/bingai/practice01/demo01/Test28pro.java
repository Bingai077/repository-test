package cn.bingai.practice01.demo01;

import java.util.Arrays;
import java.util.Scanner;

/*
题目：对10个数进行排序

程序分析：可以利用选择法，即从后9个比较过程中，选择一个最小的与第一个元素交换，下次类推，即用第二个元素与后8个进行比较，并进行交换。

最后打印出来的数组就是从小到大排列的数组了
 */
public class Test28pro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入10个数(用空格隔开)：");
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        //排序方法一
        Arrays.sort(arr);

        //排序方法二
        int temp = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = i + 1; j < 10; j++) {
                if(arr[i]>arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        //读取方法一
        System.out.println(Arrays.toString(arr));

        //读取方法二
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }



    }

}
