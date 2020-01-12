package cn.bingai.practice01.demo02.chapter08_thread.test1;

/**
 *使用同步方法解决继承Thread类方式中的线程安全问题
 * @author bingai
 * @create 2019-10-31 10:23
 */

class Window4 extends Thread{

    private static int ticket = 100;//保证票只有100张，加static
    private static Object obj = new Object();//保证锁唯一，加static关键字

    @Override
    public void run() {
        while(true){
            //synchronized(Window.class){//用【类做对象】，保证了【唯一性】，类只加载了一次 Class class = Window.class

            show();
            // }

        }
    }

    //private synchronized void show(){//同步监视器：t1，t2，t3,此种解决方式是错误的
    private static synchronized void show(){//同步监视器：当前类Window4.class，当前类唯一
        if(ticket > 0) {

            System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
            ticket--;
        }
    }


}
public class WindowTest4 {

    public static void main(String[] args) {
        Window4 t1 = new Window4();
        Window4 t2 = new Window4();
        Window4 t3 = new Window4();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}



