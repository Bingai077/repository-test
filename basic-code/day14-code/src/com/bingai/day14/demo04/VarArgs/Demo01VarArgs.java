package com.bingai.day14.demo04.VarArgs;

/*
    可变参数：是JDK1.5之后出现的新特性
    使用前提：
        当方法的参数列表数据类型已经确定，但是参数的个数不确定，就可以使用可变参数。
    使用格式：定义方法时使用
        修饰符  返回值类型  方法名(数据类型 ... 变量名){}
    可变参数的原理：
        可变参数的底层就是一个数组，根据传递参数个数不同，会创建不同长度的数组，来存储这些参数
        传递的参数个数，可以是0个(不传递)，1,2...多个

    【注意事项】
         1.一个方法的参数列表，只能有一个可变参数
         2.如果一个方法的参数有多个，那么可变参数就必须写在参数列表的末尾

    可变参数的【终极写法】
        public static void method1(Object ... obj){

    }

 */
public class Demo01VarArgs {
    public static void main(String[] args) {

        //int i = add(10,20,30,40,50,60,70,80,90,100);
        int i = add(10, 20);
        System.out.println(i);

        method("abc",0.551,1,2,2,5,15);
    }

    /*public static void method(int ... a,String ... b){

    }*/
    public static void method(String b, double c, int... a) {

    }

    public static void method1(Object ... obj){

    }



    /*
        定义计算(0 ~ n)整数和的方法
        已知：计算整数的和，数据类型已经确定int
        但是参数的个数不确定，不知道要计算几个整数的和，就可以使用可变参数
        add();就会创建一个长度为0的数组，new int[0]
        add(10);就会创建一个长度为1的数组，存储传递过来的参数 new int[1]{10}
        add(10,20);就会创建一个长度为2的数组，存储传递过来的参数 new int[2]{10,20}
        add(10,20,30,40,50,60,70,80,90,100);就会创建一个长度为10的数组，存储传递过来的参数 new int[10]{10,20,30,40,50,60,70,80,90,100}


     */
    public static int add(int... arr) {
//        System.out.println(arr);//[I@71e7a66b，底层是一个数组
//        System.out.println(arr.length);//0//1//2//10
        //定义一个初始化的变量，记录累加求和
        int sum = 0;
        //遍历数组，获取数组中的每一个元素
        for (int i : arr) {
            sum += i;//累加求和
        }
        return sum;//返回求和结果
    }

/*


    //定义一个方法，计算三个int类型整数的和
    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    //定义一个方法，计算两个int类型整数的和
    public static int add(int a, int b) {
        return a + b;
    }
*/

}
