package cn.bingai.practice01.demo02.chapter08_thread;

/**
 * 单例设计模式之懒汉式(线程安全)/饿汉式
 * @author bingai
 * @create 2019-11-01 17:35
 */
class Singleton{
    private static Singleton instance = null;

    private Singleton(){

    }

    public static Singleton getInstance(){

        if(instance == null){
            synchronized(Singleton.class){
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}

class Singleton1{
    private static Singleton1 instance = new Singleton1();
    private Singleton1(){

    }

    public static Singleton1 getInstance() {
        return instance;
    }
}



public class Test14 {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);

        Singleton1 s3 = Singleton1.getInstance();
        Singleton1 s4 = Singleton1.getInstance();
        System.out.println(s3 == s4);
    }
}
