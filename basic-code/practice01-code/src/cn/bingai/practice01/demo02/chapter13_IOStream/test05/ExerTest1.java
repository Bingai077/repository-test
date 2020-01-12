package cn.bingai.practice01.demo02.chapter13_IOStream.test05;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author bingai
 * @create 2019-11-12 8:58
 */
public class ExerTest1 {

    /*
        利用File构造器， new 一个文件目录file
            1)在其中创建多个文件和目录
            2)编写方法，实现删除file中指定文件的操作

     */

    @Test
    public void test()  {

        File file = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test05\\test1");
        File file1 = new File(file.getParent(), "test1.txt");

        boolean newFile = false;
        try {
            newFile = file1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(newFile){
            System.out.println("创建成功");
        }
        file.delete();
        System.out.println("删除成功");

    }
}
