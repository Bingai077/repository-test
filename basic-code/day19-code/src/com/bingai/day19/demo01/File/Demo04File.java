package com.bingai.day19.demo01.File;

import java.io.File;

/*
  File判断功能的方法：
    public boolean exists() ：此File表示的文件或目录是否实际存在。
    public boolean isDirectory() ：此File表示的是否为目录。
    public boolean isFile() ：此File表示的是否为文件
 */
public class Demo04File {
    public static void main(String[] args) {
        show01();
        System.out.println("===========");
        show02();

    }

    private static void show02(){
    /*
        public boolean isDirectory() ：此File表示的是否为目录。
        用于判断构造方法中给定的路径是否以文件夹结尾
            是：true
            否：false
        注意：
            电脑的硬盘中只有文件/文件夹，两个方法是互斥的
            这两个方法使用前提是：路径必须是存在的，否则都返回false

     */
        File file1 = new File("D:\\IdeaProjects\\basic-code\\day19-code\\src\\com\\bingai\\day19\\demo01\\File");

        //不存在就没有必要获取
        if(file1.exists()){
            System.out.println(file1.isDirectory());//true
            System.out.println(file1.isFile());//false
        }
        System.out.println("======");
        File file2 = new File("D:\\IdeaProjects\\basic-code\\day19-code\\src\\com\\bingai\\day19\\demo01\\Fil");
        if(file2.exists()){
            System.out.println(file2.isDirectory());//false
        }

        System.out.println("=====");
        File file3 = new File("D:\\IdeaProjects\\basic-code\\day19-code\\src\\com\\bingai\\day19\\demo01\\File\\1.jpg");
        if(file3.exists()){
            System.out.println(file3.isDirectory());//false
            System.out.println(file3.isFile());//true
        }



    }



    private static void show01(){
        /*
            public boolean exists() ：此File表示的文件或目录是否实际存在。
            用于判断构造方法中的路径是否存在
                存在：true
                不存在：false
         */
        File file1 = new File("D:\\IdeaProjects\\basic-code\\day19-code\\src\\com\\bingai\\day19\\demo01\\File");
        System.out.println(file1.exists());//true
        File file2 = new File("D:\\IdeaProjects\\basic-code\\day19-code\\src\\com\\bingai\\day19\\demo01\\Fil");
        System.out.println(file2.exists());//false
        File file3 = new File("1.jpg");//
        System.out.println(file3.exists());//false，没在根路径



    }
}
