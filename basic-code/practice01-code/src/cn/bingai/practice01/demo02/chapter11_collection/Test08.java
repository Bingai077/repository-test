package cn.bingai.practice01.demo02.chapter11_collection;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 使用Map接口的实现类完成员工工资(姓名--工资)的摸拟：
 * 1)添加几条信息
 * 2)列出所有的员工姓名
 * 3)列出所有员工姓名及其工资
 * 4)删除名叫“Tom”的员工信息
 * 5)输出Jack的工资，并将其工资加1000元(通过取值实现)
 * 6)将所有工资低于1000元的员工的工资上涨20%(通过取值实现)
 *
 * @author bingai
 * @create 2019-11-06 19:26
 */
public class Test08 {
    public static void main(String[] args) {
        TreeMap<String,Integer> map = new TreeMap();
        map.put("Tom",12000);
        map.put("Bingai",12500);
        map.put("Jack",8000);
        map.put("Coco",13000);
        map.put("Bingo",19500);
        map.put("Kobe",20000000);
        map.put("Ming",18000);
        System.out.println(map);

        map.remove("Tom");

        Integer salary = map.get("Jack");
        System.out.println("Jack的工资为：" + salary);
        map.replace("Jack",8000,9000);
        System.out.println("Jack的工资为：" + map.get("Jack"));

        System.out.println("========");
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + "===" + entry.getValue());
        }
    }
}
