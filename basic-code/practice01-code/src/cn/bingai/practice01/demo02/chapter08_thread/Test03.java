package cn.bingai.practice01.demo02.chapter08_thread;

/**
 * 定义两个线程（一个用继承Thread类，一个用实现Runnable接口），
 * 定义一个测试类包括一个主函数调用两个子线程（具体实现自定）
 * @author bingai
 * @create 2019-10-31 18:15
 */




public class Test03 {
    public static void main(String[] args) {

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(getName() + ":helloJava");
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + ":helloBingai");
                }
            }
        }).start();





    }



}
