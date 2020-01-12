package com.bingai.day15.demo03.Map;

import java.util.HashMap;
import java.util.Hashtable;

/*
    java.util.Hashable<K,V>集合 impluments Map<K,V>接口

    Hashtable：底层也是哈希表，是一个线程安全的集合，单线程，速度慢
    HashMap：底层是哈希表，是一个线程不安全的集合，多线程，速度快

    HashMap集合(之前学的所有集合都可以)：可以存储null值，null键
    Hashtable集合，不能存储null值、null键

    Hashtable和Vector集合一样，在jdk1.2版本之后被更先进的集合【HashMap、ArrayList】取代了
    Hashtable的子类Propertices依然活跃在你是舞台
    Properties集合是【唯一】一个和IO流结合的集合


 */
public class Demo02Hashtable {
    public static void main(String[] args) {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(null,"a");
        hashMap.put("b",null);
        hashMap.put(null,null);
        System.out.println(hashMap);//{null=null, b=null}

        Hashtable<String, String> hashtable = new Hashtable<>();
//        hashtable.put(null,"a");//NullPointerException
//        hashtable.put("b",null);//NullPointerException
//        hashtable.put(null,null);//NullPointerException

    }
}
