package cn.bingai.practice01.demo02.chapter11_collection.test01_CollectionTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素的遍历操作，使用迭代器Iterator接口
 * 1.内部的方法：hasnext() 和 next()
 * 2.默认游标都在集合的第一个元素之前。
 * 3.内部定义了remove(),可以在遍历的时候，删除集合中的元素。此方法不同于集合直接调用remove方法
 * @author bingai
 * @create 2019-11-05 12:39
 */
public class IteratorTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Bingo", 18));
        coll.add(new String("Bingai"));
        coll.add(false);

        Iterator iterator = coll.iterator();

        //方式一：
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
        //报异常：NoSuchElementException
        //System.out.println(iterator.next());

        //方式二：不推荐
//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//        }

        //方式三：推荐
        while(iterator.hasNext()){//1.指针下移 2.将下移以后集合位置上的元素返回
            System.out.println(iterator.next());
        }

//        错误方式一：间隔输出 & 有异常
//        while(iterator.next() != null ){
//            System.out.println(iterator.next());
//        }

        //错误方式二：死循环 & 始终输出第一个元素
//        while(coll.iterator().hasNext()){
//            System.out.println(coll.iterator().next());
//        }


    }

    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Bingo", 18));
        coll.add(new String("Bingai"));
        coll.add(false);

        //删除集合中"Bingai"
        Iterator iterator = coll.iterator();
        while(iterator.hasNext()){

            Object obj = iterator.next();
            if("Bingai".equals(obj)){
                iterator.remove();
            }
        }

        //遍历集合
        Iterator iterator1 = coll.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }





    }

}
