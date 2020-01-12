package cn.bingai.practice01.demo02.chapter08_thread;

/**
 * 1)启动两个线程对一个数字i操作（10分）
 * 2)其中1个线程每次对i加1（10分）
 * 3)另1个线程每次对i减一（10分）
 * 4)各运行20次，结果i的值等于初始值。（20分）
 *
 * @author bingai
 * @create 2019-11-01 13:54
 */

class Test {
    private int num;

    public Test(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public synchronized void plusNum() {

        notify();
        num++;
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void decNum() {
        notify();
        num--;
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Plus implements Runnable {
    private Test test;

    public Plus(Test test) {
        this.test = test;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {

            test.plusNum();
            System.out.println(Thread.currentThread().getName() + "第" + i + "次输出:---" + test.getNum());

        }

    }
}

class Dec implements Runnable {
    private Test test;

    public Dec(Test test) {
        this.test = test;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            test.decNum();
            System.out.println(Thread.currentThread().getName() + "第" + i + "次输出:" + test.getNum());

        }

    }
}


public class Test13 {
    public static void main(String[] args) {
        Test t = new Test(3);
        Plus p = new Plus(t);
        Dec d = new Dec(t);

        new Thread(p, "线程1").start();
        new Thread(d, "线程2").start();


    }

}
