package cn.bingai.practice01.demo02.chapter08_thread.test1;

public class ThreadDemo {

    public static void main(String[] args) {
//        MyThread1 myThread1 = new MyThread1();
//        myThread1.start();
//
//        MyThread2 myThread2 = new MyThread2();
//        myThread2.start();

//        new MyThread1().start();
//        new MyThread2().start();

        //创建Thread类的匿名子类
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if(i % 2 == 0){
                        System.out.println(Thread.currentThread().getName() + ":" +i);
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if(i % 2 == 1){
                        System.out.println(Thread.currentThread().getName() + ":" +i);
                    }
                }
            }
        }.start();

    }
}

class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" +i);
            }
        }
    }
}

class MyThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 1){
                System.out.println(Thread.currentThread().getName()  + ":"+ i);
            }
        }
    }
}