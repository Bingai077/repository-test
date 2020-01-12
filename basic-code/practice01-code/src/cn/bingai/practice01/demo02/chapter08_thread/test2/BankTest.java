package cn.bingai.practice01.demo02.chapter08_thread.test2;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 *
 * @author bingai
 * @create 2019-10-31 10:36
 */
public class BankTest {

}

class Bank{
    private Bank(){}

    private static Bank instance = null;

    //private static synchronized Bank getInstance(){
    private static Bank getInstance(){
        //方式一：效率稍差
//        synchronized (Bank.class) {
//            if(instance == null){
//
//                instance = new Bank();
//            }
//            return instance;
//        }

        //效率稍高
        if(instance == null){

            synchronized (Bank.class) {
                if(instance == null){

                    instance = new Bank();
                }
            }
        }
        return instance;




    }


}