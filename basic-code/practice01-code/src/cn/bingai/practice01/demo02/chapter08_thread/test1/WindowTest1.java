package cn.bingai.practice01.demo02.chapter08_thread.test1;

/**
 * 例子，创建三个窗口卖票，总票数为100张，使用继承Thread方式
 *
 * 存在线程安全问题，待解决
 *
 * 使用同步代码块解决线程安全问题
 *
 * 说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器
 *
 * @author bingai
 * @create 2019-10-30 22:13
 */
class Window extends Thread{

    private static int ticket = 100;//保证票只有100张，加static
    private static Object obj = new Object();//保证锁唯一，加static关键字

    @Override
    public void run() {
        while(true){
            //错误的
            //synchronized(this){//this代表着t1，t2，t3三个对象
            //synchronized(obj){//正确的
            synchronized(Window.class){//用【类做对象】，保证了【唯一性】，类只加载了一次 Class class = Window.class

                if(ticket > 0) {

                    System.out.println(getName() + ":卖票，票号为：" + ticket);
                    ticket--;
                }else {
                    break;
                }
            }

        }
    }
}
public class WindowTest1 {

    public static void main(String[] args) {
        Window t1 = new Window();
        Window t2 = new Window();
        Window t3 = new Window();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}
