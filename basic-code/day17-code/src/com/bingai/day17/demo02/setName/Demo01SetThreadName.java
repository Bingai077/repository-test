package com.bingai.day17.demo02.setName;

public class Demo01SetThreadName {
    public static void main(String[] args) {
        //开启多线程
        MyThread myThread = new MyThread();
        myThread.setName("斌改");
        myThread.start();

        //开启多线程
        new MyThread("明明").start();
    }
}
