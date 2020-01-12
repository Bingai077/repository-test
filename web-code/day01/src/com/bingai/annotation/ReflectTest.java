package com.bingai.annotation;

/*

 */

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Pro(className = "com.bingai.annotation.Demo1",methodName = "show")
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        //前提：不能改变该类的任何代码，可以创建任意类对象，可以执行任意方法

        //1.解析注解
        //1.1获取该类的字节码文件对象
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        //2.获取上边的注解对象
        //其实就是在内存中生成了一个该注解接口的子类实现对象
        /*
            public class ProImpl impluments Pro{
                public String className(){
                    return "com.bingai.annotation.Demo1"
                }
                public String methodName(){
                    return "show"
                }
            }

         */

        Pro an = reflectTestClass.getAnnotation(Pro.class);
        //3.调用注解对象中定义的抽象方法，获取返回值
        String className = an.className();
        String methodName = an.methodName();
        System.out.println(className);
        System.out.println(methodName);



        //3.加载该类进内存
        Class cls = Class.forName(className);
        //4.创建对象
        Object obj = cls.newInstance();
        //5.获取方法对象
        Method method = cls.getMethod(methodName);
        //6.执行方法
        method.invoke(obj);



    }
}
