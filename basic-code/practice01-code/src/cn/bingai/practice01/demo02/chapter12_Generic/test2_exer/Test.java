package cn.bingai.practice01.demo02.chapter12_Generic.test2_exer;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 定义一个 Employee 类。
 * 该类包含： private 成员变量 name,age,birthday，其中 birthday 为
 * MyDate 类的对象；
 * 并为每一个属性定义 getter, setter 方法；
 * 并重写 toString 方法输出 name, age, birthday
 * MyDate 类包含:
 * private 成员变量 year,month,day；并为每一个属性定义 getter, setter
 * 方法；
 * 创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中（下一章：
 * TreeSet 需使用泛型来定义）
 * 分别按以下两种方式对集合中的元素进行排序，并遍历输出：
 * 1). 使 Employee 实现 Comparable 接口，并按 name 排序
 * 2). 创建 TreeSet 时传入 Comparator 对象，按生日日期的先后排序
 *
 * @author bingai
 * @create 2019-11-07 16:47
 */
public class Test {
    public static void main(String[] args) {

        TreeSet<Employee> set = new TreeSet<>(new Comparator<Employee>() {

            @Override
            public int compare(Employee o1, Employee o2) {

                //方式一：使用泛型
                if (o1.getBirthday().getYear() != o2.getBirthday().getYear()) {
                    return Integer.compare(o1.getBirthday().getYear(), o2.getBirthday().getYear());
                } else if (o1.getBirthday().getMonth() != o2.getBirthday().getMonth()) {
                    return Integer.compare(o1.getBirthday().getMonth(), o2.getBirthday().getMonth());
                } else {
                    return Integer.compare(o1.getBirthday().getDay(), o2.getBirthday().getDay());
                }
            }
        });

        //TreeSet<Employee> set = new TreeSet<>();

        set.add(new Employee("斌改", 18, new MyDate(1999, 9, 9)));
        set.add(new Employee("斌gou", 20, new MyDate(2009, 8, 8)));
        set.add(new Employee("明明", 19, new MyDate(2010, 8, 9)));
        set.add(new Employee("梅西", 21, new MyDate(2004, 6, 6)));
        set.add(new Employee("科比", 35, new MyDate(1978, 8, 30)));
        set.add(new Employee("科比", 35, new MyDate(1978, 8, 31)));
        set.add(new Employee("科比2", 35, new MyDate(1978, 7, 30)));
        set.add(new Employee("科比1", 35, new MyDate(1978, 8, 29)));

        for (Employee e : set)

        {
            System.out.println(e);
        }

    }
}

