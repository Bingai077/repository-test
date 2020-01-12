package com.bingai.day17.demo03.sleep;
/*
    public static void sleep(long millis) :使当前正在执行的线程以指定的毫秒数暂停（暂时停止执行）。
    毫秒数结束后，线程继续执行

 */
public class Demo03Sleep {
    public static void main(String[] args) {
        //模拟秒表
        for (int i = 0; i < 100; i++) {

            System.out.println(i);

            //使用Thread类的sleep方法让程序睡眠1秒种
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
