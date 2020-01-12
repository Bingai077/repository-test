package cn.bingai.practice01.demo02.chapter08_thread.test3;

/**
 * 线程通信的应用：经典例题：生产者/消费者问题
 *
 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处
 取走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图
 生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通
 知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
 果店中有产品了再通知消费者来取走产品。

 这里可能出现两个问题：
 生产者比消费者快时，消费者会漏掉一些数据没有取到。
 消费者比生产者快时，消费者会取相同的数据。

 分析：
 1.是否是多线程的问题？是，生产者线程，消费者线程
 2.是否有共享数据？是，店员（或产品）
 3.如何解决线程的安全问题？同步机制，有三种方法
 4.是否涉及到线程的通信？是

 *
 * @author bingai
 * @create 2019-10-31 14:35
 */

class Clerk{

    private int productCount = 0;
    //生产产品
    public synchronized void produceProduct() {
        if(productCount < 20){
            productCount++;//先++后输出
            System.out.println(Thread.currentThread().getName() + ";开始生产第" + productCount + "个产品");

            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //消费产品
    public synchronized void consumeProduct() {
        if(productCount > 0){
            System.out.println(Thread.currentThread().getName() + ";开始消费第" + productCount + "个产品");
            productCount--;//先消费后--

            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producter extends Thread{

    private Clerk clerk;

    public Producter(Clerk clerk) {
        this.clerk = clerk;
    }

    public Producter(String name, Clerk clerk) {
        super(name);
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ";开始生产生产产品...");

        while(true){
            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.produceProduct();
        }

    }
}

class Consumer extends Thread{
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    public Consumer(String name, Clerk clerk) {
        super(name);
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ";开始消费产品...");

        while(true){
            try {
                sleep(101);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.consumeProduct();
        }
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producter p1 = new Producter("生产者1",clerk);
        Consumer c1 = new Consumer("消费者1",clerk);
        Consumer c2 = new Consumer("消费者2",clerk);

        p1.start();
        c1.start();
        c2.start();
    }


}
