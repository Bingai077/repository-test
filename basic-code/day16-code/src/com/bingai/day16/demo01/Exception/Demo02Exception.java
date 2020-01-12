package com.bingai.day16.demo01.Exception;
/*
    异常产生过程解析（分析异常是怎么产生的，如何处理异常）

 */
public class Demo02Exception {
    public static void main(String[] args) {
        //创建int类型数组，并赋值
        int[] arr = {1,2,3};
        int e = getElement(arr,3);
        System.out.println(e);


    }

    /*
        定义一个方法，获取数组指定索引处的元素
        参数：
            int[] arr
            int index
     */
    public static int getElement(int [] arr,int index){
        int ele = arr[index];
        return ele;
    }
}
