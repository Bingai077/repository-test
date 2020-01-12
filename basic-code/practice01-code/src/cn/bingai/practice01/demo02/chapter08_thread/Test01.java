package cn.bingai.practice01.demo02.chapter08_thread;

/**
 * 编写一个继承Thread类的方式实现多线程的程序。该类MyThread有两个属性，一个字符串WhoAmI代表线程名，一个整数delay代表该线程随机要休眠的时间。构造有参的构造器，线程执行时，显示线程名和要休眠时间。
 另外，定义一个测试类TestThread，创建三个线程对象以展示执行情况。
 * @author bingai
 * @create 2019-10-31 17:04
 */

class MyThread extends Thread{
    private String WhoAml;
    private int delay;

    public MyThread(String whoAml, int delay) {
        WhoAml = whoAml;
        this.delay = delay;
    }


    @Override
    public void run() {

        try {
            sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("I am " + WhoAml + ",I sleep" + delay +"毫秒");
    }
}

public class Test01 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("Thread-1", (int) (Math.random() * 100));
        MyThread t2 = new MyThread("Thread-2", (int) (Math.random() * 100));
        MyThread t3 = new MyThread("Thread-3", (int) (Math.random() * 100));

        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();

    }

}
