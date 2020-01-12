package cn.bingai.practice01.demo02.chapter06_OOP3.test20;
//懒汉式
public class Singleton2 {
    private Singleton2(){

    }

    private static Singleton2 instance = null;

    public static synchronized Singleton2 getInstance() {
     if(instance == null){
         instance = new Singleton2();
     }
        return instance;

    }
}
