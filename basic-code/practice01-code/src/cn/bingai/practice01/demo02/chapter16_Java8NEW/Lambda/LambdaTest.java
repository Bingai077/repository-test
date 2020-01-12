package cn.bingai.practice01.demo02.chapter16_Java8NEW.Lambda;

import org.junit.Test;

import java.util.Comparator;

import static java.lang.Integer.compare;

/**
 *
 Lambda的使用举例
 * @author bingai
 * @create 2019-11-14 19:58
 */
public class LambdaTest {

    @Test
    public void test(){

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱中国");
            }
        };
        r1.run();

        System.out.println("==================");
        Runnable r2 = () -> System.out.println("我爱中国");
        r2.run();

    }

    @Test
    public void test1(){

        Comparator<Integer> com1 = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare1 = com1.compare(12, 21);
        System.out.println(compare1);

        System.out.println("==========");
        //Lambda表达式的写法
        Comparator<Integer> com2 = (o1,o2) -> compare(o1,o2);
        int compare2 = com2.compare(32, 21);
        System.out.println(compare2);

        System.out.println("==========");
        //方法引用
        Comparator<Integer> com3 = Integer::compare;
        int compare3 = com3.compare(32, 21);
        System.out.println(compare3);

    }

}
