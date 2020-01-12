package cn.bingai.practice01.demo02.chapter12_Generic;

import org.junit.Test;

import java.util.HashMap;
import java.util.Set;

/**
 1.	使用HashMap类实例化一个Map类型的对象m1，
 键（String类型）和值（int型）分别用于存储员工的姓名和工资，
 存入数据如下：	张三——800元；李四——1500元；王五——3000元；
 2.	将张三的工资更改为2600元
 3.	为所有员工工资加薪100元；
 4.	遍历集合中所有的员工
 5.	遍历集合中所有的工资

 * @author bingai
 * @create 2019-11-08 17:03
 */
public class Test03 {
    @Test
    public void test(){

        HashMap<String, Integer> m1 = new HashMap<>();
        m1.put("张三",800);
        m1.put("李四",1500);
        m1.put("王五",3000);

        System.out.println(m1);
        m1.put("张三",2600);

        m1.put("张三",900);
        m1.put("李四",1600);
        m1.put("王五",3100);

        Set<String> keys = m1.keySet();
        for (String key : keys) {
            System.out.println(key + "--->" + m1.get(key));
        }


    }
}
