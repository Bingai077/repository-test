package cn.itcast.day08.demo04;

import java.util.Arrays;

/*
java.util.Arrays是一个与数组相关的工具类，里面提供了大量的静态方法，用来实现数组常用的操作。

public static String toString(数组)：将参数数组变成字符串（按照默认格式：[元素1，元素2，元素3...]）
public static void sort(数组)：按照默认升序（从小到大）对数组的元素进行排序。

备注：
1.如果是数值，sort默认按照升序从小到大
2.如果是字符串，sort默认按照字母升序
3.如果是自定义的类型，那么这个自定义的类需要有Comparable或者Comparator接口的支持。（今后学习）

 */
public class Demo01Arrays {

    public static void main(String[] args) {
        int[] array = {10, 20, 30};
        //将int[]数组按照默认格式变成字符串
        String instr = Arrays.toString(array);
        System.out.println(instr);//[10, 20, 30]

        int[] array1 = {2, 3, 42, 50, 5512, 4, 58, 32};
        Arrays.sort(array1);
        System.out.println(Arrays.toString(array1));//[2, 3, 4, 32, 42, 50, 58, 5512]

        String[] array2 = {"aaa", "ddd", "ccc", "bbb"};
        Arrays.sort(array2);
        System.out.println(Arrays.toString(array2));
    }

}
