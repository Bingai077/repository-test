package cn.bingai.practice01.demo02.chapter11_collection.test01_CollectionTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author bingai
 * @create 2019-11-07 17:44
 */
public class ListToSetTest {
    public static List duplicateList(List list) {
        HashSet set = new HashSet();
        set.addAll(list);
        return new ArrayList(set);
    }
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(4));
        list.add(new Integer(4));
        List list2 = duplicateList(list);
        for (Object integer : list2) {
            System.out.println(integer);
        }
    }





}

