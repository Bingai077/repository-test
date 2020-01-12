package com.bingai.day17.demo08.Synchhroized;
/*
    卖票问题出现了线程安全问题
    出现了不存在的票和重复的票

    解决线程安全问题的第二种方案：使用同步方法
    使用步骤：
        1.把访问了共享数据的代码抽取出来，放到一个方法中
        2.在方法上添加synchronized修饰符

     格式：定义方法的格式
     修饰符  synchronize 返回值类型 方法名(参数列表){
        可能会出现线程安全问题的代码（访问了共享数据的代码）
     }

 */
public class RunnableImpl implements Runnable {
   //定义一个多线程共享的数据
    private int ticket = 100;

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
        定义一个同步方法
        同步方法也会把方法内部的代码锁住
        只让一个线程执行
        同步对象的锁对象是谁？
        就是实现类对象 new RunnableImpl
        也就是this(RunnableImpl创建的对象runnable)
     */
    public synchronized void payTicket(){
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
