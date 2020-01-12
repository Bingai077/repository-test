package cn.bingai.practice01.demo01;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
题目：有一个已经排好序的数组。现输入一个数，要求按原来的规律将它插入数组中。

程序分析：首先判断此数是否大于最后一个数，然后再考虑插入中间的数的情况，插入后此元素之后的数，依次后移一个位置。

1、创建两个数组，如果插入的数字比数组最后一个都大，那么插入的数放在新数组最后就可以
2、如果插入的不是最大，那么和数组前面的数逐一比较，比较到比插入的数大就break
比如第i个符合条件，那么arrB[i-1]=arrA[i-1],arrB[i]=num,arrB[i+1]=arrA[i]

 */
public class Test30pro {
    public static void main(String[] args) {
        //生成9个随机数放入第一个数组arr1中
        int[] arr1 = new int[9];
        Random r = new Random();
        for (int i = 0; i < 9; i++) {
            arr1[i] = r.nextInt(1000);
        }
        Arrays.sort(arr1);
        String str1 = Arrays.toString(arr1);
        System.out.println(str1);

        //输入一个数
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int num = sc.nextInt();

        //创建另一个数组arr2,将arr1复制进去，增加一个元素，再利用sort排序
        int[] arr2 = Arrays.copyOf(arr1,10);
        arr2[9] = num;
        Arrays.sort(arr2);
        String str2 = Arrays.toString(arr2);
        System.out.println(str2);


/*
数组扩容三种方法：
①    int[] arr2=new int[arr1.length*2]   //新数组长度

        for(int i=0;i<arr1.length;i++){     //复制

            arr2[i]=arr1[i];
        }

 ②    int[] arr2=java.util.Arrays.copyOf(原数组名，新数组长度);

 ③    int[] arr2=new int[arr1.length*2]
        System.arraycopy(原数组名，起始下标，新数组名，起始下标，复制长度);

 */
//         方法二：
//        int[] arr2 = new int[10];
//        if (num > arr1[8]) {
//            for (int i = 0; i < 9; i++) {
//                arr2[i] = arr1[i];
//            }
//            arr2[9] = num;
//        } else {
//            for (int i = 0; i < 9; i++) {
//                if (num < arr1[i]) {
//                    for (int j = 0; j < i; j++) {
//                        arr2[j] = arr1[j];
//                    }
//                    arr2[i] = num;
//                    for (int j = i; j < 9; j++) {
//                        arr2[j + 1] = arr1[j];
//                    }
//                    break;
//                }
//            }
//        }
//
//        System.out.println("插入后数组为：" + Arrays.toString(arr2));


//        int[] arr2 = new int[1];
//        arr2[0] = num;
//        String str2 = Arrays.toString(arr2);
//        String str3 = str1.concat(str2);
//        char[] ch = str3.toCharArray();
//        Arrays.sort(ch);
//        System.out.println(Arrays.toString(ch));


        sc.close();

    }
}
