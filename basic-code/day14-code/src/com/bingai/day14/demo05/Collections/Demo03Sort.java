package com.bingai.day14.demo05.Collections;

import java.text.CollationKey;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
        public static <T> void sort(List<T> list，Comparator<? super T> ) :将集合中元素按照指定规则排序。

        Comparator和Comparable的【区别】
            Comparable：自己(this)和别人(参数)比较，自己需要实现Comparable接口，重写比较的规则compareTo方法
            Comparator：相当于找一个第三方的裁判，比较两个

        Comparator排序规则：
            o1 - o2  升序
            o2 - o1  降序

 */
public class Demo03Sort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(4);
        System.out.println(list);//[1, 3, 2, 4]

        Collections.sort(list, new Comparator<Integer>() {
            //重写比较的规则
            @Override
            public int compare(Integer o1, Integer o2) {
                //return o1 - o2;//升序
                return o2 - o1;//降序
            }
        });

        //System.out.println(list);//[1, 2, 3, 4]
        System.out.println(list);//[4, 3, 2, 1]


        ArrayList<Student> list1 = new ArrayList<>();
        list1.add(new Student("bingai",18));
        list1.add(new Student("bin",20));
        list1.add(new Student("gai",18));
        list1.add(new Student("Coco",16));
        list1.add(new Student("Ming",15));
        System.out.println(list1);//[Student{name='bingai', age=18}, Student{name='bin', age=20}, Student{name='gai', age=19}, Student{name='Coco', age=16}, Student{name='Ming', age=15}]

       /* Collections.sort(list1, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //按照年龄升序排序
                return o1.getAge() - o2.getAge();
            }
        });*/

        Collections.sort(list1, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //按照年龄升序排序
                int  result = o1.getAge() - o2.getAge();
                //如果两个人年龄相同，再使用姓名的第一个字比较
                if(result == 0){
                   result = o1.getName().charAt(0) - o2.getName().charAt(0);
                }
                return result;
            }
        });

        System.out.println(list1);//[Student{name='Ming', age=15}, Student{name='Coco', age=16}, Student{name='bingai', age=18}, Student{name='gai', age=19}, Student{name='bin', age=20}]


    }
}
