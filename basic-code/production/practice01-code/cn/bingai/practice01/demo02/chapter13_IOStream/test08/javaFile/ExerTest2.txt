package cn.bingai.practice01.demo02.chapter13_IOStream.test05;

import org.junit.Test;

import java.io.File;

/**
 * @author bingai
 * @create 2019-11-12 9:03
 */
public class ExerTest2 {

    /*
        判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称

     */
    @Test
    public void test1(){
        File file = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test04_ObjectStream");
        String[] list = file.list();
        for (String fileName : list) {
            if(fileName.endsWith(".java")){
                System.out.println(fileName);
            }
        }

    }

    @Test
    public void test2(){
        File file = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test04_ObjectStream");
        File[] files = file.listFiles();
        for (File file1 : files) {
            if(file1.getName().endsWith(".java")){
                System.out.println(file1.getAbsolutePath());
            }
        }
    }

}
