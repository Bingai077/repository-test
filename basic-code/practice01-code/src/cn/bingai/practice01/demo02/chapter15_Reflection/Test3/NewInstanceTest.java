package cn.bingai.practice01.demo02.chapter15_Reflection.Test3;

import java.lang.reflect.Constructor;

/**
 * 3)创建带main函数的NewInstanceTest类，利用Class类得到Student对象
 4)通过上述获取的Class对象分别调用Student有参函数和无参函数

 * @author bingai
 * @create 2019-11-14 9:15
 */

public class NewInstanceTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException {

        Class<Student> clazz = Student.class;

        Class clazz1 = Class.forName("cn.bingai.practice01.demo02.chapter15_Reflection.Test3.Student");

        Student s = new Student();
        Class clazz2 = s.getClass();

        ClassLoader classLoader = NewInstanceTest.class.getClassLoader();
        Class clazz3 = classLoader.loadClass("cn.bingai.practice01.demo02.chapter15_Reflection.Test3.Student");

        System.out.println(clazz == clazz1);
        System.out.println(clazz == clazz2);
        System.out.println(clazz == clazz3);

        Student student = clazz.newInstance();
        System.out.println(student);

        Constructor<Student> constructor1 = clazz.getDeclaredConstructor(null);
        System.out.println("空参" + constructor1);

        Constructor<Student> constructor2 = clazz.getDeclaredConstructor(String.class,int.class);
        System.out.println("带参" + constructor2);





    }



}
