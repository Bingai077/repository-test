package cn.bingai.practice01.demo02.chapter08_thread;

/**
 * 【继承】+【Lock锁 + ReentrantLock】/【同步代码块】
 * 实现一个由A、B、C三个窗口同时销售100张票的系统，
 * 要求打印出每个窗口打印的售票情况，并且每个窗口不得连续售票。
 * @author bingai
 * @create 2019-11-01 9:36
 */

class Win implements Runnable{

    private int tick = 100;

//    ReentrantLock lock = new ReentrantLock();//一定要用ReentrantLock 创建对象

    @Override
    public void run() {
        while(true){

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            lock.lock();
            //synchronized (this) {
                SellTicket();
            //}
//            lock.unlock();

            if(tick == 0){
                break;
            }

        }
    }

    private synchronized void SellTicket() {
        if(tick > 0){
            System.out.println(Thread.currentThread().getName() + "正在卖第" + tick + "张票");
            tick--;
        }
    }
}

public class Test07 {
    public static void main(String[] args) {
        Win win = new Win();
        new Thread(win,"窗口1").start();
        new Thread(win,"窗口2").start();
        new Thread(win,"窗口3").start();


    }
}
