package cn.bingai.practice01.demo02.chapter13_IOStream.test08;

import org.junit.Test;

import java.io.File;
import java.io.IOException;


/**
 * @author bingai
 * @create 2019-11-12 14:38
 */
public class Test01 {

    /*
        列出当前目录下全部java文件的名称列出当前目录下全部java文件的名称

        列出d:\ch9目录下Java源文件的名字及其大小，并删除其中的一个Java源文件？
     */
    @Test
    public void test(){
        File file = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream");
        File file1 = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test08\\Delete.java");
        try {
            file1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        getAllJavaFile(file);
    }

    private void getAllJavaFile(File file) {
        if(file.isFile()){
            if(file.getName().endsWith(".java")){
                System.out.println(file.getName() + "大小为：" + file.length() + "字节");
            }
            if("Delete.java".equalsIgnoreCase(file.getName())){
                file.delete();
            }
        }else{
            File[] files = file.listFiles();
            for (File file1 : files) {
                getAllJavaFile(file1);
            }
        }
    }



    /*
    操作D盘下的my.txt文件
        1)	判断my.txt文件是否存在
        2)	若存在则删除;若不存在则创建
     */

    @Test
    public void test1(){
        File file1 = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test08\\Delete.java");
        if(file1.exists()){
            file1.delete();
        }else{
            try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /*
        使用File类删除某个文件夹（例如D盘下的temp文件夹）下的所有文件和文件夹:
            1）	判断temp文件夹下的文件类型，如果是文件则直接删除
            2）	如果是文件夹则获取该文件夹下的子文件和文件夹
            3）	使用递归的方式删除所有temp文件夹下的文件和文件夹

     */
    @Test
    public void test2(){

        File file = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test08\\1");

        deleteDirectory(file);
    }

    private void deleteDirectory(File file) {
        if(file.isFile()){
            file.delete();
        }else{
            File[] files = file.listFiles();
            for (File file1 : files) {
                deleteDirectory(file1);
            }
        }
        //删除自己
        file.delete();
    }


}
