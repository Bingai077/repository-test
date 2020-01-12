package com.bingai.day17.demo04.Runnable;
/*
    创建多线程程序的第二种方式：实现Runnable接口
    java.lang.Runnable
        Runnable 接口应该由那些打算通过某一线程执行其实例的类来实现。类必须定义一个称为 run 的无参数方法。
    java.lang.Thread
        public Thread(Runnable target) :分配一个带有指定目标新的线程对象。
        public Thread(Runnable target,String name) :分配一个带有指定目标新的线程对象并指定名字。

    实现步骤：
        1.创建一个Runnable接口的实现类
        2.在实现类中重写Runnable接口的run方法，设置线程任务
        3.创建一个Runnable接口的实现类对象
        4.创建Thread类对象，构造方法中传递Runnable接口的实现类对象
        5.调用Thread类中的start方法，开启新的线程，执行run方法

    实现Runnable接口创建多线程的程序的好处
        1.避免了单继承的局限性
              一个类只能继承extends一个类(一个人只能有一个亲爹)，类继承了Thread类不能继承其他的类
              实现impluments了Runnable接口，还可以继承其他的类，实现其他接口
        2.增强了程序的扩展性，降低了程序的耦合性
              实现Runnable接口的方式，把设置线程任务和开启新的线程进行了分离（解耦）
              实现类中，重写了run方法：用来设置线程任务
              创建Thread类对象，调用start方法：用开启新的线程
 */
public class Demo01Runnable {
    public static void main(String[] args) {
        //3.创建一个Runnable接口的实现类对象
        RunnableImpl runnable = new RunnableImpl();

        //4.创建Thread类对象，构造方法中传递Runnable接口的实现类对象
        //5.调用Thread类中的start方法，开启新的线程，执行run方法
        new Thread(runnable).start();//打印线程名称

        new Thread(new RunnableImpl2()).start();//打印HelloWorld

        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + i);

        }
    }
}
