package com.bingai.day11.demo07;

import java.util.ArrayList;
import java.util.List;

/*
java.util.List正是ArrayList所实现的接口。

 */

public class DemoInterface {
    public static void main(String[] args) {
        //左边是接口名称，右边是实现类名称，这就是多态的写法
        List<String> list = new ArrayList<>();//集合的创建

        List<String> result = addNames(list);
        System.out.println(result.toString());

        System.out.println("=================");
        //集合的遍历
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }

    }


    public static List<String> addNames(List<String> list){

        list.add("斌改");
        list.add("斌");
        list.add("改");
        list.add("明明");
        return list;
    }


}
