package com.bingai.day19.demo02.Recursion;

import java.io.File;

/*
    文件搜索，只要.java结尾的文件

    D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\demo01\File\Demo01File.java
D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\demo01\File\Demo02Flie.java
D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\demo01\File\Demo03File.java
D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\demo01\File\Demo04File.java
D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\demo01\File\Demo05File.java
D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\demo01\File\Demo06File.java
D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\Demo02\Recursion\Demo01Recursion.java
D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\Demo02\Recursion\Demo02Recursion.java
D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\Demo02\Recursion\Demo03Recursion.java
D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\Demo02\Recursion\Demo04Recursion.java
D:\IdeaProjects\basic-code\day19-code\src\com\bingai\day19\Demo02\Recursion\Demo05Recursion.java

 */
public class Demo05Recursion {
    public static void main(String[] args) {
        File file = new File("D:\\IdeaProjects\\basic-code\\day19-code\\src\\com\\bingai\\day19");
        getAllFile(file);
    }
    /*
        定义一个方法，参数传递File类型的目录
        方法中对目录进行遍历
     */
    private static void getAllFile(File dir){
        //System.out.println(dir);//打印被遍历的目录名称
        File[] files = dir.listFiles();
        for (File file : files){
            //对遍历得到的File对象file进行判断，判断是否是文件夹
            if(file.isDirectory()){//使用isDirectory方法
                getAllFile(file);
            }else{
                //file是一个文件直接打印即可
                /*
                    只要.java结尾的文件
                    1.把File对象file转换为字符串对象
                 */

                //String fileName = file.getName();
                //String filePath = file.getPath();
                //String string = file.toString();
//                String fileName = file.getName();

                //把字符串转换为小写
//                fileName = fileName.toLowerCase();

                //2.调用String类中的方法endsWith判断字符串是否以.java结尾
//                if(fileName.endsWith(".java")){
//                    //3.如果是以.java结尾的文件，则输出
//                    System.out.println(file);
//                }
                if(file.getName().toLowerCase().endsWith(".java")){
                    System.out.println(file);
                }


            }

        }

    }
}
