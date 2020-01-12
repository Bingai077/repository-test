package cn.bingai.practice01.demo02.chapter11_collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author bingai
 * @create 2019-11-06 18:15
 */
public class Test05 {

    /*
        创建ArrayList实例化对象，添加10个以上的元素，
        在2号位插入一个元素，获得5号位元素，
        删除6号位元素，修改7号位的元素；

        通过四种方法遍历上题中的集合
     */
    @Test
    public void test() {
        ArrayList list = new ArrayList();
        list.add("AA");
        list.add(123);
        list.add(true);
        list.add(132.628);
        list.add('中');
        list.add(520);
        list.add(123);
        list.add(-259);
        list.add("中");
        list.add("BBCCVVG");
        System.out.println(list);
        list.add(2, "bingai");
        System.out.println(list);
        System.out.println(list.get(5));//中
        list.remove(6);
        System.out.println(list);
        list.set(7, 250);
        System.out.println(list);

        //遍历方式一：forEach
        System.out.println("==========方式一：forEach===========");
        for (Object obj : list) {
            System.out.println(obj);
        }

        //遍历方式二：iterator()
        System.out.println("==========方式二：iterator===========");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //遍历方式三：普通for
        System.out.println("==========方式三：普通for===========");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }



    /*
        创建LinkedList实例化对象，练习具有队列特点的方法
     */
    @Test
    public void test1() {
        LinkedList list = new LinkedList();
        list.add("AA");
        list.add(123);
        list.add(true);
        list.add(132.628);
        list.add('中');
        list.add(520);
        list.add(123);
        list.add(-259);
        list.add("中");
        list.add("BBCCVVG");
        list.add(520);
        list.add(123);
        list.add(-259);
        list.add("中");
        list.add("BBCCVVG");
        System.out.println(list);

        list.removeLast();
        System.out.println(list);
        list.removeFirst();
        System.out.println(list);
        list.removeFirstOccurrence(520);
        System.out.println(list);
        list.removeLastOccurrence("中");
        System.out.println(list);
        Object[] array = list.toArray();
        System.out.println(Arrays.toString(array));
        System.out.println(list.getLast());
        System.out.println(list.getFirst());



    }
}


