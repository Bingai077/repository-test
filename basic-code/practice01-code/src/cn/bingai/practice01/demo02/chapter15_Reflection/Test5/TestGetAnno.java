package cn.bingai.practice01.demo02.chapter15_Reflection.Test5;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 1)自定义一个有效的Annotation注释名为MyAnnotation，其中有属性myname创建Student类并重写toString()，toString()要求使用三个基本的Annotation和自定义的MyAnnotation注释
   2)创建TestGetAnno类，打印出Student类的toString方法的所有注释

 * @author bingai
 * @create 2019-11-14 10:06
 */
public class TestGetAnno {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class clazz = Class.forName("cn.bingai.practice01.demo02.chapter15_Reflection.Test5.Student");

        Student s = (Student) clazz.newInstance();

        Method toString = clazz.getDeclaredMethod("toString");

        Annotation[] annotations = toString.getDeclaredAnnotations();

        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

    }

}
