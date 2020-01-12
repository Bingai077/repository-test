package com.bingai.day13.demo02.Iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
    java.util.Iterator:迭代器（对集合进行遍历）
    有两个常用的方法：
        boolean hasNext()  如果仍有元素可以迭代，则返回 true。
            判断集合中还有没有【下一个】元素，有就返回true，没有就返回false
        E next()  返回迭代的下一个元素。
            取出集合中的【下一个】元素
    Iterator迭代器是一个接口，我们无法直接使用，需要使用Iterator接口的实现类对象，获取实现类的方式比较特殊
    Collection接口中有一个方法，叫iteratoer()，这个方法返回的就是迭代器实现类对象
        Iterator<E> iterator()  返回在此 collection 的元素上进行迭代的迭代器。


    迭代器的使用步骤【重点】：
        1.使用集合中的方法iterator()获取迭代器的实现类对象，使用Iterator接口接收（多态）
        2.使用Iterator接口中的方法hasNext判断还有没有下一个元素
        3.使用Iterator接口中的方法next取出集合中的下一个元素


    发现使用迭代器取出集合中元素的代码，是一个重复的过程
    所以我们可以使用循环优化
    不知道集合中有多少元素，使用while循环
    循环结束的条件，hasNext()方法返回false



 */
public class Demo01Iterator {
    public static void main(String[] args) {
        //创建一个集合对象
        Collection<String> collection = new ArrayList<>();
        //往集合中添加元素
        collection.add("武磊");
        collection.add("C罗");
        collection.add("梅西");
        collection.add("罗伊斯");
        collection.add("阿扎尔");

        /*
            1.使用集合中的方法iterator()获取迭代器的实现类对象，使用Iterator接口接收（多态）
            注意：
                Iterator<E>接口也是有泛型的，迭代器的泛型跟着集合走，集合是什么泛型，迭代器就是什么泛型

         */
        //多态   接口           实现类对象
        Iterator<String> it = collection.iterator();

        /*
            发现使用迭代器取出集合中元素的代码，是一个重复的过程
            所以我们可以使用循环优化
            不知道集合中有多少元素，使用while循环
            循环结束的条件，hasNext()方法返回false
         */
        while(it.hasNext()){
            //String e = it.next();
            //System.out.println(e);
            System.out.print(it.next() +  " ");
        }

        System.out.println("");
        System.out.println("===============");
        for (Iterator<String> it2 = collection.iterator();it2.hasNext();){
            System.out.print(it2.next() +  " ");
        }



/*

        //2.使用Iterator接口中的方法hasNext判断还有没有下一个元素
        boolean b = it.hasNext();
        System.out.println("b=" + b);//b=true

        //3.使用Iterator接口中的方法next取出集合中的下一个元素
        String s = it.next();
        System.out.println(s);//武磊

        System.out.println(it.next());//C罗
        System.out.println(it.next());//梅西
        System.out.println(it.next());//罗伊斯
        System.out.println(it.next());//阿扎尔

        boolean b1 = it.hasNext();
        System.out.println("b=" + b1);//b=false
//        System.out.println(it.next());//NoSuchElementException，没有元素再取元素，抛出没有元素异常
*/



    }
}
