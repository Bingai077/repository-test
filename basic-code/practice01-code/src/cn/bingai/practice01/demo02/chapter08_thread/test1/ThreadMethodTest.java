package cn.bingai.practice01.demo02.chapter08_thread.test1;

/**
 * 测试Thread中的常用方法：
 * 1.void start(): 启动线程，并执行对象的run()方法
   2.run(): 线程在被调度时执行的操作
   3.String getName(): 返回线程的名称
   4.void setName(String name):设置该线程名称
   5.static Thread currentThread(): 返回当前线程
   6.yield():释放当前cpu执行权
   7.join():在线程a中调用线程b的join()方法，此时线程a就进入阻塞状态，直到线程b完全执行后，线程a才结束阻塞状态
   8.stop():已过时。当执行此方法时，强制结束当前线程。
   9.sleep(long millitime):让当前线程睡眠指定的millitime毫秒。在指定的millitime毫秒内，当前线程是阻塞状态
   10.isAlive():判断当前线程是否存活。

 线程的优先级：
 MAX_PRIORITY： 10
 MIN _PRIORITY： 1
 NORM_PRIORITY： 5
 如何获取和设置当前线程的优先级：
 getPriority() ： 返回线程优先值
 setPriority(int newPriority) ： 改变线程的优先级

 说明：高优先级线程要抢占低优先级CPU的执行权。
       但是从概率上讲，高优先级的线程高概率执行，并不意味着先执行
 * @author bingai
 * @create 2019-10-30 19:39
 */
public class ThreadMethodTest {
    public static void main(String[] args) {

        MyThread h1 = new MyThread("Thread一");
       // h1.setName("线程一");

        //设置分线程的优先级
        h1.setPriority(Thread.MAX_PRIORITY);

        h1.start();


        //给主线程命名
        Thread.currentThread().setName("主线程");

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + Thread.currentThread().getPriority() + ":" + i);
            }
            /*if(i == 20){
                try {
                    h1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }*/

        }
        System.out.println(h1.isAlive());


    }

}

class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {

//                try {
//                    sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                System.out.println(Thread.currentThread().getName() + Thread.currentThread().getPriority() + ":" + i);
            }
        }
    }
//            if(i % 20 == 0){
//                yield();
//            }

    public MyThread(String name) {
        super(name);
    }

    public MyThread(){

    }
}

