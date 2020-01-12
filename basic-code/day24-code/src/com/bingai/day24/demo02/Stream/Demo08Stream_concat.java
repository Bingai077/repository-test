package com.bingai.day24.demo02.Stream;

import java.util.stream.Stream;

/*
    Stream流中的常用方法_concat:用于把流组合到一起
    如果有两个流，希望合并成为一个流，那么可以使用 Stream 接口的静态方法 concat ：
    static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)


 */
public class Demo08Stream_concat {
    public static void main(String[] args) {
        //创建一个Stream流
        Stream<String> stream1 = Stream.of("明", "Coco", "明明", "Mingming");
        //创建一个Stream流
        Stream<String> stream2 = Stream.of("斌", "斌改", "bin", "bingai");
        //把以上两个流组合成一个流
        Stream<String> stream = Stream.concat(stream1, stream2);
        //遍历stream流
        stream.forEach(s -> System.out.println(s));


    }


}
