package cn.bingai.practice01.demo01;

import java.util.Arrays;
import java.util.Scanner;

/*
题目：将一个数组逆序输出。

程序分析：用第一个与最后一个交换。

总结：
1.只要是设计排序的排序的首先考虑【API中函数调用】
2.只要是涉及【排序】的，【必须】用第三或者更多变量作为【中间量】【交换数据】，【切勿直接交换】
     涉及【最大值】【最小值】时，才考虑三元运算符，【int a > b ? a : b】
3.一般【数组创建】有两种方式：【指定长度】和【指定元素】（可简写），要么定长度，要么定元素
4.【输出数组】一般的两种方式:【循环遍历】和调用API，【Arrays.toString()】方法

//创建数组的第一种方法
int[] arr=new int[6];
int intValue=arr[5];
//System.out.println(intValue);
//创建数组的第二种方法
int[] x={1,2,3,4};
//System.out.println(x[1]);
//创建数组的第三种方法。
int[] y= new int[]{1,2,3,4,5};


输出数组元素的三种方法：
int[] arrays1 = new int[]{1, 2, 3, 4};
// The first method
System.out.println("The first method");
for (int i = 0; i < arrays1.length; i++) {
        System.out.println(arrays1[i]);
        }
// The second method
System.out.println("The second method");
System.out.println(Arrays.toString(arrays1));
// The third method is for multidimensional arrays
System.out.println("The third method is for multidimensional arrays");
       int[][] arrays2 = new int[][]{{1, 2}, {3, 4}};
       System.out.println(Arrays.deepToString(arrays2));
 */
public class Test31pro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组元素：");
//        int[] arr = new int[]{};//error,创建一个int类型的数组,名字为arr 但是里面没有任何东西,所以长度为0
        int[] arr = new int[10];//创建一个长度为10的数组，创建数组要么指定长度，要么指定内容
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

//        System.out.println("您创建的数组是：" + arr.toString());//error,应该调用Arrays中的toString()方法
        System.out.println("您创建的数组是：" + Arrays.toString(arr));

        for (int i = 0; i < arr.length / 2; i++) {
//            arr[i] = arr[arr.length - i -1];//error,应使用第三变量交换的方式
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
//        System.out.println("逆序排列为：" + arr.toString());
        System.out.println("逆序排列为：" + Arrays.toString(arr));


        //方法二：创建第二个数组，将第一个数组逆序个传进第二数组
        System.out.println("==================");
        int[] arr1 = new int[arr.length];
        int j = arr.length;
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = arr[j - 1];
            j--;
        }
        System.out.println("逆序排列为：");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr[i] + " ");
        }









    }
}
