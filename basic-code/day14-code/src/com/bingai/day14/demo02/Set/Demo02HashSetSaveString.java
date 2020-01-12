package com.bingai.day14.demo02.Set;

import java.util.HashSet;

/*
    set集合【不允许存储重复元素】的原理
    【会调用Object类下的hashCode()方法和equals()方法，判断元素是否重复】


 */
public class Demo02HashSetSaveString {
    public static void main(String[] args) {
        //创建HashSet集合对象
        HashSet<String> hashSet = new HashSet<>();
        String s = new String("abc");
        String s1 = new String("abc");
        hashSet.add(s);
        hashSet.add(s1);
        hashSet.add("重地");
        hashSet.add("通话");
        hashSet.add("abc");
        System.out.println(hashSet);//[重地, 通话, abc]

    }
}
