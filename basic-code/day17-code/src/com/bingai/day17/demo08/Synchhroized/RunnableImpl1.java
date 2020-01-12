package com.bingai.day17.demo08.Synchhroized;
/*
    卖票问题出现了线程安全问题
    出现了不存在的票和重复的票

    解决线程安全问题的第二种方案：使用同步方法
    静态同步方法

 */
public class RunnableImpl1 implements Runnable {
    //定义一个多线程共享的数据
    private static int ticket = 100;

    //设置线程任务：卖票
    @Override
    public void run() {
        System.out.println(this);//RunnableImpl创建的对象
        //使用循环，让卖票操作重复执行
        while(ticket > 0){
            payTicket();
        }

    }

    /*
        静态同步方法
            锁对象是谁？
            不能是this
            this是创建对象之后产出的，静态方法优先于对象
            静态方法的锁对象是本类的class属性 --> class文件对象
     */
    public static /*synchronized*/ void payTicket(){
        synchronized (RunnableImpl1.class){
            //判断票是否存在
            if(ticket > 0){//票存在，卖票，ticket--
                try {
                    //提高安全 问题出现的可能性，让程序睡眠
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket +"张票");
                ticket--;
            }
        }

    }
}
