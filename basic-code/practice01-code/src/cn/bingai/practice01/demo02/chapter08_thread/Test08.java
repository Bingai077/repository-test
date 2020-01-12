package cn.bingai.practice01.demo02.chapter08_thread;

/**
 * 【继承】+/【同步代码块】：static（票唯一） + Win1.class（锁唯一）
 * 实现一个由A、B、C三个窗口同时销售100张票的系统，
 * 要求打印出每个窗口打印的售票情况，并且每个窗口不得连续售票。
 *
 * @author bingai
 * @create 2019-11-01 9:36
 */

class Win1 extends Thread {

    private static int tick = 100;//保证票唯一

    public Win1(String name) {
        super(name);
    }


    @Override
    public void run() {
        while (true) {


            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (Win1.class) {//保证锁唯一
                if (tick > 0) {
                    System.out.println(Thread.currentThread().getName() + "正在卖第" + tick + "张票");
                    tick--;

                } else {
                    break;
                }
            }
        }
    }
}

public class Test08 {
    public static void main(String[] args) {

        new Win1("窗口1").start();
        new Win1("窗口2").start();
        new Win1("窗口3").start();


    }
}
