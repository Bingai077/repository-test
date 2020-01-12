package cn.bingai.practice01.demo02.chapter11_collection.test02_List;

import cn.bingai.practice01.demo02.chapter11_collection.test01_CollectionTest.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**1.List接口框架
 *|-----Collection接口：单列集合，用来存储一个一个对象
            |-----List接口：【有序】【可重复】   --->“动态数组”
                    |----ArrayList：作为List主要实现类，线程不安全的，效率高；底层使用Object[] elementData存储
                    |----LinkedList：对于频繁的插入、删除操作，效率比ArrayList高，底层使用双向链表存储
                    |----Vector：作为List接口的古老实现类，线程安全的，效率低；底层使用Object[] elementData存储

    2.ArrayList源码分析：
     2.1jdk 7情况下
        ArrayList list = new ArrayList();//底层创建了长度是10的Object[]数组elementData
        list.add(123);//elsementDate[0] = new Integer(123);
        ...
        list.add(11);//如果此次的添加导致底层elementData数组容量不够，则扩容。
        默认情况下，扩容为原来容量的【1.5倍】，同时需要将原有数组中的数据复制到新的数组中。

        【结论】：建议开发中使用带参的构造器：ArrayList list = new ArrayList(int initialCapacity);

     2.2 jdk 8中ArrayList的变化
        ArrayList list = new ArrayList();//底层Object[] elementData初始化为{}，并没有创建长度为10的数组。
        list.add(123);//第一次调用add()时，底层才创建了长度为10的数组，并将数据123添加到elementData
        ...
        后续的添加和扩容操作与jdk7中无差别

     2.3 小结：jdk7中的ArrayList的创建类似于单例的【饿汉式】，
              而jdk8中的ArrayList的对象的创建类似于单例的【懒汉式】
              【延迟了数组的创建，节省了内存】

    3.LinkedList的源码分析：
        LinkedList list = new LinkedList();//内部声明了Node类型的first和last属性，默认值为null。
        list.add(123);//将123封装到Node中，创建了Node对象。

        其中，Node的定义为：体现了LinkedList的双向链表的说法
         private static class Node<E> {
             E item;
             Node<E> next;
             Node<E> prev;

         Node(Node<E> prev, E element, Node<E> next) {
             this.item = element;
             this.next = next;
             this.prev = prev;
         }
         }

    4. Vector的源码分析：jdk7和jdk8通过Vector()构造器创建对象时，底层都创建了长度为10的数组。
        在扩容方面，默认扩容为原来数组长度的【2倍】


 【面试题】：ArrayList、LinkedList、Vector
 同：三个类都实现了List接口，存储数据的特点相同：【有序】【可重复】
 不同：见上

    5. List接口中的常用方法：




 * @author bingai
 * @create 2019-11-05 15:57
 */
public class ListTest {

    /*
        void add(int index, Object ele):在index位置插入ele元素
        boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        Object get(int index):获取指定index位置的元素
        int indexOf(Object obj):返回obj在集合中首次出现的位置
        int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        Object remove(int index):移除指定index位置的元素，并返回此元素
        Object set(int index, Object ele):设置指定index位置的元素为ele
        List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合

【总结】：常用方法
增：add(Object obj)
删：remove(int index)/remove(Object obj)
改：set(int index,Object ele)
查：get(int index)
插：add(int index,Object ele)
长度：size()
遍历：1.Iterator迭代器
     2. 增强for，forEach
     3.普通循环
     */

    @Test
    public void test2() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");

        //方式一：使用Iterator迭代器
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println();
        //方式二：使用增强for
        for (Object obj : list) {
            System.out.println(obj);
        }

        System.out.println();
        //方式三：普通for循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }





    }

    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("bingai", 18));
        list.add(123);
        list.add(456);

        //int indexOf(Object obj):返回obj在集合中首次出现的位置,如果不存在返回-1
        int index = list.indexOf(456);
        System.out.println(index);//1

        //int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        int index1 = list.lastIndexOf(456);
        System.out.println(index1);//5

        //Object remove(int index):移除指定index位置的元素，并返回此元素
        Object obj = list.remove(0);
        System.out.println(obj);
        System.out.println(list);

        //Object set(int index, Object ele):设置指定index位置的元素为ele
        list.set(1,"CC");
        System.out.println(list);

        //List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合[a,b)
        List list1 = list.subList(2, 5);
        System.out.println(list1);
        System.out.println(list);

    }

    @Test
    public void test(){

        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("bingai",18));
        list.add(123);
        list.add(456);

        System.out.println(list);

        //void add(int index, Object ele):在index位置插入ele元素
        list.add(1,"BB");
        System.out.println(list);

        //boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        List list1 = Arrays.asList(1, 2, 3);
        //list.add(list1);
        list.addAll(list1);
        System.out.println(list.size());//10
        System.out.println(list);//[123, BB, 456, AA, Person{name='bingai', age=18}, 123, 456, 1, 2, 3]

        //Object get(int index):获取指定index位置的元素
        System.out.println(list.get(0));//123


    }


}
