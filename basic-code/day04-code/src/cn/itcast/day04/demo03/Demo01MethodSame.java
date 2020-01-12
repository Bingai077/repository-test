package cn.itcast.day04.demo03;

/*
题目要求：
定义一个方法，用来判断两个数字是否相同。
//是否一出现就是boolean值
 */

public class Demo01MethodSame {

    public static void main(String[] args) {

        System.out.println(isSame(10,20));//false
        System.out.println(isSame(10,10));//true
    }

    /*
    返回值类型：boolean
    方法名称：IsSame
    参数列表：int a, int b
     */
    public static boolean isSame(int a, int b){
         /*boolean same;
        if (a == b){
            same = true;
        }else {
            same = false;
        }*/

//      boolean same = a == b ? true : false;

//        boolean same = a == b;
//        return same;

        return a == b;

    }


}
