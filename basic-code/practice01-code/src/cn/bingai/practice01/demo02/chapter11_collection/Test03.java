package cn.bingai.practice01.demo02.chapter11_collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author bingai
 * @create 2019-11-06 16:25
 */
public class Test03 {
/*
    创建Set接口的实现类，添加10个以上的元素，要求能够排序。

    */

    @Test
    public void test3() {
        TreeSet set = new TreeSet();
        for (int i = 0; i < 20; i++) {
            if(i < 5){
                set.add("ZZ" + i);
            }else if (i< 10){
                set.add("HH" + i);
            }else if (i< 15){
                set.add("AA" + i);
            }else{
                set.add("BB" + i);
            }
        }

        for (Object obj : set) {
            System.out.println(obj);
        }




    }




    /*
        创建Set接口的实现类，添加10个以上的元素，通过foreach遍历此集合元素。
    */

    @Test
    public void test2() {
        HashSet set = new HashSet();
        for (int i = 0; i < 20; i++) {
            set.add("AA" + i);
        }

        for (Object obj : set) {
            System.out.println(obj);
        }


    }



/*
    创建Set接口的实现类，添加10个以上的元素，通过Iterator遍历此集合元素。

    */

    @Test
    public void test1() {
        HashSet set = new HashSet();
        for (int i = 0; i < 20; i++) {
            set.add("AA" + i);
        }

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }



    /*
    定义一个Collection接口类型的变量，引用一个Set集合的实现类，
    实现添加单个元素，添加另一个集合，删除元素，
    判断集合中是否包含一个元素，判断是否为空，清除集合，
    返回集合里元素的个数等常用操作。

    */

    @Test
    public void test() {
        HashSet set = new HashSet();
        set.add("AA");
        set.add(123);
        set.add(true);
        set.add(132.628);
        set.remove(123);
        System.out.println(set);

        HashSet set1 = new HashSet();
        set1.add("BB");
        set1.add(321);
        set1.add(false);
        set.addAll(set1);
        System.out.println(set);

        boolean b = set.contains(321);
        System.out.println(b);//true
        int size = set.size();
        System.out.println(size);//6
        set.clear();
        boolean isEmpty = set.isEmpty();
        System.out.println(isEmpty);//true

        System.out.println(set);//[]


    }


    /*
    定义一个Collection接口类型的变量，引用一个List集合的实现类，
    实现添加单个元素，添加另一个集合，删除元素，
    判断集合中是否包含一个元素，判断是否为空，清除集合，
    返回集合里元素的个数等常用操作。

    */

    @Test
    public void test5() {
        ArrayList list = new ArrayList();
        list.add("AA");
        list.add(123);
        list.add(true);
        list.add(132.628);
        list.add('中');
        list.add(520);
        System.out.println(list);
        list.remove(new Integer(123));
        System.out.println(list);
        list.remove(3);
        System.out.println(list);

        ArrayList list1 = new ArrayList();
        list1.add("AA");
        list1.add(123);
        list1.add(true);
        list1.add(132.628);
        list1.add('中');
        list1.add(520);
        list.addAll(list1);
        System.out.println(list);

        list.add(2,"bingai");
        System.out.println(list);

        boolean b = list.contains("bingai");
        System.out.println(b);//true

        list.removeAll(list1);
        System.out.println(list);
        list.clear();
        System.out.println(list);//[]
        boolean isEmpty = list.isEmpty();
        System.out.println(isEmpty);//true

        System.out.println(list.size());//
//        System.out.println(list.get(0));//IndexOutOfBoundsException


    }

}


