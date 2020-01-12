package cn.bingai.practice01.demo02.chapter08_thread;

/**
 * @author bingai
 * @create 2019-11-01 9:02
 */

public class Test06 {

    private static int I = 0;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    I++;
                    System.out.println(Thread.currentThread().getName() + ":" + i + ",I=" + I);
                }

            }
        },"线程一").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    I--;
                    System.out.println(Thread.currentThread().getName() + ":" + i + ",I=" + I);
                }

            }
        },"线程二").start();






    }
}
