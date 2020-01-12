package cn.bingai.practice01.demo02.chapter15_Reflection.Test5;


/**
 * @author bingai
 * @create 2019-11-14 10:00
 */
public class Student {
    private String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @SuppressWarnings("unchecked")
    @Deprecated
    @Override
    @MyAnnontation1(myname = "Student")
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
