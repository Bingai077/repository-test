package cn.bingai.practice01.demo02.chapter15_Reflection.Test7;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author bingai
 * @create 2019-11-14 10:39
 */
/*
1.	利用Class类的forName方法得到File类
2.	在控制台打印File类的所有构造器
3.	通过newInstance的方法创建File对象，并创建D：\mynew.txt文件

 */
public class FileTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException {

        Class clazz = Class.forName("java.io.File");

        Constructor[] constructors = clazz.getDeclaredConstructors();

        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }


        System.out.println();
        Constructor file1 = clazz.getDeclaredConstructor(String.class);
        System.out.println(file1);

        File file = (File) file1.newInstance("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter15_Reflection\\Test7\\mynew.txt");

        file.createNewFile();

    }

}
