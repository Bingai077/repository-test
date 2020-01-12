package cn.bingai.practice01.demo02.chapter08_thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 【实现Callable+FutureTask】+【Lock锁+ReentrantLock】
 * 实现一个由A、B、C三个窗口同时销售100张票的系统，
 * 要求打印出每个窗口打印的售票情况，并且每个窗口不得连续售票。
 * @author bingai
 * @create 2019-11-01 9:36
 */

class Win4 implements Callable{

    private int tick = 100;

    ReentrantLock lock = new ReentrantLock();
    @Override
    public Object call() throws Exception {
        while(true){

            lock.lock();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(tick > 0){
                System.out.println(Thread.currentThread().getName() + "正在卖第" + tick + "张票");
                tick--;
            }else{
                break;
            }
            lock.unlock();
        }


        return null;
    }
}

public class Test10 {
    public static void main(String[] args) {

        Win4 win4 = new Win4();
        FutureTask task = new FutureTask(win4);

        new Thread(task,"窗口1").start();
        new Thread(task,"窗口2").start();
        new Thread(task,"窗口3").start();


    }
}
