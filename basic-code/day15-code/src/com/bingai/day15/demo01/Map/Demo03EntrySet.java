package com.bingai.day15.demo01.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
    Map集合遍历的第二种方式：使用【键值对】Entry对象遍历

    Map集合中的方法：
           public Set<Map.Entry<K,V>> entrySet() : 获取到Map集合中所有的键值对对象的集合(Set集合)。

    实现步骤：
        1.使用Map集合中的方法entrySet()方法，把Map集合中多个Entry对象取出来，存储到一个Set集合中
        2.遍历Set集合，获取每一个Entry对象
        3.使用Entry中的方法getKey()和getValue()获取键与值

 */
public class Demo03EntrySet {
    public static void main(String[] args) {
        //创建Map集合对象
        HashMap<String, Integer> hashmap = new HashMap<>();
        hashmap.put("斌", 1);
        hashmap.put("改", 8);
        hashmap.put("斌改", 5);
        hashmap.put("bingai", 3);
        hashmap.put("陈斌杰", 1);

        //1.使用Map集合中的方法entrySet()方法，把Map集合中多个Entry对象取出来，存储到一个Set集合中
        Set<Map.Entry<String, Integer>> entrySet = hashmap.entrySet();
        //2.遍历Set集合，获取每一个Entry对象,增强for遍历Set
        for (Map.Entry<String, Integer> entry : entrySet) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            //3.使用Entry中的方法getKey()和getValue()获取键与值
            System.out.println(key + "=" + value);
        }

        System.out.println("======================");
        //2.遍历Set集合，获取每一个Entry对象，迭代器遍历Set
        Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
//            System.out.println(entry.getValue());
            //3.使用Entry中的方法getKey()和getValue()获取键与值
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "=" + value);
        }

    }
}
