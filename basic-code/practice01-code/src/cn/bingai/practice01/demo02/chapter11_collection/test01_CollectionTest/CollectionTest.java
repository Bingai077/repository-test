package cn.bingai.practice01.demo02.chapter11_collection.test01_CollectionTest;

import org.junit.Test;

import java.util.*;

/**
 * 一、集合框架的概述
 *
 * 1.集合、数组都是对多个数据进行存储操作的结构，简称Java容器
 *      说明：此时的存储，主要指的是内存层面的存储，不涉及持久化的存储（.txt,.jpg,.avi,数据库中）
 *
 * 2.1数组在存储多个数据方面的特点：
 *      >一旦初始化后，其长度就确定了。
 *      >数组一旦定义好，其元素的类型也就确定了，只能操作指定类型的数据了。
 *      比如：String[] arr，int[] arr;
 *
 * 2.2数组在存储多个数据方面的缺点：
 *      >一旦初始化后，其长度不可修改。
 *      >数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便，同时效率也不高。
 *      >获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用。
 *      >数组存储数据的特点：有序、可重复。对于无序、不可重复的需求，不能满足。
 *
 *二、集合框架
       |-----Collection接口：单列集合，用来存储一个一个对象
            |-----List接口：【有序】【可重复】   --->“动态数组”
                    |----ArrayList、LinkedList、Vector

            |-----Set接口：【无序】【不可重复】  --->高中讲的“集合”
                    |----HashSet、LinkedHashSet、TreeSet

       |-----【Map】接口：【双列集合】，用来存储一对（【key-value】）一对的数据    --->高中函数：y=f(x)
                    |----HashMap、LenkedHashMap、TreeMap、Hashtable、Properties

 三、Collection接口中方法的使用

 【结论】
 向Collection接口的实现类中添加数据obj时，要求obj所在类要重写equals()方法

 * @author bingai
 * @create 2019-11-04 17:35
 */
public class CollectionTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();

        //add(Object e):将元素e添加到集合coll中
        coll.add("AA");
        coll.add(123);
        coll.add(true);
        coll.add(new Date());

        //size()：获取添加元素的个数
        System.out.println(coll.size());//4

        //addAll(Collection coll1):将coll1的元素添加到当前集合中
        Collection coll1 = new ArrayList();
        coll1.add("cc");
        coll1.add(456);
        coll.addAll(coll1);
        System.out.println(coll.size());//6
        System.out.println(coll);//[AA, 123, true, Mon Nov 04 18:33:21 CST 2019, cc, 456]

        //clear():清空集合元素
        coll.clear();

        //isEmpty():判断集合是否为空
        System.out.println(coll.isEmpty());//true

        System.out.println("====================================");
        Collection coll2 = new ArrayList();
        coll2.add(123);
        coll2.add(456);
        //Person p = new Person("Bingo", 18);
        coll2.add(new Person("Bingo", 18));
        coll2.add(new String("Bingai"));
        coll2.add(false);

        //1.contains(Object obj):判断当前集合中是否包含obj
        //在判断时会调用obj对象所在类的equals()。
        boolean contains = coll2.contains(123);
        System.out.println(contains);//true
        System.out.println(coll2.contains(new String("Bingai")));//true
        //System.out.println(coll2.contains(p));//true
        System.out.println(coll2.contains(new Person("Bingo", 18)));//false --> true

        //2.containsAll(Collection coll3):判断形参对应的所有元素是否都在当前集合中
        Collection coll3 = Arrays.asList(123,456);
        System.out.println(coll2.containsAll(coll3));//true

    }


    @Test
    public void test2(){

        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Bingo", 18));
        coll.add(new String("Bingai"));
        coll.add(false);

        //3.remove(Object obj):从当前集合中去移除obj元素
        coll.remove(1234);
        coll.remove(new Person("Bingo", 18));
        System.out.println(coll);

        //4.removeAll(Collection coll1):差集：从当前集合中移除coll1中所有元素
        Collection coll1 = Arrays.asList(123,456);
        coll.removeAll(coll1);
        System.out.println(coll);

    }

    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Bingo", 18));
        coll.add(new String("Bingai"));
        coll.add(false);
//        Collection coll1 = Arrays.asList(123,456,789);
//
//        //5.retainAll(Collection coll1):交集：获取当前集合和coll1集合的交集，并返回当前集合
//        coll.retainAll(coll1);
//        System.out.println(coll);


        Collection coll2 = new ArrayList();//有序的
        coll2.add(123);
        coll2.add(456);
        coll2.add(new Person("Bingo", 18));
        coll2.add(new String("Bingai"));
        coll2.add(false);

        //6.equals(Object obj):需要当前集合和形参集合的元素都相同
        System.out.println(coll.equals(coll2));
        System.out.println(coll.equals(new Person("Bingo", 18)));
    }

    @Test
    public void test4(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Bingo", 18));
        coll.add(new String("Bingai"));
        coll.add(false);

        //hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());//1152954056

        //8.集合 ---> 数组:toArray()
        Object[] arr = coll.toArray();
        System.out.println(Arrays.toString(arr));

        //拓展：数组 ---> 集合:调用Arrays类的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "VV"});
        System.out.println(list);

        List list1 = Arrays.asList(new int[]{123, 456});
        System.out.println(list1.size());//1
        System.out.println(list1);

        List list2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(list2);//[123, 456]

        List list3 = Arrays.asList(123,456);
        System.out.println(list3);//[123, 456]

        //9.iterator():返回Iterator接口的实例，用于遍历集合元素，放在IteratorTest.java中测试

    }







}
