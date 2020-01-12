package cn.bingai.practice01.demo02.chapter11_collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author bingai
 * @create 2019-11-06 22:33
 */
public class Test11 {
   /*
        创建一个List集合的对象，添加几条数据，
        将1号位和2号位交换；获得最大值，最小值，

    */
   @Test
   public void test2() {
       ArrayList list = new ArrayList();
       list.add(123);
       list.add(456);
       list.add(888);
       list.add(520);
       list.add(1314);
       list.add(-123);
       list.add(888);
       System.out.println(list);
       Collections.swap(list,1,2);
       System.out.println(list);
       System.out.println(Collections.max(list));//1314
       System.out.println(Collections.min(list));//-123

   }


    /*
        创建一个List集合的对象，添加几个字符串，反转对象中元素的顺序；
        根据元素的自然顺序排序；

     */
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add("bingai");
        list.add("Mingming");
        list.add("Coco");
        list.add("Kobe");
        list.add("Tim");
        list.add("Tony");
        list.add("Merry");

        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);


    }





    /*
        创建一个List集合的对象，添加几个数字，反转对象中元素的顺序；
        根据元素的自然顺序排序；

     */
    @Test
    public void test(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(888);
        list.add(520);
        list.add(1314);
        list.add(-123);
        list.add(888);

        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }

}
