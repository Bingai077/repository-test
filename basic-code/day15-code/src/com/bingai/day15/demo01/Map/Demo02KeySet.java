package com.bingai.day15.demo01.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/*
    Map集合的第一种遍历方式：通过【键找值】的方式
    Map集合中的方法：
       public Set<K> keySet() : 获取Map集合中所有的键，存储到Set集合中。

    实现步骤：
        1.使用Map集合中的方法keySet(),把Map集合中所有的key取出来，存储到一个Set集合中
        2.遍历Set集合，获取Map集合中的每一个key
        3.通过Map集合中的get(key)，通过key找到value

 */
public class Demo02KeySet {
    public static void main(String[] args) {
        //创建Map集合对象
        HashMap<String, Integer> hashmap = new HashMap<>();
        hashmap.put("斌",1);
        hashmap.put("改",8);
        hashmap.put("斌改",5);
        hashmap.put("bingai",3);
        hashmap.put("陈斌杰",1);

        //1.使用Map集合中的方法keySet(),把Map集合中所有的key取出来，存储到一个Set集合中
        //2.使用迭代器或者增强for遍历set集合
        Set<String> keySet = hashmap.keySet();

        Iterator<String> iterator = keySet.iterator();
        while(iterator.hasNext()){
            String s = iterator.next();
            //3.通过Map集合中的get(key)，通过key找到value
            Integer value= hashmap.get(s);
            System.out.println(value);
        }
        System.out.println("==============");
        //增强for遍历
        for (String s : hashmap.keySet()) {
       //for (String s : keySet) {
            //3.通过Map集合中的get(key)，通过key找到value
            System.out.println(hashmap.get(s));
        }
    }
}
