package com.bingai.day14.demo02.Set;

import java.util.HashSet;

/*
    HashSet存储自定义元素

    set集合保证元素唯一：
        存储的元素(String，Integer，...,Student,Person...),必须重写hashCode()方法和equals()方法

    要求：
        同名同年龄的人，视为同一个人，只能储存一次

 */
public class Demo03HashSetSavePerson {
    public static void main(String[] args) {
        //创建HashSet集合存储Person
        HashSet<Person> hashSet = new HashSet<>();
        Person person1 = new Person("bingai",18);
        Person person2 = new Person("斌",18);
        Person person3 = new Person("bingai",18);

        hashSet.add(person1);
        hashSet.add(person2);
        hashSet.add(person3);

        System.out.println(person1.hashCode());//717356484//重写后-108138389
        System.out.println(person3.hashCode());//475266352//-108138389
        System.out.println(person1 == person3);//false//false
        System.out.println(person1.equals(person3));//false//true
        System.out.println(hashSet);//没有重写hashCode和equals方法,三个人都存进来了//[Person{name='bingai', age=18}, Person{name='斌', age=18}]



    }
}
