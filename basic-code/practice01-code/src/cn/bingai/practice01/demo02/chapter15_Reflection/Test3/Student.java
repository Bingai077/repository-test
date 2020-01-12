package cn.bingai.practice01.demo02.chapter15_Reflection.Test3;

/**
 *
 1)创建Student类，类中有属性name和age并封装属性
 2)重载Student的构造函数，一个是无参构造并，另一个是带两个参数的有参构造，要求在构造函数打印提示信息


 * @author bingai
 * @create 2019-11-14 9:18
 */
public class Student {

    private String name;
    private int age;

    public Student() {
        System.out.println("Student()");
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
