package cn.bingai.practice01.demo02.chapter10_EnumAndAnnotation.test04_AnnotationExperice;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @author bingai
 * @create 2019-11-05 10:35
 */
public class Test2 {

    public static void main(String[] args) {


    }

}

class Student{
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}


@Documented
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE,TYPE_PARAMETER,TYPE_USE})
@Retention(RetentionPolicy.CLASS)
@interface StuAnnotation{

    String value();
}

