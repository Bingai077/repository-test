package com.bingai.day15.demo03.Map;

import java.util.HashMap;
import java.util.LinkedHashMap;

/*
    java.util.linkedHashMap<K,V> extends HashMap<K,V>
        Map接口的哈希表和链表的实现，具有可预知的迭代顺序。
        底层原理：
            哈希表 + 链表【用来记录元素的顺序】
        特点：【有序】
 */
public class Demo01LinkedHashMap {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("a","a");
        hashMap.put("r","s");
        hashMap.put("b","r");
        hashMap.put("a","t");
        hashMap.put("e","a");
        hashMap.put("d","n");
        System.out.println(hashMap);//{a=t, r=s, b=r, d=n, e=a},无序，key不允许重复

        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("a","a");
        linkedHashMap.put("r","s");
        linkedHashMap.put("b","r");
        linkedHashMap.put("a","t");
        linkedHashMap.put("e","a");
        linkedHashMap.put("d","n");
        System.out.println(linkedHashMap);//{a=t, r=s, b=r, e=a, d=n},有序，key不允许重复

    }

}
