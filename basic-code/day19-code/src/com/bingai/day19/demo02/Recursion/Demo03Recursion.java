package com.bingai.day19.demo02.Recursion;
/*
    递归求阶乘
    n！ = n * (n-1) * (n-2) * (n-3) *...* 3 * 2 * 1
 */
public class Demo03Recursion {
    public static void main(String[] args) {

        System.out.println(fun(5));
    }

    /*
        递归结束条件：n = 1
        目的：获取下一个被乘的数字(n-1)
        每次方法的参数发生变化
        5，4,3,2,1
     */
    private static int fun(int n){
        if(n == 1){
            return 1;
        }
        return n*fun(n-1);
    }

}
