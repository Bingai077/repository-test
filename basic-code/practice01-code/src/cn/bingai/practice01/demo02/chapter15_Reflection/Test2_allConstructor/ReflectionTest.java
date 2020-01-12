package cn.bingai.practice01.demo02.chapter15_Reflection.Test2_allConstructor;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 调用运行时类的指定结构：属性、方法、构造器
 * @author bingai
 * @create 2019-11-14 7:43
 */
public class ReflectionTest {
    /*
        不需掌握
     */
    @Test
    public void testField() throws Exception {
        Class<Person> clazz = Person.class;

        //创建运行时类的对象
        Person p = clazz.newInstance();

        //获取指定的属性:要求运行时类的属性声明为punlic
        //通常不采用此方式
        Field id = clazz.getField("id");

        /*设置当前属性的值
           set():参数1：指明设置哪个对象的属性
                 参数2：将此属性值设置为多少
        */
        id.set(p,1001);
        /*
            获取当前属性的值
            get():参数1：获取哪个对象的当前属性值
         */
        int pid = (int) id.get(p);
        System.out.println(pid);


    }

    //如何操作运行时类中指定的属性 ---【重点掌握】
    @Test
    public void testField1() throws Exception {
        Class<Person> clazz = Person.class;

        //创建运行时类的对象
        Person p = clazz.newInstance();

        //1.获取属性getDeclaredField(String fieldName)
        Field name = clazz.getDeclaredField("name");

        //2.保证当前属性是可访问的
        name.setAccessible(true);

        //3.获取、设置指定对象的此属性值
        name.set(p,"斌改");

        System.out.println(name.get(p));

    }

    //如何操作运行时类中指定的方法 ---【重点掌握】
    @Test
    public void testMethod() throws Exception {
        Class<Person> clazz = Person.class;

        //创建运行时类的对象
        Person p = clazz.newInstance();

        //1.获取方法getDeclaredMethod():参数1：获取方法的名称 参数2：获取方法的形参列表
        Method show = clazz.getDeclaredMethod("show", String.class);

        //2.保证当前方法是可访问的
        show.setAccessible(true);

        //3.invoke():参数1：方法的调用者  参数2：方法的实参
        // invoke()的返回值即为对应类中调用方法的返回值

        Object returnValue = show.invoke(p, "CHN");//String nation = p.show("CHN")
        System.out.println(returnValue);

        System.out.println("==============如何调用静态方法==============");

        //private static  void showDesc()
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        //如果调用的运行时类中的方法没有返回值，这此invoke(),返回null
        Object returnVal = showDesc.invoke(Person.class);
        //Object returnVal = showDesc.invoke(p);
        //Object returnVal = showDesc.invoke(null);
        System.out.println(returnVal);
    }

    //如何操作运行时类中指定的构造器
    @Test
    public void testConstructor() throws Exception {
        Class<Person> clazz = Person.class;

        //1.获取属性getDeclaredConstructor():参数：指明构造器的参数列表
        Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class);

        //2.保证当前构造器是可访问的
        constructor.setAccessible(true);

        //3.调用此构造器创建运行时类的对象
        Person p = constructor.newInstance("bingai");
        System.out.println(p);

    }




}
