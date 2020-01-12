package com.bingai.day24.demo02.Stream;

import java.util.stream.Stream;

/*
    Stream流中的常用方法_skip:用于跳过元素
    如果希望跳过前几个元素，可以使用 skip 方法获取一个截取之后的新流
    Stream<T> skip(long n);
    如果流的当前长度大于n，则跳过前n个；否则将会得到一个长度为0的空流。


 */
public class Demo07Stream_skip {
    public static void main(String[] args) {
        //获取一个Stream流、
        String[] arr = {"斌改","斌","gai","改","Coco","明"};
        Stream<String> stream = Stream.of(arr);
        //使用skip方法跳过前四个元素
        Stream<String> stream1 = stream.skip(4);
        //遍历stream1流
        stream1.forEach(s -> System.out.println(s));

    }
}
