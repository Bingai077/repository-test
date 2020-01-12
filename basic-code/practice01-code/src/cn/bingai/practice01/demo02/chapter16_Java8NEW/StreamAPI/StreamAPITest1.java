package cn.bingai.practice01.demo02.chapter16_Java8NEW.StreamAPI;

import cn.bingai.practice01.demo02.chapter16_Java8NEW.MethodReferences.Employee;
import cn.bingai.practice01.demo02.chapter16_Java8NEW.MethodReferences.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 测试Stream的中间操作
 *
 * @author bingai
 * @create 2019-11-15 14:36
 */
public class StreamAPITest1 {

    //1-筛选与切片
    @Test
    public void test1() {

        List<Employee> empList = EmployeeData.getEmployees();
        //filter(Predicate p) 接收 Lambda ， 从流中排除某些元素
        //查询员工表中工资大于7000的员工信息
        Stream<Employee> stream = empList.stream();
        stream.filter(e -> e.getSalary() >= 7000).forEach(System.out::println);

        System.out.println();
        //limit(long maxSize) 截断流，使其元素不超过给定数量
        empList.stream().limit(3).forEach(System.out::println);

        System.out.println();
        //skip(long n) 跳过元素，返回一个扔掉了前 个空流。与 limit(n) 互补 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
        empList.stream().skip(3).forEach(System.out::println);

        System.out.println();
        //distinct() 筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
        empList.add(new Employee(1000, "刘强东", 40, 8000));
        empList.add(new Employee(1000, "刘强东", 40, 8000));
        empList.add(new Employee(1000, "刘强东", 41, 8000));
        empList.add(new Employee(1000, "刘强东", 40, 8000));
        empList.add(new Employee(1000, "刘强东", 40, 8000));

        empList.stream().forEach(System.out::println);

        System.out.println();
        empList.stream().distinct().forEach(System.out::println);

    }

    //2-映 射
    @Test
    public void test2() {

        //map(Function f)
        //接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd", "ee");
        list.stream().map(String::toUpperCase).forEach(System.out::println);

        System.out.println();
        //练习1：获取员工姓名长度大于3的员工姓名
        List<Employee> employeeList = EmployeeData.getEmployees();
        Stream<String> namesStream = employeeList.stream().map(Employee::getName);
        namesStream.filter(str -> str.length() > 3).forEach(System.out::println);

        System.out.println();
        employeeList.stream().map(Employee::getName).filter(s -> s.length() > 3).forEach(System.out::println);


        //练习2：
        System.out.println();
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest1::fromStringToStream);
        streamStream.forEach(stream -> stream.forEach(System.out::println));

        //flatMap(Function f)
        //接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
        System.out.println();
        list.stream().flatMap(StreamAPITest1::fromStringToStream).forEach(System.out::println);


    }

    //将字符串中的多个字符构成的集合转换为对应的Stream的实例
    public static Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();

    }

    @Test
    public void test() {
        ArrayList list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        //list1.add(list2);
        list1.addAll(list2);
        System.out.println(list1);

    }

    //3-排序
    @Test
    public void test3() {

        //sorted() 产生一个新流，其中按自然顺序排序
        List<Integer> list = Arrays.asList(12, 565, 122, 1, 5, 485, 45621, 12306, -155, -15);
        list.stream().sorted().forEach(System.out::println);

        List<Employee> list1 = EmployeeData.getEmployees();
        //抛异常，原因：Employee没有实现Comparable接口
        //list1.stream().sorted().forEach(System.out::println);

        //sorted(Comparator com) 产生一个新流，其中按比较器顺序排序
        list1.stream().sorted((e1, e2) ->{

            int ageValue = Integer.compare(e1.getAge(), e2.getAge());
            if(ageValue != 0){
                return ageValue;
            }else{
                return -Double.compare(e1.getSalary(),e2.getSalary());
            }

        }).forEach(System.out::println);
    }


}
