package com.bingai.day13.demo03.Generic;


import java.util.ArrayList;

/*
    含有泛型的接口第二种使用方式：
        接口使用什么泛型，实现类就使用什么泛型，类跟着接口走
        就相当于定义了一个含有泛型的类，创建对象的时候确定泛型的类型
        public interface List<E> extends Collection<E> {
            boolean add(E e);
            E get(int index);
        }

        public class ArrayList<E> extends implements List<E>{
            private void add(E e, Object[] elementData, int s) {}
            public E get(int index) {}

        }
 */
public class GenericInterfaceImpl2<I> implements GenericInterface<I>{


    @Override
    public void method(I i) {
        System.out.println(i);
    }
}
