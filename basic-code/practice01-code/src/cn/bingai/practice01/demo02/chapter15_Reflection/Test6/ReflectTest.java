package cn.bingai.practice01.demo02.chapter15_Reflection.Test6;

import java.lang.reflect.Field;

/**
 * @author bingai
 * @create 2019-11-14 10:31
 */
/*
1.	定义PrivateTest类，有私有name属性，并且属性值为hellokitty，只提供name的getName的公有方法
2.	创建带有main方法ReflectTest的类，利用Class类得到私有的name属性
3.	修改私有的name属性值，并调用getName()的方法打印name属性值

 */
public class ReflectTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {

        Class<PrivateTest> clazz = PrivateTest.class;
        PrivateTest p = clazz.newInstance();

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p,"HelloJava");
        Object o = name.get(p);
        System.out.println(o);

    }


}
