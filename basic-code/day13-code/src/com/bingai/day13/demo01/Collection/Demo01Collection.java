package com.bingai.day13.demo01.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/*
    java.util.Collection接口
        所有单列集合的最顶层的接口，里边定义了所有单列集合共性的方法
        任意的单列集合都可以使用Collection接口中的方法

    共性的方法：
    public boolean add(E e)：  把给定的对象添加到当前集合中 。
    public void clear():  清空集合中所有的元素。
    public boolean remove(E e):  把给定的对象在当前集合中删除。
    public boolean contains(E e):  判断当前集合中是否包含给定的对象。
    public boolean isEmpty():  判断当前集合是否为空。
    public int size():  返回集合中元素的个数。
    public Object[] toArray():  把集合中的元素，存储到数组中。

 */
public class Demo01Collection {
    public static void main(String[] args) {
        //创建一个集合对象，可以使用多态
        Collection<String> collection = new ArrayList<>();
        System.out.println(collection);//[],重写了toString方法

        /*
            public boolean add(E e)：  把给定的对象添加到当前集合中 。
            返回值是一个boolean值，一般返回true，所以可以不用接收
         */
        boolean b = collection.add("bingai");
        System.out.println(b);//true
        System.out.println(collection);//[bingai]
        collection.add("斌");
        collection.add("杰");
        collection.add("明");
        collection.add("明");
        collection.add("Coco");
        System.out.println(collection);//[bingai, 斌, 杰, 明, Coco]

        /*
            public boolean remove(E e):  把给定的对象在当前集合中删除。
            返回值是一个boolean值，集合中存在元素，删除元素，返回true
                                 集合中不存在元素，删除失败，返回false
         */
        boolean b1 = collection.remove("斌");
        System.out.println("b1=" + b1);//true
        System.out.println(collection);//[bingai, 杰, 明, Coco]
        boolean b2 = collection.remove("斌杰");
        System.out.println("b2=" + b2);//false
        System.out.println(collection);//[bingai, 杰, 明, Coco]

        /*
            public boolean contains(E e):  判断当前集合中是否包含给定的对象。
            包含，返回true
            不包含，返回false
         */
        boolean b3 = collection.contains("杰");
        System.out.println("b3=" + b3);//true
        boolean b4 = collection.contains("斌杰");
        System.out.println("b4=" + b4);//false

        /*
            public boolean isEmpty():  判断当前集合是否为空。
            集合为空返回ture，不为空返回false
         */
        boolean b5 = collection.isEmpty();
        System.out.println("b5=" + b5);//false

        /*
            public int size():  返回集合中元素的个数。

         */
        System.out.println("size=" + collection.size());//4

        /*
            public Object[] toArray():  把集合中的元素，存储到数组中。

         */
        Object[] array = collection.toArray();
        System.out.println("array=" + Arrays.toString(array));//[bingai, 杰, 明, Coco]

        /*
            public void clear():  清空集合中所有的元素。
            但是不删除集合，集合还存在
         */

        collection.clear();
        System.out.println(collection);//[]
        System.out.println(collection.isEmpty());//true


    }
}
