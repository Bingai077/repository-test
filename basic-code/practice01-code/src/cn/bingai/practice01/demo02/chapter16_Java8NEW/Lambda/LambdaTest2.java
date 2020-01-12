package cn.bingai.practice01.demo02.chapter16_Java8NEW.Lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 java内置的【四大核心函数式接口】

 消费型接口：Consumer<T>  void accept(T t)

 供给型接口：Supplier<T>  T get()

 函数型接口：Function<T,R>  R apply(T t)

 断定型接口：Predicate<T>  boolean test(T t)

 *
 * @author bingai
 * @create 2019-11-15 10:18
 */
public class LambdaTest2 {

    @Test
    public void test1(){

        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("学习使我快乐, 花" + aDouble + "培训");
            }
        });

        System.out.println();

        happyTime(800,money -> System.out.println("花" + money + "去学习！"));
    }

    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test
    public void test2(){

        List<String> list = Arrays.asList("北京","南京","东京","普京","天津","荆州");
        List<String> list1 = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(list1);

        List<String> list2 = filterString(list,s -> s.contains("京"));
        System.out.println(list2);

    }

    //根据给定的规则，过滤集合中的字符串。此规则是由Predicate的方法决定
    public List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> filterList = new ArrayList<>();

        for (String s : list) {
            if(pre.test(s)){
                filterList.add(s);
            }
        }

        return filterList;

    }
}
