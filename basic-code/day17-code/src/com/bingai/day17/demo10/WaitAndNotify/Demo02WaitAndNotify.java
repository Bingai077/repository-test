package com.bingai.day17.demo10.WaitAndNotify;
/*
    进入到TimeWaiting（计时等待）有两种方式
    1.使用sleep(long m)方法，在毫秒值结束之后，线程睡醒进入到Runnable/Blocked状态
    2.使用wait(long m)方法，wait方法如果在毫秒值结束之后，还没有被notify唤醒，就会自动醒来，线程醒来进入到Runnable/Blocked状态

    唤醒的方法：
         void notify() 唤醒在此对象监视器上等待的单个线程。
         void notifyAll() 唤醒在此对象监视器上等待的所有线程。

 */
public class Demo02WaitAndNotify {
    public static void main(String[] args) {
        //创建锁对象，保证唯一
        Object obj = new Object();

        //创建一个顾客线程(消费者)
        new Thread(){
            @Override
            public void run() {
                while(true){//一直等着买包子
                    //保证等待和唤醒的线程只能有一个执行，需要使用同步技术
                    synchronized (obj){
                        System.out.println("告知老板要的包子的种类和数量");
                        try {
                            //调用wait方法，放弃cpu的执行，进入到Watting状态（无限等待）
                            obj.wait(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //唤醒后执行的代码
                        System.out.println("包子已经做好了，顾客1开吃");
                        System.out.println("============================");
                    }
                }

            }
        }.start();


        //创建一个顾客线程(消费者)
        new Thread(){
            @Override
            public void run() {
                while(true){//一直等着买包子
                    //保证等待和唤醒的线程只能有一个执行，需要使用同步技术
                    synchronized (obj){
                        System.out.println("告知老板要的包子的种类和数量");
                        try {
                            //调用wait方法，放弃cpu的执行，进入到Watting状态（无限等待）
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //唤醒后执行的代码
                        System.out.println("包子已经做好了，顾客2开吃");
                        System.out.println("============================");
                    }
                }

            }
        }.start();



        //创建一个老板线程(生产者)
        new Thread(){
            @Override
            public void run() {

                while(true){//一直做包子
                    try {
                        Thread.sleep(5000);//花了5秒做包子
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (obj){
                        //做好包子之后，调用notify方法，唤醒顾客吃包子
                        System.out.println("老板5秒钟之后做好包子，告知顾客，可以吃包子了");
                        //obj.notify();//如果有多个线程等待，随机唤醒一个
                        obj.notifyAll();//唤醒所有等待的线程
                    }
                }
            }
        }.start();
    }

}
