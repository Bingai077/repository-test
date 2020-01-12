package cn.bingai.practice01.demo02.chapter12_Generic.test1_genericTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义泛型类
 * @author bingai
 * @create 2019-11-07 20:14
 */
public class Order<T> {

    String orderName;
    int orderId;

    //类的内部结构就可以使用类的泛型

    T orderE;

    public Order(){
        //编译不通过
//        T[] arr = new T[10];
        //编译可通过
        T[] arr = (T[]) new Object[10];

    };

    public Order(String orderName, int orderId, T orderE) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderE = orderE;
    }

    //如下的方法都不是泛型方法
    public T getOrderE() {
        return orderE;
    }

    public void setOrderE(T orderE) {
        this.orderE = orderE;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderE=" + orderE +
                '}';
    }

    //静态方法中不能使用类的泛型
//    public static void show(T orderE){
//        System.out.println(orderE);
//    }


//编译不通过
//    public void show(){
//        try{
//
//        }catch(T t){
//
//        }
//    }

    //泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系。
    //换句话说：泛型方法所属的类是不是泛型类都没有关系
    //泛型方法：可以声明为静态的。原因：泛型参数是在调用方法时确定的，并非在实例化时确定。

    public static <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();

        for (E e : arr) {
            list.add(e);
        }
        return list;
    }

}
