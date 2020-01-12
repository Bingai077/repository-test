package cn.bingai.practice01.demo02.chapter05_OOP2.test8;
import java.util.Objects;
/*
    1.编写Order类，有int型的orderId， String型的orderName，相应的
getter()和setter()方法，两个参数的构造器，重写父类的equals()方法：
public boolean equals(Object obj)， 并判断测试类中创建的两个对象是否
相等。
 */
public class Order {
    private int orderld;
    private String orderName;

    public Order() {
    }

    public Order(int orderld, String orderName) {
        this.orderld = orderld;
        this.orderName = orderName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderld == order.orderld &&
                Objects.equals(orderName, order.orderName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderld, orderName);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderld=" + orderld +
                ", orderName='" + orderName + '\'' +
                '}';
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderld() {
        return orderld;
    }

    public void setOrderld(int orderld) {
        this.orderld = orderld;
    }
}
