package cn.bingai.practice01.demo02.chapter08_thread.test1;

/**
 * 多线程的创建，方式一：继承于Thread类
 * 1.创建一个继承于Thread的子类
 * 2.重写Thread类的run方法 --> 将此线程执行的操作声明在run方法中
 * 3.创建Thread子类的对象
 * 4.通过此对象调用start()
 * <p>
 * 例子：遍历100以内所有的偶数
 *
 * @author bingai
 * @create 2019-10-30 18:55
 */
//1.创建一个继承于Thread的子类
class myThread extends Thread {
    //2.重写Thread类的run方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
//                System.out.println(i);
            }
        }
    }
}


public class ThreadTest1 {
    public static void main(String[] args) {
        //3.创建Thread子类的对象
        myThread t1 = new myThread();

        //4.通过此对象调用start():1.启动当前线程 2.调用当前线程的run()
        t1.start();//不能直接调run()方法
        //【问题一】：我们不能通过直接调用run()的方式启动线程
        //t1.run();

        //【问题二】：再启动一个线程，遍历100以内的偶数,不可以还让已经start()的线程去执行
        //t1.start();//IllegalThreadStateException

        //需要重新创建一个线程
        myThread t2 = new myThread();
        t2.start();




        //如下的操作仍然在main线程中执行
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
//                System.out.println(i + "***main()***");
            }
        }
        System.out.println("hello");


    }

}
