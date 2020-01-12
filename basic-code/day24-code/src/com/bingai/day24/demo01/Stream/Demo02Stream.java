package com.bingai.day24.demo01.Stream;

import java.util.ArrayList;
import java.util.List;

/*
    使用Stream流的方式，遍历集合，对集合中的数据进行过滤
    Stream流是JDK1.8之后出现的
    关注的是做什么，而不是怎么做

 */
public class Demo02Stream {
    public static void main(String[] args) {
        //创建一个List集合，存储姓名
        List<String> list = new ArrayList<>();
        list.add("斌改");
        list.add("明明");
        list.add("斌");
        list.add("改");
        list.add("明");

        //对List集合中的元素进行过滤，只要以斌开头的元素，存储到一个新的集合中
        //对list1集合进行过滤，只要姓名长度为2的人
        //遍历lsit2集合
        list.stream()
                .filter(name -> name.startsWith("斌"))
                .filter(name -> name.length() == 2)
                .forEach(name -> System.out.println(name));


    }
}
