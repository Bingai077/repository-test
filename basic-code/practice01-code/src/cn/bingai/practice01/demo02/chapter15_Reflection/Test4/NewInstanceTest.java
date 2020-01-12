package cn.bingai.practice01.demo02.chapter15_Reflection.Test4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *创建Mytxt类，创建myCreate()方法完成创建文件D:\myhello.txt文件的功能。
 *创建带main方法的NewInstanceTest类，通过Class类获取Mytxt对象，调用myCreat()
 *
 * @author bingai
 * @create 2019-11-14 9:39
 */
public class NewInstanceTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

        Class clazz = Class.forName("cn.bingai.practice01.demo02.chapter15_Reflection.Test4.Mytxt");

        Mytxt s = (Mytxt) clazz.newInstance();

        Method createFile = clazz.getDeclaredMethod("createFile",String.class);
        createFile.setAccessible(true);
        createFile.invoke(s,"D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter15_Reflection\\Test4\\hello.txt");

    }
}
