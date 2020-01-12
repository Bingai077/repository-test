package com.bingai.review01.Point01.Array;

import java.util.Arrays;

/*
使用简单数组
(1)创建一个名为ArrayTest的类，在main()方法中声明array1和array2两个变量，
他们是int[]类型的数组。
(2)使用大括号{}，把array1初始化为8个素数： 2,3,5,7,11,13,17,19。
(3)显示array1的内容。
(4)赋值array2变量等于array1，修改array2中的偶索引元素，使其等于索引值
(如array[0]=0,array[2]=2)。打印出array1。

思考： array1和array2是什么关系？
拓展： 修改题目，实现array2对array1数组的复制
array1和array2地址值相同，都指向了堆空间中唯一的数组实体

 */
public class ArrayTest2CopyPro {
    public static void main(String[] args) {
        int[] array1 = {2, 3, 5, 7, 11, 13, 17, 19};
        System.out.println(Arrays.toString(array1));

        //数组的复制
        int[] array2 = new int[array1.length];
        for (int i = 0; i < array2.length; i++) {
            if(i % 2 ==0){
                array2[i]= array1[i];
            }
        }
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));

    }
}
