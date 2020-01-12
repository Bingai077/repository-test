package cn.bingai.practice01.demo01;
/*
题目：利用递归方法求5!。

程序分析：递归公式：f(n)=n*f(n-1)

不断的调用方法，直到最小的值确定

 */
public class Test22 {

    public static void main(String[] args) {

        System.out.println(fun(5));
    }

    public static int fun(int n){
       if(n == 1){//如果n等于1，返回1
           return 1;
       }else {
           return n * fun(n - 1);
       }
    }
}
