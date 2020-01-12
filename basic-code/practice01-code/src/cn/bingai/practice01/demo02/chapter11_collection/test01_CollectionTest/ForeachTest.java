package cn.bingai.practice01.demo02.chapter11_collection.test01_CollectionTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * jdk5.0 新增了foreach循环，用于遍历集合、数组
 *
 * @author bingai
 * @create 2019-11-05 15:41
 */
public class ForeachTest {

    @Test
    public void test() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Bingo", 18));
        coll.add(new String("Bingai"));
        coll.add(false);

        //for(集合中元素的类型  局部变量 : 集合对象)
        //内部仍然调用了迭代器
        for (Object obj : coll) {
            System.out.println(obj);
        }
    }

    @Test
    public void test1 () {

        int[] arr = new int[]{1, 2, 3, 4, 5, 6};

        //for(数组中元素的类型  局部变量 : 数组对象)
        for (int i : arr) {
            System.out.println(i);
        }
    }


    //练习题
    @Test
    public void test2() {
        String[] arr = new String[]{"AA","BB","CC"};

        //方式一：普通for循环
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = "MM";
//        }

        //方式二：增强for循环
        for (String s : arr) {
            s = "MM";
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

}
