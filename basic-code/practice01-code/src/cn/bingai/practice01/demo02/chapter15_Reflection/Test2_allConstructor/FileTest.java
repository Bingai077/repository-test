package cn.bingai.practice01.demo02.chapter15_Reflection.Test2_allConstructor;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取当前运行时类的属性结构
 * @author bingai
 * @create 2019-11-13 19:31
 */
public class FileTest {

    @Test
    public void test1(){
        Class<Person> clazz = Person.class;

        //获取属性结构
        //getFields():获取当前运行时类及其父类中声明为public的属性
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        //getDeclaredFields():获取当前运行时类中声明的所有属性。（不包含父类中的属性）
        System.out.println();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

    }

    //权限修饰符 数据类型 变量名
    @Test
    public void test2(){
        Class<Person> clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            //1.权限修饰符
            int modifier = f.getModifiers();
            System.out.print(Modifier.toString(modifier) + "\t");

            //2.数据类型
            Class type = f.getType();
            System.out.print(type.getName() + "\t");

            //3.变量名
            String fName = f.getName();
            System.out.println(fName);

            System.out.println();
        }


    }


}
