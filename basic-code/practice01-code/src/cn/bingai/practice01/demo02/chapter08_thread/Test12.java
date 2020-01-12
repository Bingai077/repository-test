package cn.bingai.practice01.demo02.chapter08_thread;

/**
 * 编写生产者消费者多线程程序，设有一个最大库存量为4的电视机仓库，
 * 生产10台电视机，一边生产一边销售（消费）。
 * @author bingai
 * @create 2019-11-01 12:05
 */

class Storage{
    private static final int MAX = 4;
    private static final String NAME = "TV";
    private static int serialNum1 = 1000;
    private static int serialNum2 = 1000;
    private int num;
    private int count1;
    private int count2;

    public int getCount1() {
        return count1;
    }
    public int getCount2() {
        return count2;
    }

    public Storage() {
    }

    public int getNum() {
        return num;
    }




    //卖电视
    public synchronized void sellTV() {
        if(num > 0){
            num--;
            serialNum2++;
            count2++;

            notify();
            System.out.println("卖出编号：" + serialNum2 + "的" + NAME + ",当前库存是：" + num);

        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    //产电视
    public synchronized void productTV() {
        if(num < 4){
            num++;
            serialNum1++;
            count1++;


            notify();
            System.out.println("生产编号：" + serialNum1 + "的" + NAME + ",当前库存是：" + num);

        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread{
    private Storage storage;

    public Producer() {
    }

    public Producer(Storage storage) {
        this.storage = storage;
    }

    public Producer(String name, Storage storage) {
        super(name);
        this.storage = storage;
    }

    @Override
    public void run() {
        System.out.println(getName() + "开始产电视...");
        while(true){

            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            storage.productTV();

            if(storage.getCount1() == 10){
                break;
            }
        }

    }
}

class Consumer extends Thread{
    private Storage storage;

    public Consumer() {
    }

    public Consumer(Storage storage) {
        this.storage = storage;
    }

    public Consumer(String name, Storage storage) {
        super(name);
        this.storage = storage;
    }

    @Override
    public void run() {
        System.out.println(getName() + "开始卖电视...");
        while(true){

            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            storage.sellTV();

            if(storage.getCount2() == 10){
                break;
            }
        }
    }
}
public class Test12 {
    public static void main(String[] args) {
        Storage store = new Storage();
        Thread p = new Producer("生产部",store);
        Thread c = new Consumer("销售部",store);

        p.start();
        c.start();


    }


}
