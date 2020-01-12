package com.bingai.day14.demo05.Collections;

import java.util.ArrayList;
import java.util.Collections;

/*
    public static <T> void sort(List<T> list) :将集合中元素按照默认规则排序。
    【只能用于Set集合】

    【注意事项】
         sort(List<T> list)使用前提：被排序的集合里边存储的元素，
             必须实现Comparable，【重写】接口中的方法comparaTo定义排序规则

    Comparable接口的排序规则：
        自己(this) - 参数     升序
        参数   -  自己(this)  降序

 */
public class Demo02Sort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(4);
        System.out.println(list);//[1, 3, 2, 4]

        //public static <T> void sort(List<T> list) :将集合中元素按照默认规则排序。
        Collections.sort(list);//默认是升序
        System.out.println(list);//[1, 2, 3, 4]

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("chen");
        list1.add("jie");
        list1.add("bin");
        list1.add("Coco");
        list1.add("Ming");
        System.out.println(list1);//[chen, jie, bin, Coco, Ming]
        Collections.sort(list1);//字符串首字母默认升序排序
        System.out.println(list1);//[Coco, Ming, bin, chen, jie]

        ArrayList<Person> list2 = new ArrayList<>();
        list2.add(new Person("斌改",18));
        list2.add(new Person("斌",20));
        list2.add(new Person("改",22));
        list2.add(new Person("名",19));
        System.out.println(list2);//[Person{name='斌改', age=18}, Person{name='斌', age=20}, Person{name='改', age=22}, Person{name='名', age=19}]

        Collections.sort(list2);
        //System.out.println(list2);//[Person{name='斌改', age=18}, Person{name='名', age=19}, Person{name='斌', age=20}, Person{name='改', age=22}]
        System.out.println(list2);//[Person{name='改', age=22}, Person{name='斌', age=20}, Person{name='名', age=19}, Person{name='斌改', age=18}]

    }
}
