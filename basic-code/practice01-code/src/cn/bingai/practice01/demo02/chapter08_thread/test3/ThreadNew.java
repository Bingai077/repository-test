package cn.bingai.practice01.demo02.chapter08_thread.test3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现Callable接口。 --- JDK5.0新增
 *
 * 如何理解实现Callable接口的方式创建多线程比实现Runnable接口创建多线程方式强大？
 * 1.call()方法可以有返回值
 * 2.call()方法可以抛出异常，被外面的操作捕获，获取异常信息
 * 3.Callable是支持泛型的
 *
 * @author bingai
 * @create 2019-10-31 15:09
 */
//1.创建一个实现Callable的实现类
class NumThread implements Callable<Integer> {
    //2.实现call方法，将此线程需要执行的操作声明在call()中
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;//装箱，int --> Integer
    }
}

public class ThreadNew {
    public static void main(String[] args) {
        //3.创建Callable接口实现类的对象
        NumThread numThread = new NumThread();
        //4.将此Callable接口实现类的对象作为参数传递到FutureTask构造器中，创建FuntureTask的对象
        FutureTask<Integer> futureTask = new FutureTask<Integer>(numThread);
        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()方法
        new Thread(futureTask).start();

        try {
            //6.获取Callable中的call方法的返回值
            //get方法的返回值即为Future构造器参数Callable实现类重写的call()的返回值Integer sum = futureTask.get();
            Integer sum = futureTask.get();
            System.out.println("总和为：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }


}
