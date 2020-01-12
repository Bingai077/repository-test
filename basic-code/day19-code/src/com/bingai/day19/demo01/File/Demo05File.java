package com.bingai.day19.demo01.File;

import java.io.File;
import java.io.IOException;

/*
File类创建删除功能的方法
    public boolean createNewFile() ：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。
    public boolean delete() ：删除由此File表示的文件或目录。
    public boolean mkdir() ：创建由此File表示的目录。
    public boolean mkdirs() ：创建由此File表示的目录，包括任何必需但不存在的父目录

 */
public class Demo05File {
    public static void main(String[] args) {
        show01();
        System.out.println("=======");
        show02();
        System.out.println("=======");
        show03();

    }

    private static void show01(){
        /*
           public boolean createNewFile() ：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。
           创建文件的路径和名称在构造方法中给出（构造方法的参数）
           返回值：布尔值
                 true：文件不存在，创建文件，返回true
                 false：文件存在，不会创建，返回false
           注意：
                1.此方法只能创建文件，不能创建文件夹
                2.创建文件的路径必须存在，否则会抛出异常
           createNewFile声明抛出了IOException，我们调用这个方法，就必须处理这个异常，要么throws，要么try...catch
         */
        File file1 = new File("D:\\IdeaProjects\\basic-code\\day19-code\\src\\com\\bingai\\day19\\demo01\\File\\1.txt");
        try {
            boolean newFile1 = file1.createNewFile();
            System.out.println(newFile1);//true,第二次false
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file2 = new File("day19-code\\src\\com\\bingai\\day19\\demo01\\File\\2.txt");
        try {
            boolean newFile2 = file2.createNewFile();
            System.out.println(newFile2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file3 = new File("day19-code\\src\\com\\bingai\\day19\\demo01\\File\\新建文件夹\\");
        boolean file3NewFile = false;
        try {
            file3NewFile = file3.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file3NewFile);//不要被名称迷糊，要看类型

       /* File file4 = new File("day19-code\\src\\com\\bingai\\day19\\demo0\\Fil");

        try {
            boolean file4NewFile = file4.createNewFile();
            System.out.println(file4NewFile);//路径不存在，会抛出IOException异常
        } catch (IOException e) {
            e.printStackTrace();
        }*/


    }

    private static void show03(){
        /*
           public boolean delete() ：删除由此File表示的文件或目录。
           此方法可以删除构造方法路径中的文件/文件夹
           返回值：布尔值
                true：文件/文件夹删除成功，返回true
                false：文件夹中有内容，不会删除，返回false，构造方法中不存在，返回false
           注意：
                delete方法是自接在硬盘中删除文件/文件夹,不走回收站，删除要谨慎

         */
        File file1 = new File("day19-code\\src\\com\\bingai\\day19\\demo01\\File\\新建文件夹");
        boolean b1 = file1.delete();
        System.out.println(b1);//true
        File file2 = new File("day19-code\\src\\com\\bingai\\day19\\demo01\\File\\111.txt");
        boolean b2 = file2.delete();
        System.out.println(b2);//true
        File file3 = new File("day19-code\\src\\com\\bingai\\day19\\demo01\\File\\111\\222\\333");
        System.out.println(file3.delete());
        new File("day19-code\\src\\com\\bingai\\day19\\demo01\\File\\111\\222").delete();
        new File("day19-code\\src\\com\\bingai\\day19\\demo01\\File\\111").delete();


    }

    private static void show02(){
        /*
            public boolean mkdir() ：创建单级空文件夹
            public boolean mkdirs() ：既可以创建单级空文件夹或者或者多级文件夹
            创建文件的路径和名称在构造方法中给出（构造方法的参数）
            返回值：布尔值
                true：文件夹不存在，创建文件夹
                false：文件夹存在，不会创建，返回；构造方法中给出的路径不存在，返回false
             注意：
                 此方法只能创建文件夹，不能创建文件

         */
        File file1 = new File("day19-code\\src\\com\\bingai\\day19\\demo01\\File\\AAA");
        boolean mkdir = file1.mkdir();
        System.out.println(mkdir);//true，第二次false，已存在

        File file2 = new File("day19-code\\src\\com\\bingai\\day19\\demo01\\File\\111\\222\\333");
        boolean mkdirs = file2.mkdirs();//
        System.out.println(mkdirs);//true，第二次false，已存在

        File file3 = new File("day19-code\\src\\com\\bingai\\day19\\demo01\\File\\111.txt");
        boolean mkdir3 = file3.mkdirs();//
        System.out.println(mkdir3);//看类型，111.txt是一个文件夹

        File file4 = new File("day19-code\\src\\com\\bingai\\day19\\demo01\\Fil");
        boolean mkdir4 = file4.mkdirs();//
        System.out.println(mkdir4);//false，路径不存在不会创建

    }






}
