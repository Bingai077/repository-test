package com.bingai.day17.demo09.Lock;

/*
    模拟卖票案例
    创建3个线程，同时开启，对共享的票进行出售
 */
public class Demo01Ticket {
    public static void main(String[] args) {
        //创建Runnable接口的实现类对象
        RunnableImpl runnable = new RunnableImpl();//为了实现共享，只能创建一个实现类
        //创建Thread类对象，构造方法中传递Runnable接口的实现类对象
        //调用start方法开启多线程
        new Thread(runnable,"bingai").start();
        new Thread(runnable,"斌改").start();
        new Thread(runnable,"明明").start();


    }
}
