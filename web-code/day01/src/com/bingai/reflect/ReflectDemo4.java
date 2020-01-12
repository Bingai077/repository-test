package com.bingai.reflect;

import com.bingai.domain.Person;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo4 {
    /*
        获取功能：
            1. 获取成员变量们
            * Field[] getFields() ：获取所有public修饰的成员变量
            * Field getField(String name) 获取指定名称的 public修饰的成员变量

            * Field[] getDeclaredFields() 获取所有的成员变量，不考虑修饰符
            * Field getDeclaredField(String name)
            2. 获取构造方法们
            * Constructor<?>[] getConstructors()
            * Constructor<T> getConstructor(类<?>... parameterTypes)

            * Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
            * Constructor<?>[] getDeclaredConstructors()
            3. 获取成员方法们：
            * Method[] getMethods()
            * Method getMethod(String name, 类<?>... parameterTypes)

            * Method[] getDeclaredMethods()
            * Method getDeclaredMethod(String name, 类<?>... parameterTypes)
            4. 获取全类名
            * String getName()
     */
    public static void main(String[] args) throws Exception {
        //0.获取Person的class对象
        Class personClass = Person.class;
        /*
             3. 获取成员方法们：
            * Method[] getMethods()
            * Method getMethod(String name, 类<?>... parameterTypes)
         */
        //获取指定名称的方法
        Method eat_method = personClass.getMethod("eat");
        Person p = new Person();
        //执行方法
        eat_method.invoke(p);

        Method eat_method2 = personClass.getMethod("eat", String.class);
        //执行方法
        eat_method2.invoke(p,"饭");

        System.out.println("======================");

        //获取所有public修饰的方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            String name = method.getName();
            System.out.println(name);
//            method.setAccessible(true);
        }

        //获取类名
        String name = personClass.getName();
        System.out.println(name);//com.bingai.domain.Person

    }

}