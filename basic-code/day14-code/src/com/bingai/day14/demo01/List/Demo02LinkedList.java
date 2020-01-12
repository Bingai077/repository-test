package com.bingai.day14.demo01.List;

import java.util.LinkedList;

/*
    java.util.LinkedList集合  impluments List接口
    LinkedList集合的特点:(List集合的特点都具备)
        1.底层是一个双向链表结构，【查询慢，增删快】
        2.里面包含了大量操作首尾元素的方法
       【注意】使用LinkedList集合特有的方法，不能使用多态

       特有的方法:
        public void addFirst(E e) :将指定元素插入此列表的开头。
        public void addLast(E e) :将指定元素添加到此列表的结尾。等效于add方法
        public void push(E e) :将元素推入此列表所表示的堆栈。
        //push()等效于addFirst()

        public E getFirst() :返回此列表的第一个元素。
        public E getLast() :返回此列表的最后一个元素。

        public E removeFirst() :移除并返回此列表的第一个元素。
        public E removeLast() :移除并返回此列表的最后一个元素。
        public E pop() :从此列表所表示的堆栈处弹出一个元素。
        //pop()等效于removeFirst()

        public boolean isEmpty() ：如果列表不包含元素，则返回true。


 */
public class Demo02LinkedList {
    public static void main(String[] args) {

        show01();
        System.out.println("==========");
        show02();
        System.out.println("==========");
        show03();
    }

    private static void show01(){
        //创建LinkedList集合对象
        LinkedList<String> linked = new LinkedList<>();
        //使用add方法往集合中添加元素
        linked.add("a");
        linked.add("b");
        linked.add("c");
        linked.add("a");
        linked.add("e");
        System.out.println(linked);//[a, b, c, a, e]

        //public void addFirst(E e) :将指定元素插入此列表的开头。
        linked.addFirst("www");
        System.out.println(linked);//[www, a, b, c, a, e]
        //public void push(E e) :将元素推入此列表所表示的堆栈。
        linked.push("wap");
        System.out.println(linked);//[wap, www, a, b, c, a, e]
        //public void addLast(E e) :将指定元素添加到此列表的结尾。等效于add方法
        linked.addLast("com");
        System.out.println(linked);//[wap, www, a, b, c, a, e, com]

    }

    private static void show02(){
        //创建LinkedList集合对象
        LinkedList<String> linked = new LinkedList<>();
        //使用add方法往集合中添加元素
        linked.add("a");
        linked.add("b");
        linked.add("c");
        linked.add("a");
        linked.add("e");
        System.out.println(linked);//[a, b, c, a, e]

        //linked.clear();//清空集合元素,再获取集合中的元素会抛出 NoSuchElementException无元素异常
        if(!linked.isEmpty()) {
            //public E getFirst() :返回此列表的第一个元素。
            System.out.println(linked.getFirst());//a
            //public E getLast() :返回此列表的最后一个元素。
            System.out.println(linked.getLast());//e
        }
    }

    private static void show03(){
        //创建LinkedList集合对象
        LinkedList<String> linked = new LinkedList<>();
        //使用add方法往集合中添加元素
        linked.add("a");
        linked.add("b");
        linked.add("c");
        linked.add("a");
        linked.add("e");
        System.out.println(linked);//[a, b, c, a, e]

        //public E removeFirst() :移除并返回此列表的第一个元素。
        System.out.println("被移除的第一个元素是：" + linked.removeFirst());//返回被移除的第一个元素
        System.out.println(linked);//[b, c, a, e]
        //public E removeLast() :移除并返回此列表的最后一个元素。
        System.out.println("被移除的最后一个元素是：" + linked.removeLast());//返回被移除的最后一个元素
        System.out.println(linked);//[b, c, a]
        //public E pop() :从此列表所表示的堆栈处弹出一个元素。
        System.out.println("被移除的第一个元素是：" + linked.pop());//b
        System.out.println(linked);//[c, a]



    }


}
