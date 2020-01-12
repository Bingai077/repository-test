package cn.bingai.practice01.demo02.chapter06_OOP3.test2_singleton;
/*
    单例模式的懒汉式实现
 */
public class SingletonTest2 {
    public static void main(String[] args) {
        Order order1 = Order.getInstance();
        Order order2 = Order.getInstance();

        System.out.println(order1 == order2);//true
    }

}

class Order{
    //1.私有化类的构造器
    private  Order(){

    }

    //2.先声明当前类对象，没有初始化
    //4.此对象也必须声明为static
    private static Order instance = null;//懒

    //3.声明public、static的返回当前类对象的方法
    public static Order getInstance(){
        if(instance == null){
            instance = new Order();
        }
        return instance;
    }
}
