package cn.itcast.day05.demo03;
/*
遍历数组，说的就是对数组当中的每一个元素进行逐一、挨个儿处理。
默认的处理方式就是打印输出。
 */

public class Demo04Array {
    public static void main(String[] args) {
        int[] array = {15,25,20,40,50,65,75,85};

        //首先使用原始方式
        System.out.println(array[0]);//15
        System.out.println(array[1]);//25
        System.out.println(array[2]);//20
        System.out.println(array[3]);//40
        System.out.println(array[4]);//50
        System.out.println("=================");

        //使用循环，次数其实就是数组的长度
        for (int i = 0; i < 5 ; i++) {
            System.out.println(array[i]);

        }
        System.out.println("===================");

        //len = array.length;

        for (int i = 0; i < array.length; i++) {//快捷方式：数组名称.fori
            System.out.println(array[i]);

        }


    }

}
