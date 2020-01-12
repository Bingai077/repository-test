package com.bingai.day18.demo02.ThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
    线程池：JDK1.5之后提供的
    java.util.concurrent.Executors：线程池的工厂类，用来生产线程池
    Executors类中的静态方法：
        public static ExecutorService newFixedThreadPool(int nThreads) ：返回线程池对象。(创建的是有界线程池,也就是池中的线程个数可以指定最大数量)
        参数：
            int nThreads：创建线程池中包含的线程数量
        返回值：
            ExecutorService接口，返回的是ExecutorService接口的实现类对象，我们可以使用ExecutorService接口接收（面向接口编程）
    java.util.concurrent.ExecutorService:线程池接口
        用来从线程池中获取线程，调用start方法，执行线程任务
            public Future<?> submit(Runnable task) :获取线程池中的某一个线程对象，并执行
        关闭/销毁线程池的方法
             void shutdown() 启动一次顺序关闭，执行以前提交的任务，但不接受新任务。

    线程池的使用步骤：
        1.使用线程池的工厂类Executors里边提供的静态方法newFixedThreadPool生产一个指定线程数量的线程池
        2.创建一个类，实现Runnable接口，重写run方法，设置线程任务
        3.调用ExecutorService中的submit，传递线程任务（实现类），开启线程，执行run方法
        4.调用ExecutorService中的方法shutdown销毁线程池（不建议执行）
 */
public class Demo01ThreadPool {
    public static void main(String[] args) {
        //1.使用线程池的工厂类Executors里边提供的静态方法newFixedThreadPool生产一个指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(2);

        //3.调用ExecutorService中的submit，传递线程任务（实现类），开启线程，执行run方法
        service.submit(new RunnableImpl());//pool-1-thread-2创建了一个新的线程
        //线程池会一直开启，使用完了线程，会自动把线程归还给线程池，线程可以继续使用
        service.submit(new RunnableImpl());//pool-1-thread-1创建了一个新的线程
        service.submit(new RunnableImpl());//pool-1-thread-2创建了一个新的线程

        //service.shutdown();//一般不用
        //service.submit(new RunnableImpl());//抛异常，线程池都没了，就不能获取线程了

    }

}
