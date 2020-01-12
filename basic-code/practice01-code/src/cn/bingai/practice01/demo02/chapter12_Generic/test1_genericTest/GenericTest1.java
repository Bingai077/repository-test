package cn.bingai.practice01.demo02.chapter12_Generic.test1_genericTest;

import cn.bingai.practice01.demo02.chapter11_collection.test01_CollectionTest.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 如何自定义泛型结构：泛型类、泛型接口；泛型方法？
 *
 * 1.关于自定义泛型类、泛型接口：
 *
 *
 *
 *
 * @author bingai
 * @create 2019-11-07 20:19
 */
public class GenericTest1 {

    @Test
    public void test1(){

        //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型为Object类型
        //要求：如果定义了类是带泛型的，建议在实例化时要指明类的泛型。
        Order<String> order = new Order<>("aa",1000,"order:AA");
        order.setOrderE("abc");

    }

    @Test
    public void test2(){
        SubOrder sub1 = new SubOrder();
        //由于子类在继承带泛型的父类时，指明了泛型类型，
        sub1.setOrderE(1314);

        SubOrder1<String> sub2 = new SubOrder1<>();
        sub2.setOrderE("order2...");

    }

    @Test
    public void test3(){

        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = null;
        //泛型不同的引用不能相互赋值
//        list1 = list2

        Person p1 = null;
        Person p2 = null;
        p1 = p2;

    }

    //测试泛型方法
    @Test
    public void test(){
        Order<String> order = new Order<>();
        Integer[] arr = {1, 2, 3, 4};
        //泛型方法在调用时，指明泛型参数的类型。
        List<Integer> list = order.copyFromArrayToList(arr);

        System.out.println(list);

    }


}
