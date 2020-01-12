package com.bingai.reflect;

import com.bingai.domain.Person;

import java.lang.reflect.Field;

public class ReflectDemo2 {
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
            1. 获取成员变量们
            * Field[] getFields() ：获取所有public修饰的成员变量
            * Field getField(String name) 获取指定名称的 public修饰的成员变量

            * Field[] getDeclaredFields() 获取所有的成员变量，不考虑修饰符
            * Field getDeclaredField(String name)
         */
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);//a
        }

        System.out.println("=========");
        Field field = personClass.getField("a");
        //获取成员变量a的值
        Person p = new Person();
        Object value = field.get(p);
        System.out.println(value);
        //设置a的值
        field.set(p,"斌改");
        System.out.println(p);

        System.out.println("===================");
        //Field[] getDeclaredFields() 获取所有的成员变量，不考虑修饰符
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        //Field getDeclaredField(String name)
        Field d = personClass.getDeclaredField("d");
        //忽略访问权限修饰符的安全检查
        d.setAccessible(true);//暴力反射
        Object value2 = d.get(p);
        System.out.println(value2);


    }

}