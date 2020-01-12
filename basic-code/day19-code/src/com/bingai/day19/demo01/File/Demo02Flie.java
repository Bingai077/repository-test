package com.bingai.day19.demo01.File;

import java.io.File;

/*
    路径：
        绝对路径：是一个完整的路径
           以盘符（C:,D:）开始的路径
           D:\\IdeaProjects\\basic-code
        相对路径：是一个简化的路径
           相对指的是相对于当前项目的根目录（D:\\IdeaProjects\\basic-code）
            如果使用当前项目的根目录，路径可以简化书写
            D:\\IdeaProjects\\basic-code\\day19-code\\src\\com\\bingai\\day19\\demo01\\File\\Demo02File.java
            简化为：Demo02File.java（可以省略项目的根目录）

           注意：
            1.路径不区分大小写
            2.路径中的文件名称分隔符windom使用反斜杠，反斜杠是转义字符，两个反斜杠代替一个普通的反斜杠

 */
public class Demo02Flie {
    public static void main(String[] args) {
        /*
        File类的构造方法：
            public File(String pathname) ：通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例。
            public File(String parent, String child) ：从父路径名字符串和子路径名字符串创建新的 File实例。
            public File(File parent, String child) ：从父抽象路径名和子路径名字符串创建新的 File实例。
         */
        show01();
        System.out.println("======");
        show02("M:\\","a.txt");
        show03();


    }

    private static void show01(){
        /*
            public File(String pathname) ：通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例。
            参数：
                String pathname:字符串的路径名称
                路径可以以文件结尾，也可以以文件夹结尾
                路径可以是相对路径，也可以是绝对路径
                路径可以是存在，也可以是不存在
                创建File对象，只是把字符串路径封装成为File对象，不考虑路径的真假情况
         */
        File f1 = new File("D:\\IdeaProjects\\basic-code\\day19-code\\src\\com\\bingai\\day19\\demo01\\File\\a.txt");
        System.out.println(f1);//重写了Object类中的toString方法 D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\demo01\File\a.txt

        File f2 = new File("D:\\IdeaProjects\\basic-code\\day19-code\\src\\com\\bingai\\day19\\demo01\\File");
        System.out.println(f2);// D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\demo01\File

        File f3 = new File("b.txt");
        System.out.println(f3);//b.txt

    }

    private static void show02(String parent, String child){
        /*
           public File(String parent, String child) ：从父路径名字符串和子路径名字符串创建新的 File实例。
            参数：把路径分成了两部分
                String parent：父路径
                String child：子路径
            好处：
                父路径和子路径，可以单独书写，使用起来非常灵活；父路径和子路径都可以变化
         */
        File file = new File(parent, child);
        System.out.println(file);
    }

    private static void show03(){
        /*
            public File(File parent, String child) ：从父抽象路径名和子路径名字符串创建新的 File实例。
            参数：把路径分成了两部分
                File parent：父路径
                String child：子路径
            好处：
                父路径和子路径，可以单独书写，使用起来非常灵活；父路径和子路径都可以变化
                父路径是File类型，可以使用File的方法对父路径进行一些操作，再使用路径创建对象
         */
        File parent = new File("G:\\");
        File file = new File(parent,"hello.java");
        System.out.println(file);//G:\hello.java



    }

}
