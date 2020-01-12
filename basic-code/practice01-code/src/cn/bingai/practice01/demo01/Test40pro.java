package cn.bingai.practice01.demo01;

import java.util.Arrays;
import java.util.Scanner;

/*
题目：字符串排序。

无语！这里要用一个封装的方法：booleanb=string1.compareTo(string2);  string1的类型值string2大于，则b是大于零，否者小于零
 */
public class Test40pro {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串的个数：");
        int N = sc.nextInt();
        String[] arr = new String[N];
        System.out.println("请输入字符串数组(按回车)：");
        for (int i = 0; i < arr.length; i++) {
//            arr[i] = sc.nextLine();
            arr[i] = sc.next();//用next()函数
        }
        sc.close();
        System.out.println("您输入的字符串是：" + Arrays.toString(arr));

//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }

        //排序，方法一：使用sort方法
        Arrays.sort(arr);
        System.out.println("排序后为：" + Arrays.toString(arr));


        //方法二：使用compareTo方法
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j].compareTo(arr[j + 1]) < 0) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }
            }
        }
        System.out.println("=================");
        System.out.println(Arrays.toString(arr));

    }

}
