package cn.bingai.practice01.demo02.chapter17_Java9_10_11NEW.Java9;

import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * @author bingai
 * @create 2019-11-16 19:11
 */
public class Java9Test1 {

    //java9新特性八：集合工厂方法：创建只读集合
    //java8中的写法
    @Test
    public void test1() {
        List<String> namesList = new ArrayList<>();
        namesList.add("Joe");
        namesList.add("Bob");
        namesList.add("Bill");
        //返回的nameList是只读的集合
        namesList = Collections.unmodifiableList(namesList);
//        namesList.add("Biangi");
        System.out.println(namesList);
    }

    @Test
    public void test2() {
        List<String> list = Collections.unmodifiableList(Arrays.asList("a", "b", "c"));
        Set<String> set = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("a", "b", "c")));
        // 如下操作不适用于jdk 8 及之前版本,适用于jdk 9
        Map<String, Integer> map = Collections.unmodifiableMap(new HashMap<>() {
            {
                put("a", 1);
                put("b", 2);
                put("c", 3);
            }
        });
        map.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    @Test
    public void test3() {
        //此时得到的集合list也是一个只读集合
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        //报异常
        //list.add(6);

    }

    //java9新特性八：集合工厂方法：创建只读集合
    @Test
    public void test4() {
        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        //不能添加
        //list1.add(6);
        System.out.println(list1);

        Set<Integer> set = Set.of(1, 24, 525, 645, 512, 55, 42, 21, 53);
        //不能添加
        //set.add(124);
        System.out.println(set);

        Map<String, Integer> map = Map.of("Bingai", 23, "Coco", 18, "Bingo", 22);
        //不能添加
        //map.put("li",34);
        System.out.println(map);

        Map<String, Integer> map1 = Map.ofEntries(Map.entry("斌改", 22), Map.entry("Coco", 20));
        //不能添加
        //map1.put("li",34);
        System.out.println(map1);

    }

    //java9新特性九：InputStream的新方法：tranferTo()
    @Test
    public void test5(){
        //ClassLoader cl = this.getClass().getClassLoader();
        try (InputStream is = new FileInputStream("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter17_Java9_10_11NEW\\Java9\\hello.txt");
             OutputStream os = new FileOutputStream("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter17_Java9_10_11NEW\\Java9\\hello1.txt")) {
            is.transferTo(os); // 把输入流中的所有数据直接自动地复制到输出流中
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
