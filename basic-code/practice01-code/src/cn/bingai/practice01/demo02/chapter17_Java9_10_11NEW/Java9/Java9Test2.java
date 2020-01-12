package cn.bingai.practice01.demo02.chapter17_Java9_10_11NEW.Java9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author bingai
 * @create 2019-11-16 19:57
 */
public class Java9Test2 {

    //java9新特性十：Stream API的加强
    @Test
    public void test1(){

        List<Integer> list = Arrays.asList(12, 14, 18, 27, 35, 952, 455, 7, -225);
        //takeWhile 返回从开头开始的尽量多的元素
        list.stream().takeWhile(x -> x < 60).forEach(System.out::println);

        System.out.println();

        //dropWhile 的行为与 takeWhile 相反， 返回剩余的元素。
        list.stream().dropWhile(x -> x < 60).forEach(System.out::println);

    }

    @Test
    public void test2(){

        //of()参数中的多个元素，可以包含null值
        Stream<Integer> stream = Stream.of(1, 2, 3, null);
        stream.forEach(System.out::println);

        System.out.println();
        //of()参数不能只存储单个null值，否则报异常
        //Stream<Integer> stream1 = Stream.of(null);
        //stream1.forEach(System.out::println);

        //ofNullable():形参变量可以为null值的单个元素
        Stream<Integer> stream2 = Stream.ofNullable(null);
        stream2.forEach(System.out::println);

    }

    @Test
    public void test3(){

        //创建无限流
        Stream.iterate(0,x -> x + 1).limit(10).forEach(System.out::println);

        System.out.println();
        //java9中重载的方法
        Stream.iterate(0,x -> x < 100,x -> x + 1).forEach(System.out::println);

    }

    //java 9新特性十一：Optional提供的新的方法stream()
    @Test
    public void test4(){
        List<String> list = new ArrayList<>();
        list.add("Tom");
        list.add("Jerry");
        list.add("Tim");
        Optional<List<String>> optional = Optional.ofNullable(list);
        Stream<List<String>> stream = optional.stream();
        System.out.println(stream.count());
        Stream<List<String>> stream1 = optional.stream();
        stream1.flatMap(x -> x.stream()).forEach(System.out::println);


    }
}
