package com.bingai.day24.demo02.Stream;

import java.util.stream.Stream;

/*
    如果需要将流中的元素映射到另一个流中，可以使用 map 方法
     <R> Stream<R> map(Function<? super T, ? extends R> mapper);
    该接口需要一个 Function 函数式接口参数，可以将当前流中的T类型数据转换为另一种R类型的流。
        java.util.stream.Function 函数式接口，其中唯一的抽象方法为：
            R apply(T t);
 */
public class Demo04Stream_map {
    public static void main(String[] args) {
        //获取一个Stream类型的Stream流
        Stream<String> stream = Stream.of("1", "2", "3", "4");
        //使用map方法把字符串类型的整数，转换(映射)为Integer类型的整数
        Stream<Integer> stream1 = stream.map(s -> Integer.parseInt(s));
        //遍历stream1流
        stream1.forEach(s -> System.out.println(s));


    }
}
