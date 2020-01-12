package cn.bingai.practice01.demo02.chapter08_thread.test1;

/**
 * 创建多线程的方式二： 实现Runnable接口
 *1.创建一个实现Runnable接口的类
 *2.实现类实现Runnable中的抽象方法：run()
 *3.创建实现类的对象
 *4.将此对象作为参数传递到Thread类的构造器中，创建Thread对象
 *5.通过Thread类的对象调用start()
 *
 * 比较创建线程的两种方法。
 * 开发中，优先选择实现Runnable接口的方式
 * 原因：
 *  1.实现的方式没有单继承的局限性
 *  2.实现的方式更适合用来处理多个共享数据的情况
 *
 *  联系：public class Thread implements Runnable
 *  相同点：两种方式都需要重写run(),将线程要执行的逻辑声明在run方法中
  * @Author bingai
  * @Description //TODO 
  * @Date 23:13 2019/10/30
  * @Param 
  * @return 
  **/


//1.创建一个实现Runnable接口的类
class MThread implements Runnable{
//2.实现类实现Runnable中的抽象方法：run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }
}

public class ThreadTest2 {
    public static void main(String[] args) {
        MThread myThread = new MThread();

        Thread t1 = new Thread(myThread);
        t1.setName("线程一");
        //通过Thread类的对象调用start():1.启动当前线程 2.调用当前线程的run()
        t1.start();

        //再启动一个线程，遍历100以内偶数
        Thread t2 = new Thread(myThread);
        t2.setName("线程二");
        t2.start();

    }


}
