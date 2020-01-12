package cn.bingai.practice01.demo02.chapter08_thread;

/**
 * 模拟一个人生产50个玩具，每200毫秒生产一个，
 * 当生产到第20个时加入每秒吃1个馒头，
 * 共吃完3个后在接着生产的多线程。
 *
 * @author bingai
 * @create 2019-11-01 6:22
 */
class Person {
    private int toy;//玩具
    private int bread;//馒头

    public Person() {
    }

    public Person(int toy, int bread) {
        this.toy = toy;
        this.bread = bread;
    }

    public int getToy() {
        return toy;
    }

    public void setToy(int toy) {
        this.toy = toy;
    }

    public int getBread() {
        return bread;
    }

    public void setBread(int bread) {
        this.bread = bread;
    }

    //生产玩具
    public synchronized void productToy() {
        if (toy < 50) {
            toy++;
            System.out.println(Thread.currentThread().getName() + "正在生产第" + toy + "个玩具");

            if (toy == 20 ) {

                notify();

                /*if(bread %3 == 0){
                    notify();
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }*/



                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //吃馒头
    public synchronized void eatBread() {

        if (toy == 20) {

            bread++;
            System.out.println(Thread.currentThread().getName() + "正在吃第" + bread + "个馒头");

            if (bread % 3 == 0) {
                notify();
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "开始吃馒头....");

        }


    }
}

//吃馒头
class EatBread implements Runnable {
    private Person person;

    public EatBread(Person person) {
        this.person = person;
    }

    @Override
    public void run() {

        while (true) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            person.eatBread();
        }

    }
}

//生产玩具
class ProductToy implements Runnable {
    private Person person;

    public ProductToy(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始生产玩具....");

        while (true) {

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            person.productToy();
        }
    }
}


public class Test04 {
    public static void main(String[] args) {
        Person p = new Person();
        EatBread eatBread = new EatBread(p);
        ProductToy productToy = new ProductToy(p);

        new Thread(productToy, "线程一").start();
        new Thread(eatBread, "线程二").start();

    }

}
