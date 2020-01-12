package com.bingai.day17.demo01.getName;
/*
    线程的名称：
        主线程：main
        新线程：Thread-0、Thread-1、Thread-2
 */
public class Demo01GetThreadName {
    public static void main(String[] args) {
        //创建Thread类的子类对象
        MyThread myThread = new MyThread();
        //调用start方法,开启新线程，执行run方法
        myThread.start();

        MyThread myThread1 = new MyThread();
        myThread1.start();

        MyThread myThread2 = new MyThread();
        myThread2.start();

        new MyThread().start();
        new MyThread().start();


        System.out.println(Thread.currentThread().getName());//main

    }

}
