package com.bingai.day24.demo01.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    使用传统的方式，遍历集合，对集合中的数据进行过滤
 */
public class Demo01List {
    public static void main(String[] args) {
        //创建一个List集合，存储姓名
        List<String> list = new ArrayList<>();
        list.add("斌改");
        list.add("明明");
        list.add("斌");
        list.add("改");
        list.add("明");

        //对List集合中的元素进行过滤，只要以斌开头的元素，存储到一个新的集合中
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : list) {
            if(s.startsWith("斌")){
                list1.add(s);
            }
        }

        //对list1集合进行过滤，只要姓名长度为2的人
        ArrayList<String> list2 = new ArrayList<>();
        for (String s : list1) {
            if(s.length() == 2){
                list2.add(s);
            }
        }

        //遍历lsit2集合
        for (String s : list2) {
            System.out.println(s);
        }


    }
}
