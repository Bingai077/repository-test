package cn.itcast.day08.demo04;
/*
java.util.Math类是数学相关的工具类，里面提供了大量的静态方法，完成与数学运算相关的操作。

public static double abs(double num):获取绝对值。有多种重载。
public static double ceil(double num):向上取整。
public static double floor(double num):向下取整。
public static lang round(double num):四舍五入。

Math.PI代表近似的圆周率常量（double）。

 */
public class Demo03Math {
    public static void main(String[] args) {
        //获取绝对值
        System.out.println(Math.abs(3.14));//3.14
        System.out.println(Math.abs(-3.14));//3.14
        System.out.println("==========");

        //向上取整
        System.out.println(Math.ceil(3.9));//4.0
        System.out.println(Math.ceil(3.001));//4.0
        System.out.println(Math.ceil(3.00));//3.0
        System.out.println("==========");

        //向下取整,抹零
        System.out.println(Math.floor(30.99));//30.0
        System.out.println(Math.floor(31.00));//31.0
        System.out.println("==========");

        //四舍五入,lang类型没有小数点
        System.out.println(Math.round(20.49999));//20
        System.out.println(Math.round(19.50000));//20

        System.out.println(Math.PI);//3.141592653589793



    }

}
