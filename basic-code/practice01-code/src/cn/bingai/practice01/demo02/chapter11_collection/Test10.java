package cn.bingai.practice01.demo02.chapter11_collection;

import java.util.HashMap;
import java.util.Set;

/**
 使用HashMap类实例化一个Map类型的对象m1，键（String类型）和值（int型）分别用于存储员工的姓名和工资，存入数据如下：
 张三——800元；李四——1500元；王五——3000元；
 1）将张三的工资更改为2600元
 2）为所有员工工资加薪100元；
 3）遍历集合中所有的员工
 4）遍历集合中所有的工资


 * @author bingai
 * @create 2019-11-06 22:22
 */
public class Test10 {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("张三",800);
        map.put("李四",1500);
        map.put("王五",3000);

        System.out.println(map);
        map.replace("张三",800,2600);
        System.out.println(map);

        map.put("张三",2700);
        map.put("李四",1600);
        map.put("王五",3100);
        System.out.println(map);

        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            System.out.println(s + "===" + map.get(s));
        }

    }
}

