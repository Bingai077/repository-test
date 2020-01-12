package com.bingai.day19.demo01.File;

import java.io.File;

/*
File获取功能的方法：
    public String getAbsolutePath() ：返回此File的绝对路径名字
    public String getPath() ：将此File转换为路径名字符串。
    public String getName() ：返回由此File表示的文件或目录的名
    public long length() ：返回由此File表示的文件的长度

 */
public class Demo03File {
    public static void main(String[] args) {
        show01();
        System.out.println("=========");
        show02();
        System.out.println("=========");
        show03();
        System.out.println("=========");
        show04();

    }
    private static void show04(){
        /*
              public long length() ：返回由此File表示的文件的长度
              获取的是构造方法指向文件的大小，以字节为单位
              注意：
                    1.文件夹是没有大小概念的，不能获取文件夹的大小
                    2.如果构造方法中给出的路径不存在，那么length返回0
         */
        File file = new File("D:\\IdeaProjects\\basic-code\\day19-code\\src\\com\\bingai\\day19\\demo01\\File\\1.jpg");
        System.out.println(file.length());//480742字节
        File file1 = new File("D:\\IdeaProjects\\basic-code\\day19-code\\src\\com\\bingai\\day19\\demo01\\File\\a.txt");
        System.out.println(file1.length());//0
        File file2 = new File("D:\\IdeaProjects\\basic-code\\day19-code\\src\\com\\bingai\\day19\\demo01\\File");
        System.out.println(file1.length());//0,文件夹没有大小概念
    }


    private static void show03(){
        /*
         public String getName() ：返回由此File表示的文件或目录的名
         获取构造方法传递路径的结尾部分（文件/文件夹）
         */
        File file = new File("D:\\IdeaProjects\\basic-code\\day19-code\\src\\com\\bingai\\day19\\demo01\\File\\a.txt");
        System.out.println(file.getName());//a.txt
        File file1 = new File("D:\\IdeaProjects\\basic-code\\day19-code\\src\\com\\bingai\\day19\\demo01\\File");
        System.out.println(file1.getName());


    }


    private static void show02(){
        /*
            public String getPath() ：将此File转换为路径名字符串。
            获取构造方法中传递的路径
            toString()方法调用的就是getPath()方法
            源码：
                public String toString() {
                    return getPath();
                }

         */
        File file = new File("D:\\IdeaProjects\\basic-code\\day19-code\\src\\com\\bingai\\day19\\demo01\\File\\a.txt");
        File file1 = new File("a.txt");
        System.out.println(file.getPath());//D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\demo01\File\a.txt
        System.out.println(file1.getPath());//a.txt
        System.out.println(file.toString());//D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\demo01\File\a.txt

    }

    private static void show01(){
        /*
            public String getAbsolutePath() ：返回此File的绝对路径名字
            获取构造方法中传递的路径
            无论路径是绝对的还是相对的，getAbsolutePath()方法都是返回绝对路径
         */
        File file = new File("D:\\IdeaProjects\\basic-code\\day19-code\\src\\com\\bingai\\day19\\demo01\\File\\a.txt");
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);//D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\demo01\File\a.txt

        File file1 = new File("a.txt");
        System.out.println(file1.getAbsolutePath());//D:\IdeaProjects\basic-code\a.txt,当前项目根目录
    }
}
