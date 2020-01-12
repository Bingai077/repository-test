package com.bingai.day17.demo01.getName;
/*
    获取线程名称：
        1.使用Thread类中的方法getName()
              public String getName() :获取当前线程名称
        2.可以先获取到正在执行的线程，使用线程中的方法getName()获取线程的名称
        public static Thread currentThread() :返回对当前正在执行的线程对象的引用。

 */
//定义一个Thread类的子类
public class MyThread extends Thread{
    //重写Thread中的run方法，设置线程任务
    @Override
    public void run() {
        //获取线程名称方法一
//        String name = getName();
//        System.out.println(name);

        //获取线程名称方法二
        //Thread currentThread = MyThread.currentThread();
        //System.out.println(currentThread);//Thread[Thread-0,5,main]
        //System.out.println(currentThread.getName());//Thread-0

        //链式编程
        System.out.println(MyThread.currentThread().getName());//Thread-0

    }
}
