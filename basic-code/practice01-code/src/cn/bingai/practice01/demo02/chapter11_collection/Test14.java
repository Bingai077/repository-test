package cn.bingai.practice01.demo02.chapter11_collection;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author bingai
 * @create 2019-11-07 15:56
 */
public class Test14 {
    @Test
    public void Test(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(789);
        list.add(520);
        list.add(520);

        list.forEach(System.out::println);
    }
}
