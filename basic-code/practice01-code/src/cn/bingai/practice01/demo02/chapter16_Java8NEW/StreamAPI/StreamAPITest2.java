package cn.bingai.practice01.demo02.chapter16_Java8NEW.StreamAPI;

import cn.bingai.practice01.demo02.chapter16_Java8NEW.MethodReferences.Employee;
import cn.bingai.practice01.demo02.chapter16_Java8NEW.MethodReferences.EmployeeData;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 测试Stream 的终止操作
 * @author bingai
 * @create 2019-11-15 15:51
 */
public class StreamAPITest2 {

    //1-匹配与查找
    @Test
    public void test1(){
        //allMatch(Predicate p) 检查是否匹配所有元素
            //练习1:是否所有的员工的年龄都大于18岁
        List<Employee> list = EmployeeData.getEmployees();
        boolean b = list.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(b);

        //anyMatch(Predicate p) 检查是否至少匹配一个元素
            //练习2：是否存在员工的工资大于10000元
        boolean b1 = list.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(b1);

        //noneMatch(Predicate p) 检查是否【没有】匹配所有元素
            //练习3：是否存在员工姓“雷”
        boolean b2 = list.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(b2);

        //findFirst() 返回第一个元素
        Optional<Employee> employee = list.stream().findFirst();
        System.out.println(employee.get());

        //findAny() 返回当前流中的任意元素
        Optional<Employee> employee1 = list.parallelStream().findAny();
        System.out.println(employee1);


        //count() 返回流中元素总数
        long count = list.stream().filter(e -> e.getSalary() > 8000).count();
        System.out.println(count);

        //max(Comparator c) 返回流中最大值
            //练习4：返回最高的工资
        Optional<Double> maxSalary = list.stream().map(Employee::getSalary).max(Double::compareTo);
        System.out.println(maxSalary);

        //min(Comparator c) 返回流中最小值
            //练习5：返回最底工资的员工
        Optional<Employee> employee2 = list.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(employee2);


        //forEach(Consumer c)
        //内部迭代(使用 Collection 接口需要用户去做迭代，称为外部迭代。相反， Stream API 使用内部迭代——它帮你把迭代做了)
        list.stream().forEach(System.out::println);

        System.out.println();
        //使用集合的遍历操作
        list.forEach(System.out::println);

    }

    //2-归约  ——归成一个
    @Test
    public void test2(){

        //reduce(T iden, BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 T
            //练习1：计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        //reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
            //练习2:计算公司所有员工工资的总和
        List<Employee> list1 = EmployeeData.getEmployees();

        Optional<Double> sumSalary1 = list1.stream().map(Employee::getSalary).reduce((d1,d2) -> d1 + d2);

        Optional<Double> sumSalary = list1.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(sumSalary);
        System.out.println(sumSalary1);
    }

    //3-收集
    @Test
    public void test3(){

        //collect(Collector c)
        //将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
            //练习：查找工资大于8000的员工，结果返回一个List或Set
        List<Employee> list = EmployeeData.getEmployees();
        List<Employee> list1 = list.stream().filter(e -> e.getSalary() > 8000).collect(Collectors.toList());
        list1.forEach(System.out::println);

        System.out.println();
        Set<Employee> set = list.stream().filter(employee -> employee.getSalary() > 6000).collect(Collectors.toSet());
        set.forEach(System.out::println);

        System.out.println();
        ArrayList<Employee> arrayList = list.stream().filter(employee -> employee.getSalary() > 6000).collect(Collectors.toCollection(ArrayList::new));
        arrayList.forEach(System.out::println);

    }


}
