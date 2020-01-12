package cn.itcast.day05.demo02;

public class Demo01ArrayTwo {

    public static void main(String[] args) {
        int[] arrayA = new int[3];//动态初始化
        System.out.println(arrayA);//地址值[I@71e7a66b
        System.out.println(arrayA[0]);//0
        System.out.println(arrayA[1]);//0
        System.out.println(arrayA[2]);//0
        System.out.println("===============");

        //改变数组中元素的内容
        arrayA[1] = 10;
        arrayA[2] = 20;
        System.out.println(arrayA);//地址值[I@71e7a66b
        System.out.println(arrayA[0]);//0
        System.out.println(arrayA[1]);//10
        System.out.println(arrayA[2]);//20

        int[] arrayB = new int[3];//动态初始化
        System.out.println(arrayB);//地址值[I@2ac1fdc4
        System.out.println(arrayB[0]);//0
        System.out.println(arrayB[1]);//0
        System.out.println(arrayB[2]);//0
        System.out.println("===============");

        //改变数组中元素的内容
        arrayB[1] = 100;
        arrayB[2] = 200;
        System.out.println(arrayB);//地址值[I@2ac1fdc4
        System.out.println(arrayB[0]);//0
        System.out.println(arrayB[1]);//100
        System.out.println(arrayB[2]);//200
    }

}
