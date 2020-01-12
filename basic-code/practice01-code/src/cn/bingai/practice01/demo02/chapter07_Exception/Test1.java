package cn.bingai.practice01.demo02.chapter07_Exception;

import org.junit.Test;

/*
编写一个类ExceptionTest， 在main方法中使用try、 catch、 finally，要求：
在try块中，编写被零除的代码。
在catch块中，捕获被零除所产生的异常，并且打印异常信息
在finally块中，打印一条语句。


【体会】：使用try-catch-finally处理编译时异常，使得程序在编译时不再报错，但运行时仍然可能报错。
         相当于我们使用try- catch - finally将一个【编译时可能出现的异常】,【延迟到运行时出现】。
 */
public class Test1 {

    @Test
    public void test1() {
        int a = 3;
        int b = 0;
        try {
            int c = a / b;
        } catch (ArithmeticException e) {
            String message = e.getMessage();
            e.printStackTrace();
        } finally {
            System.out.println("程序结束了！");
        }
    }

}
