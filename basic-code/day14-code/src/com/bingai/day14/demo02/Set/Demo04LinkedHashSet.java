package com.bingai.day14.demo02.Set;

import java.util.HashSet;
import java.util.LinkedHashSet;

/*
    java.util.LinkedHashSet集合 extends HashSet集合
    LinkedHashSet集合特点：
        底层是一个哈希表(数组 + 链表 + 红黑树) + 链表
        多了一条链表【用来记录元素的顺序】，保证元素有序


 */
public class Demo04LinkedHashSet {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("www");
        set.add("abc");
        set.add("abc");
        set.add("bingai");
        System.out.println(set);//[abc, www, bingai]无序，不允许重复

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("www");
        linkedHashSet.add("abc");
        linkedHashSet.add("abc");
        linkedHashSet.add("bingai");

        System.out.println(linkedHashSet);//[www, abc, bingai]有序，不允许重复

    }

}
