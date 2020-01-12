package com.bingai.day17.demo02.setName;
/*
    设置线程的名称：
        1.使用Thread类中的方法setName(名字)
            void setName(String name):  改变线程名称，使之与参数 name 相同。
        2.创建一个带参数的构造方法，参数传递线程的名称；调用父类的带参构造方法，把线程名称传递给父类，让父类（Thread）给子线程起一个名字
            public Thread(String name) : 分配一个指定名字的新的线程对象。分配一个带有指定目标新的线程对象

 */
public class MyThread extends Thread{
    public MyThread(){

    }

    public MyThread(String name){
        super(name);
    }

    @Override
    public void run() {
        //获取线程名称
        System.out.println(Thread.currentThread().getName());
    }


}
