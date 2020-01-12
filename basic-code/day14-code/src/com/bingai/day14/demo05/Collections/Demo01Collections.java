package com.bingai.day14.demo05.Collections;

import java.util.ArrayList;
import java.util.Collections;

/*
    java.utils.Collections是集合工具类，用来对集合进行操作，部分方法如下：

    public static <T> boolean addAll(Collection<T> c, T... elements) :往集合中添加一些元素。
    public static void shuffle(List<?> list) 打乱顺序 :打乱集合顺序。

 */
public class Demo01Collections {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        //往集合中添加多个元素
        /*arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add("e");*/

        //public static <T> boolean addAll(Collection<T> c, T... elements) :往集合中添加一些元素。
        Collections.addAll(arrayList,"a","b","c","d","e");

        System.out.println(arrayList);//[a, b, c, d, e]

        //public static void shuffle(List<?> list) 打乱顺序 :打乱集合顺序。
        Collections.shuffle(arrayList);
        System.out.println(arrayList);//[b, c, e, a, d]//[e, c, b, d, a]

    }
}
