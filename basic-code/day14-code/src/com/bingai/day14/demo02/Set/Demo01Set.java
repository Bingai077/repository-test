package com.bingai.day14.demo02.Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
    java.util.Set接口  extends Collection接口
    Set接口的特点：
        1.【不允许存储重复的元素】
        2.【没有索引】，没有带索引的方法，也不能使用普通的for循环遍历

    java.util.HashSet集合 impluments Set接口
    hashSet特点
        1.【不允许存储重复的元素】
        2.【没有索引】，没有带索引的方法，也不能使用普通的for循环遍历
        3.是一个【无序】的集合，存储元素和取出元素的顺序有可能不一致
        4.底层是一个【哈希表】结构(【查询速度非常快】)
 */
public class Demo01Set {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        //使用add方法往集合中添加元素
        set.add(1);
        set.add(3);
        set.add(2);
        set.add(4);
        set.add(1);
//        System.out.println(set);
    //使用迭代器或者增强for遍历set集合
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());//重复元素不输出
        }
        System.out.println("==================");
        for (Integer integer : set) {
            System.out.println(integer);//输出无序
        }




    }
}
