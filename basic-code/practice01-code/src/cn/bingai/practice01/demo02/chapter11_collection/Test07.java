package cn.bingai.practice01.demo02.chapter11_collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author bingai
 * @create 2019-11-06 19:01
 */
public class Test07 {

    /*
        创建有序的map集合的实例化对象，添加元素，查看排序结果

     */
    @Test
    public void test2() {
        TreeMap map = new TreeMap();
        map.put("bingai", 18);
        map.put("bingo", 22);
        map.put("bingai1", 18);
        map.put("bingo1", 22);
        map.put("bingai2", 18);
        map.put("bingo2", 22);
        map.put("bingai3", 18);
        map.put("bingo22", 22);
        map.put("bingai52", 18);
        map.put("bingo88", 22);

        System.out.println(map);
    }


    /*
        通过两种方法遍历上题中的map集合
     */
    @Test
    public void test1() {
        HashMap map = new HashMap();
        map.put("bingai", 18);
        map.put("bingo", 22);
        map.put(123, 456);
        map.put(124.253, "bin");
        map.put(true, 3.14159);
        map.put('中', '国');
        map.put('美', '国');
        System.out.println(map);

        //遍历方式一：键找值
        System.out.println("==========遍历方式一：键找值==========");
        Set set = map.keySet();
        for (Object key : set) {
            System.out.println(key + "===" + map.get(key));
        }

        //遍历方式二：键值对
        System.out.println("==========遍历方式二：键值对==========");
        Set set1 = map.entrySet();
        for (Object o : set1) {
            Map.Entry o1 = (Map.Entry) o;
            System.out.println(o1.getKey() + "===" + o1.getValue());
        }


    }

    /*
        定义一个Map接口类型的变量，引用一个实现类，添加键值对，
        判断集合中是否包含某一key值，
        通过某一key值得到value值，通过某一key删除键值对，把另一个map集合添加到此map集合，
        判断是否为空，清除集合，返回集合里元素的个数等常用操作。

     */
    @Test
    public void test() {
        HashMap map = new HashMap();
        map.put("bingai",18);
        map.put("bingo",22);
        map.put(123,456);
        map.put(124.253,"bin");
        map.put(true,3.14159);
        map.put('中','国');
        map.put('美','国');
        System.out.println(map);

        boolean b = map.containsKey("中");
        System.out.println(b);//false
        boolean b1 = map.containsKey('中');
        System.out.println(b1);//true
        boolean b2 = map.containsValue(3.14159);
        System.out.println(b2);//true

        map.remove('美');
        System.out.println(map);
        map.remove("bingo",22);
        System.out.println(map);

        HashMap map1 = new HashMap();
        map1.put("bingai1",18);
        map1.put("bingo",22);
        map1.put(1234,456);
        map1.put(1245.253,"bin");
        map.putAll(map1);
        System.out.println(map);

        System.out.println(map.size());//9
        map.clear();
        System.out.println(map.size());//0
        System.out.println(map);{}
        boolean isEmpty = map.isEmpty();
        System.out.println(isEmpty);//true



    }

}
