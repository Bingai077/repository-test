package cn.bingai.practice01.demo02.chapter08_thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 【线程池 + Executors】+【Lock锁+ReentrantLock】
 * 实现一个由A、B、C三个窗口同时销售100张票的系统，
 * 要求打印出每个窗口打印的售票情况，并且每个窗口不得连续售票。
 * @author bingai
 * @create 2019-11-01 9:36
 */

class Win5 implements Callable{

    private int tick = 100;

    //ReentrantLock lock = new ReentrantLock();
    @Override
    public Object call() throws Exception {
        while(true){

            //lock.lock();
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
            //lock.unlock();
        }


        return null;
    }
}

public class Test11 {
    public static void main(String[] args) {

        Win5 win5 = new Win5();
        FutureTask task = new FutureTask(win5);



        ExecutorService service = Executors.newFixedThreadPool(10);
        service.submit(new Thread(task));
        service.submit(new Thread(task));
        service.submit(new Thread(task));

        service.shutdown();


    }
}
