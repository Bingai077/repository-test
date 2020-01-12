package cn.itcast.day05.demo04;

/*
数组可以作为方法的参数。
当调用方法的时候，向方法的小括号进行传参，传进去的其实是数组的地址。

 */

public class Demo01ArrayParam {
    public static void main(String[] args) {
        int[] array = {10,20,30,40,50};

        System.out.println(array);//地址值

        printArray(array);
        System.out.println("=====aaa=====");
        printArray(array);
        System.out.println("====bbb=====");
        printArray(array);

       /* for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        System.out.println("aaa");

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        System.out.println("bbb");

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }*/

    }

    /*
    三要素：
    返回值类型：只是进行打印而已，不需要进行计算，也没有结果，用void
    方法名称：printArray
    参数列表：必须给数组，才能打印其中的元素。int[] array

     */
    public static void printArray(int[] array){//数组也可以作为参数

        System.out.println("printArray方法收到的参数是：");
        System.out.println(array);//地址值
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }
}
