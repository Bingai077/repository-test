package com.bingai.day19.demo01.File;

import java.io.File;

/*
    java.io.File
    文件和目录路径名的抽象表示
    java把电脑中的文件和文件夹（目录）封装成了一个File类，我们可以使用File类对文件和文件夹进行操作
    我们可以使用File类的方法
        创建一个文件/文件夹
        删除文件/文件夹
        获取文件/文件夹
        判断文件/文件夹是否存在
        对文件进行遍历
        获取文件的大小
      File是一个与系统无关的类，任何操作系统都可以使用这个类中的方法

      重点：记住这三个单词
           file：文件
           directory：文件夹
           path：路径

 */
public class Demo01File {
    public static void main(String[] args) {
        /*
            static String pathSeparator 与系统有关的路径分隔符，为了方便，它被表示为一个字符串。
            static char pathSeparatorChar 与系统有关的路径分隔符。
            static String separator 与系统有关的默认名称分隔符，为了方便，它被表示为一个字符串。
            static char separatorChar 与系统有关的默认名称分隔符。

            操作路径：路径不能写死了
            D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\demo01\file\Demo01File.java  Windom
            "D:" + File.separator + "IdeaProjects" + File.separator + "basic-code" + File.separator +"day19-code" + File.separator +"src" + File.separator +"com" + File.separator +"bingai" + File.separator +"day19" + File.separator +"demo01" + File.separator +"file" + File.separator +"Demo01File.java  Linux

             \ 用  File.separator 代替
            "D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\demo01\file\Demo01File.java"  Windom

         */
        String pathSeparator = File.pathSeparator;
        System.out.println(pathSeparator);// 路径分隔符 windom ;  Linux :
        System.out.println(File.separator);//文件名称分隔符 window \   Linux /



    }

}
