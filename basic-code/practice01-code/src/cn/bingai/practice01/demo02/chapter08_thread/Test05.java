package cn.bingai.practice01.demo02.chapter08_thread;

/**
 * 编写龟兔赛跑多线程程序，设赛跑长度为100米，
 * 每跑完10米输出一次结果。
 *
 * 改进上题的龟兔赛跑程序，通过改变优先级，并减掉休眠时间，
 * 使得乌龟以迅雷不及掩耳的速度跑完100米。
 *
 * @author bingai
 * @create 2019-11-01 8:44
 */


class Tortoise implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "准备起跑");
        for (int i = 0; i <= 100; i = i + 10) {

            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
        System.out.println(Thread.currentThread().getName() + "到达终点");


    }
}

class Rabbit implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "准备起跑");
        for (int i = 0; i <= 100; i = i + 10) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
        System.out.println(Thread.currentThread().getName() + "到达终点");
    }
}

public class Test05 {
    public static void main(String[] args) {

        Rabbit r = new Rabbit();
        Tortoise t = new Tortoise();

        Thread thread1 = new Thread(r, "乌龟");
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();

        Thread thread2 = new Thread(t, "兔子");
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread2.start();

    }

}
