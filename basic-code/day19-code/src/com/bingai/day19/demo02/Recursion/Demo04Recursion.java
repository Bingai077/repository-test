package com.bingai.day19.demo02.Recursion;

import java.io.File;

/*
    递归打印多级目录
        D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19
    D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\demo01
    D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\demo01\File
    D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\demo01\File\1.jpg
    D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\demo01\File\2.txt
    D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\demo01\File\AAA
    D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\demo01\File\Demo01File.java
    D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\demo01\File\Demo02Flie.java
    D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\demo01\File\Demo03File.java
    D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\demo01\File\Demo04File.java
    D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\demo01\File\Demo05File.java
    D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\demo01\File\Demo06File.java
    D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\Demo02
    D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\Demo02\Recursion
    D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\Demo02\Recursion\Demo01Recursion.java
    D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\Demo02\Recursion\Demo02Recursion.java
    D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\Demo02\Recursion\Demo03Recursion.java
    D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\Demo02\Recursion\Demo04Recursion.java

 */
public class Demo04Recursion {
    public static void main(String[] args) {

        File file = new File("D:\\IdeaProjects\\basic-code\\day19-code\\src\\com\\bingai\\day19");
        getAllFile(file);
    }
    /*
        定义一个方法，参数传递File类型的目录
        方法中对目录进行遍历
     */
    private static void getAllFile(File dir){
        System.out.println(dir);//打印被遍历的目录名称
        File[] files = dir.listFiles();
        for (File file : files){
            //对遍历得到的File对象file进行判断，判断是否是文件夹
            if(file.isDirectory()){//使用isDirectory方法
                //如果file是一个文件夹，则据需遍历这个文件夹
                //getAllFile方法就是传递、遍历文件夹的方法
                //所以直接调用getAllFile方法即可：递归（自己调自己）
                getAllFile(file);
            }else{
                //file是一个文件直接打印即可
                System.out.println(file);
            }

        }

    }

}
