package com.bingai.day15.demo01.Map;

import java.util.HashMap;
import java.util.Map;

/*
    java.util.Map<k,v>集合
    Map集合的特点：
        1.Map集合是一个双列集合，一个元素包含两个值(一个key，一个value)【夫妻对】
        2.Map集合中的元素，key和value的数据类型可以相同，也可以不同
        3.Map集合中的元素，key是不允许重复的，value是可以重复的
        4.Map集合中的元素，key和value是一一对应的

    java.util.HashMap<k,v>集合 impluments Map<k,v>接口
        HashMap集合的特点：
            1.HashMap集合的底层是哈希表：查询的速度特别的快
                哈希表：JDK1.8之前：数组 + 单链表
                       JDK1.8之后：数组 + 单链表 + 红黑树（链表长度超过8）：提高查询的速度
            2.hashMap集合是一个无序的集合，存储元素和取出元素的顺序有可能不一致

    java.util.LinkedHashMap<k,v>集合 extens HashMap<k,v>集合
         LinkedHashMap集合特点：
            1.LinkedHashMap集合底层：哈希表 + 链表(保证了迭代的顺序)
            2.LinkedHashMap是一个有序的集合，存储元素和取出元素的顺序是一致的
 */
public class Demo01Map {
    public static void main(String[] args) {
        /*
            public V put(K key, V value) : 把指定的键与指定的值添加到Map集合中。
            public V remove(Object key) : 把指定的键 所对应的键值对元素 在Map集合中删除，返回被删除元素的值。
            public V get(Object key) 根据指定的键，在Map集合中获取对应的值。
            boolean containsKey(Object key) 判断集合中是否有指定的键
            public Set<K> keySet() : 获取Map集合中所有的键，存储到Set集合中。
            public Set<Map.Entry<K,V>> entrySet() : 获取到Map集合中所有的键值对对象的集合(Set集合)。
         */

        show01();
        System.out.println("================");
        show02();
        System.out.println("================");
        show03();
        System.out.println("================");
        show04();


    }

    public static void show01(){
        /*public V put(K key, V value) : 把指定的键与指定的值添加到Map集合中。
            返回值：V
                存储键值对的时候，
                  key不重复，返回V是null
                  key重复，会使用新的value替换map中重复的value，返回被替换的value值
    */
        //创建Map集合
        Map<String, String> hashMap = new HashMap<>();
        String s = hashMap.put("chen", "shen");
        System.out.println(s);//null
        String s1 = hashMap.put("chen", "Ming");
        System.out.println(s1);//shen,返回被替换的值
        System.out.println(hashMap);//{chen=Ming}，key不允许重复

        hashMap.put("bingai","Coco");
        hashMap.put("bin","qi");
        hashMap.put("gai","Ming");
        hashMap.put("斌改","明明");
        System.out.println(hashMap);//集合无序,值可重复
    }

    public static  void show02(){
        /*
          public V remove(Object key) : 把指定的键 所对应的键值对元素 在Map集合中删除，返回被删除元素的值。
            返回值： V
                key存在，v返回被删除的值
                key不存在，v返回null
         */

        HashMap<String, Integer> hashmap = new HashMap<>();
        hashmap.put("斌",1);
        hashmap.put("改",8);
        hashmap.put("斌改",5);
        hashmap.put("bingai",3);
        hashmap.put("陈斌杰",1);
        System.out.println(hashmap);//{斌改=5, 改=8, 斌=1, 陈斌杰=1, bingai=3}

//        int remove1 = hashmap.remove("bingai1");//自动拆箱 NullPointerException
        Integer remove = hashmap.remove("bingai");
        System.out.println(remove);//3
        System.out.println(hashmap);//{斌改=5, 改=8, 斌=1, 陈斌杰=1}
        System.out.println(hashmap.remove("bin"));//null
        System.out.println(hashmap);//{斌改=5, 改=8, 斌=1, 陈斌杰=1}
    }

    public static void show03(){
        /*
            public V get(Object key) 根据指定的键，在Map集合中获取对应的值。
                返回值：
                   key存在，返回对应的value值
                   key不存在，返回null
         */
        HashMap<String, Integer> hashmap = new HashMap<>();
        hashmap.put("斌",1);
        hashmap.put("改",8);
        hashmap.put("斌改",5);
        hashmap.put("bingai",3);
        hashmap.put("陈斌杰",1);

        System.out.println(hashmap.get("bin"));//null
        System.out.println(hashmap.get("斌"));//1
    }

    private static void show04(){
        /*
             boolean containsKey(Object key) 判断集合中是否有指定的键
               包含，返回true；不包含，返回false
         */
        HashMap<String, Integer> hashmap = new HashMap<>();
        hashmap.put("斌",1);
        hashmap.put("改",8);
        hashmap.put("斌改",5);
        hashmap.put("bingai",3);
        hashmap.put("陈斌杰",1);

        System.out.println(hashmap.containsKey("bin"));//false
        System.out.println(hashmap.containsKey("斌"));//true
    }


}
