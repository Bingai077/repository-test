package com.bingai.day15.demo04.JDK9;

import java.util.List;
import java.util.Map;
import java.util.Set;

/*
    JDK9的新特性：
        List接口，Set接口，Map接口：里面增加了一个静态的方法of，可以给集合一次性添加多个元素
        static <E> List<E> of​(E... elements) 返回包含任意数量元素的不可变列表。
        使用前提：
            当集合中存储元素的个数已经确定了，不再改变时使用
        注意：
            1.of方法只适用于List接口，Set接口，Map接口，不适用于接口的实现类
            2.of方法的返回值是一个不能改变的集合，集合不能再使用add，put方法添加元素，会抛出异常
            3.Set接口和Map接口在调用of方法的时候，不能有重复的元素，否则会抛出异常。
 */
public class Demo01JDK9 {
    public static void main(String[] args) {
        List<String> list = List.of("a", "b", "h", "h", "d", "h");
        System.out.println(list);//[a, b, h, h, d, h]
//        list.add("w");//UnsupportedOperationException不支持操作异常

//        Set<String> set = Set.of("a", "b", "c", "a", "d");//IllegalArgumentException非法参数异常，有重复的元素
        Set<String> set = Set.of("a", "b", "c", "e", "d");
        System.out.println(set);//[a, c, b, e, d]
//        set.add("h");//UnsupportedOperationException不支持操作异常

        Map<String, String> map = Map.of("bingai", "18", "bin", "20", "jie", "22");
        System.out.println(map);
//        Map<String, String> map1 = Map.of("bin", "18", "bin", "20", "jie", "22");//IllegalArgumentException非法参数异常，有重复的元素
//        map.put("ming","18");//UnsupportedOperationException不支持操作异常


    }
}
