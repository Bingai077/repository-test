package com.bingai.day15.demo02.Map;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
    HashMap自定义类型键值
        Map集合保证key是唯一的：
            作为key的元素，必须重写hashCode方法和equals方法，以保证key唯一
 */
public class Demo01HashMapSavePerson {
    public static void main(String[] args) {
        show01();
        System.out.println("===============");
        show02();
    }

    public static void show01(){
        /*
            HashMap存储自定义类型键值
            key：String类型
                 String类重写hashCode方法和equals方法，可以保证key唯一
            value：Person类型
                 value可以重复(同名同年龄的人视为同一个人)
         */
        //创建HashMap集合
        HashMap<String, Person> hashMap = new HashMap<>();
        //往集合中添加元素
        hashMap.put("宁波",new Person("斌改",18));
        hashMap.put("杭州",new Person("斌",19));
        hashMap.put("武汉",new Person("改",20));
        hashMap.put("宁波",new Person("bingai",22));

        //使用keySet加增强for遍历
        for (String s : hashMap.keySet()) {
            System.out.println(s + hashMap.get(s));//
        }

    }

    public static void show02(){
        /*
            HashMap存储自定义类型键值
            key：Person类型
                 Person类必须重写hashCode和equals方法，以保证key是唯一的
            value：String类型
                 可重复
         */
        //创建HashMap集合
        HashMap<Person, String> map = new HashMap<>();
        //往集合中添加元素
        map.put(new Person("斌改",18),"宁波");
        map.put(new Person("斌",20),"杭州");
        map.put(new Person("改",16),"武汉");
        map.put(new Person("斌改",18),"荆州");
        //使用entrySet和增强for遍历map集合
        Set<Map.Entry<Person, String>> entrySet = map.entrySet();
        for (Map.Entry<Person, String> entry : entrySet) {
            System.out.println(entry.getKey()+ "=" +entry.getValue());//不重写，无法保证唯一；重写，保证唯一

        }


    }

}
