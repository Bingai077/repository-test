package cn.bingai.practice01.demo02.chapter10_EnumAndAnnotation.test04_AnnotationExperice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author bingai
 * @create 2019-11-05 10:28
 */
public class Test1 {
    public static void main(String[] args) {

    }
}

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
@interface MyTiger{
    String value() default "hello";
}



class Person{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @MyTiger("Hello")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}