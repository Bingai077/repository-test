package cn.bingai.practice01.demo02.chapter08_thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 【继承】+【Lock锁 + ReentrantLock】/【同步方法】  :static【保证方法，属性唯一】
 * 实现一个由A、B、C三个窗口同时销售100张票的系统，
 * 要求打印出每个窗口打印的售票情况。
 *
 * @author bingai
 * @create 2019-11-01 9:36
 */

class Win2 extends Thread {

    private static int tick = 100;//保证票唯一



    public Win2(String name) {
        super(name);
    }


    @Override
    public void run() {
        while (true) {

            SellTicket();

            if(tick == 0){
                break;
            }

        }
    }

    static ReentrantLock lock = new ReentrantLock();
    private static /*synchronized*/ void SellTicket() {

        lock.lock();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(tick > 0){
            System.out.println(Thread.currentThread().getName() + "正在卖第" + tick + "张票");
            tick--;
        }
        lock.unlock();
    }
}

public class Test09 {
    public static void main(String[] args) {

        new Win2("窗口1").start();
        new Win2("窗口2").start();
        new Win2("窗口3").start();


    }
}
