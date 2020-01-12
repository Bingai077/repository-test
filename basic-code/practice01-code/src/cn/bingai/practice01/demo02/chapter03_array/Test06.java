package cn.bingai.practice01.demo02.chapter03_array;

import java.util.Arrays;

/*
    使用最简单的for循环对数组进行排序

 */
public class Test06 {
    public static void main(String[] args) {
        int[] array = {124,58,4435,851,53,31,4524,521,1,4};
        System.out.println("排序前的数组是：" + Arrays.toString(array));
        Arrays.sort(array);
        System.out.println("排序后的数组是：" + Arrays.toString(array));

    }
}
