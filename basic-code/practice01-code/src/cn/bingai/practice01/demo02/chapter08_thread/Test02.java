package cn.bingai.practice01.demo02.chapter08_thread;

/**
 * 利用多线程设计一个程序，同时输出 50 以内的奇数和偶数，以及当前运行的线程名。
 * @author bingai
 * @create 2019-10-31 17:14
 */

class MyThread1 implements Runnable{


    @Override
    public synchronized void run() {
        for (int i = 0; i <= 50; i++) {
            if(i % 2 == 1){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }

        /*try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}

class MyThread2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 50; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}



public class Test02 {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();

        new Thread(t1).start();
        new Thread(t2).start();

    }
}
