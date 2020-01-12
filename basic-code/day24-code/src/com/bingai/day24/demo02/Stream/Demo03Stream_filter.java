package com.bingai.day24.demo02.Stream;

import java.util.stream.Stream;

/*
    Stream流中的常用方法_filter：用于对Stream流中的数据进行过滤
    Stream<T> filter(Predicate<? super T> predicate);
    filter方法的参数Predicate是一个函数式接口，所以可以传递Lambda表达式，对数据进行过滤
    Predicate中的抽象方法：
        boolean test2_exer(T t);

 */
public class Demo03Stream_filter {
    public static void main(String[] args) {
        //创建一个Stream流
        Stream<String> stream = Stream.of("斌改", "斌", "改", "明明", "明");

        //对Stream流中的元素进行过滤，只要姓斌的人
        //stream.filter((String name)->{return name.startsWith("张");});
        Stream<String> stream1 = stream.filter(s -> s.startsWith("斌"));
        //遍历stream1流
        stream1.forEach(s -> System.out.println(s));

        /*
            Stream流属于管道流，只能消费(使用)一次
            第一个Stream流调用完毕方法，数据就会流转到下一个Stream上
            而这时第一个Stream流已经使用完毕，就会关闭了
            所以第一个Stream流就不能再调用方法了
            IllegalStateException: stream has already been operated upon or closed
         */
        //遍历stream流
        //stream.forEach(s -> System.out.println(s));




    }
}
