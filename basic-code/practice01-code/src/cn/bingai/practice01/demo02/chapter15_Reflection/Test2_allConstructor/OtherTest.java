package cn.bingai.practice01.demo02.chapter15_Reflection.Test2_allConstructor;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author bingai
 * @create 2019-11-13 23:29
 */
public class OtherTest {
    /*
        获取构造器结构
     */
    @Test
    public void test1(){
        Class<Person> clazz = Person.class;

        //getConstructors():获取当前类中声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println();

        //getDeclaredConstructors():获取当前运行时类中声明的所有构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
    }

    /*
        获取运行时类的父类
     */
    @Test
    public void test2(){
        Class<Person> clazz = Person.class;
        Class superclass = clazz.getSuperclass();

        System.out.println(superclass);
    }
 /*
        获取运行时类的带泛型的父类
     */
    @Test
    public void test3(){
        Class<Person> clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();

        System.out.println(genericSuperclass);
    }
/*
        获取运行时类的带泛型的父类的泛型

        代码：逻辑性代码 vs 功能性代码
     */
    @Test
    public void test4(){
        Class<Person> clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;

        //获取泛型类型
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());
        System.out.println(((Class)actualTypeArguments[0]).getName());
    }

    /*
        获取运行时类的实现的接口
     */
    @Test
    public void test5(){
        Class<Person> clazz = Person.class;
        Class[] interfaces = clazz.getInterfaces();
        for (Class in : interfaces) {
            System.out.println(in);
        }

        System.out.println();

        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class in : interfaces1) {
            System.out.println(in);
        }
    }

    /*
        获取运行时类所在的包
     */
    @Test
    public void test6(){
        Class<Person> clazz = Person.class;

        Package pack = clazz.getPackage();
        System.out.println(pack);

    }

    /*
       获取运行时类声明的注解
    */
    @Test
    public void test7(){
        Class<Person> clazz = Person.class;

        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

    }



}
