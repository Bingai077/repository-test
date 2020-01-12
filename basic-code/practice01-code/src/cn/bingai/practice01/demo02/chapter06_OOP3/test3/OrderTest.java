package cn.bingai.practice01.demo02.chapter06_OOP3.test3;
/*
    1.默认初始化
    2.显式初始化
    3.构造器中初始化
    4.对象.属性or对象.方法
    5.代码块中赋值

    执行顺序：1-->2/5-->3-->4

 */
public class OrderTest {
    public static void main(String[] args) {
        order order = new order();
        System.out.println(order.orderId);//4
    }
}
class order{

    {
        orderId = 4;
    }

    int orderId = 3;

}
