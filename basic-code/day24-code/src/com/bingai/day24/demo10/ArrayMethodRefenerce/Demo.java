package com.bingai.day24.demo10.ArrayMethodRefenerce;

import java.util.Arrays;

/*
    数组的构造器引用
 */
public class Demo {
    /*
        定义一个方法，
        方法的参数传递创建数组的长度和ArrayBuilder接口
        方法内部根据传递的长度使用ArrayBuilder中的方法创建数组并返回
     */
    public static int[] creatArray(int length,ArrayBuilder ab){
        return ab.builderArray(length);
    }

    public static void main(String[] args) {
        //调用creatArray方法，传递数组的长度和Lambda表达式
        int[] array1 = creatArray(10, (len) -> {
            //根据数组的长度创建数组并返回
            return new int[len];
        });

        //简化Lambda表达式
        int[] array2 = creatArray(10, len-> new int[len]);

        /*
            使用方法引用优化Lambda表达式
            已知创建的就是int[]数组
            数组的长度是已知的
            int[]引用new，根据参数传递的长度来创建数组
         */
        int[] array = creatArray(10, int[]::new);

        System.out.println(Arrays.toString(array));

    }



}
