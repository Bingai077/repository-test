package com.bingai.day17.demo06.ThreadSafe;

public class RunnableImpl implements Runnable {
   //定义一个多线程共享的数据
    private int ticket = 100;

    //设置线程任务：卖票
    @Override
    public void run() {
        //使用循环，让卖票操作重复执行
        while(ticket > 0){
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
        }


    }
}
