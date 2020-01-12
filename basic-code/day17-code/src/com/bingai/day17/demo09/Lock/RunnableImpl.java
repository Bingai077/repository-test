package com.bingai.day17.demo09.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    卖票问题出现了线程安全问题
    出现了不存在的票和重复的票

    解决线程安全问题的第三种方案：使用Lock锁
    java.util.concurrent.locks.Lock接口  机制提供了比synchronized代码块和synchronized方法更广泛的锁定操作
    Lock接口中的方法：
        public void lock() :加同步锁。
        public void unlock() :释放同步锁。
    java.util.concurrent.locks.ReentrantLock impluments Lock接口

    使用步骤：
        1.在成员位置创建一个ReentrantLock对象
        2.在可能出现安全问题的代码前调用Lock接口中的方法Lock获取锁
        3.在可能出现安全问题的代码后调用Lock接口中的方法unLock释放锁

 */
public class RunnableImpl implements Runnable {
   //定义一个多线程共享的数据
    private int ticket = 100;

    //1.在成员位置创建一个ReentrantLock对象
    Lock lock = new ReentrantLock();
//    ReentrantLock re = new ReentrantLock();

    //设置线程任务：卖票
    @Override
    public void run() {
        //使用循环，让卖票操作重复执行
        while(ticket > 0){

            //2.在可能出现安全问题的代码前调用Lock接口中的方法Lock获取锁
            lock.lock();

            //提高安全问题出现的概率，让程序睡眠
            try {
                Thread.sleep(10);
                //判断票是否存在
                if(ticket > 0){//票存在，卖票，ticket--
                    System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket +"张票");
                    ticket--;
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally{
                //3.在可能出现安全问题的代码后调用Lock接口中的方法unLock释放锁
                lock.unlock();//无论程序是否异常，都会释放锁对象
            }

        }


    }
/*    //设置线程任务：卖票
    @Override
    public void run() {
        //使用循环，让卖票操作重复执行
        while(ticket > 0){

           //2.在可能出现安全问题的代码前调用Lock接口中的方法Lock获取锁
           lock.lock();

           //提高安全问题出现的概率，让程序睡眠
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //判断票是否存在
            if(ticket > 0){//票存在，卖票，ticket--
                System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket +"张票");
                ticket--;
            }

            //3.在可能出现安全问题的代码后调用Lock接口中的方法unLock释放锁
            lock.unlock();
        }


    }*/
}
