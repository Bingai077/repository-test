package cn.bingai.practice01.demo02.chapter08_thread.test3;

/**
 * 线程通信的例子：使用两个线程打印1-100.线程1，线程2，交替打印
 *
 * 涉及到三个方法：
 * wait():一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器
 * notify():一旦执行此方法，就会唤醒被wait的线程，如果有多个线程被wait，就唤醒优先级高的那个。
 * notifyAll():唤醒所有被wait的线程。
 *
 * 说明：
 * 1.wait()、notify()、notifyAll()三个方法必须使用在同步代码块或同步方法中
 * 2.这三个方法的调用者必须是同步代码块或同步方法中的同步监视器
 *   否则会出现IllegalMonitorStateException异常
 * 3.这三个方法定义在java.lang.Object类中
 *
 * 面试题：sleep()和wait()方法的异同
 * 1.相同点：一旦执行方法，都可以使得当前的线程进入阻塞状态
 * 2.不同点：（1）两个方法声明的位置不同：Thread类中声明sleep()，Object类中声明wait()
 *          （2）调用的要求不同：sleep()可以在任何需要的场景下调用。wait方法必须使用在同步代码块和同步方法中
 *          （3）关于是否释放同步监视器：如果两个方法都使用在同步代码块或同步方法中，sleep()不会释放锁，wait会释放锁
 *
 * @author bingai
 * @create 2019-10-31 12:15
 */
class Number implements Runnable{

    private int num = 1;
    private Object obj = new Object();
    @Override
    public void run() {
        while (true){
            synchronized (obj) {
                if(num <= 100){

                    obj.notify();

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num++;

                    try {
                        //使得调用如下wait()方法的线程进入阻塞状态
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else{
                    break;
                }
            }
        }
    }
}

public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number,"线程一  ");
        Thread t2 = new Thread(number,"线程二");
        t1.start();
        t2.start();


    }
}
