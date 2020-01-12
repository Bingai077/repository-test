package cn.itcast.day05.demo03;
/*
如何获取数组的长度，格式：
数组名称.length

这将会得到一个int数字，代表数组的长度。

数组一旦创建，程序运行期间，长度不可改变。

 */
public class Demo03ArrayLength {

    public static void main(String[] args) {


        int[] arrayA = new int[3];

        int[]  arrayB = {10, 20, 30, 1, 2, 3, 2, 5, 10, 11, 12, 15};
        int len = arrayB.length;
        System.out.println("arrayB数组的长度是：" + len);//12

        System.out.println("========================");

        int[] arrayC = new int[3];//右边是真正的数组，左边是名字
        System.out.println(arrayC.length);//3
        System.out.println(arrayC);//[I@e580929
        arrayC = new int[5];//new创建了新的数组
        System.out.println(arrayC);//[I@1cd072a9
        System.out.println(arrayC.length);//5

    }


}
