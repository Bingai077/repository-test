package cn.bingai.practice01.demo02.chapter13_IOStream.test01_file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author bingai
 * @create 2019-11-08 19:47
 */
public class Exer {
    /*
        1. 利用File构造器， new 一个文件目录file
            1)在其中创建多个文件和目录
            2)编写方法，实现删除file中指定文件的操作
        2. 判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
        3. 遍历指定目录所有文件名称，包括子文件目录中的文件。
            拓展1：并计算指定目录占用空间的大小
            拓展2：删除指定文件目录及其下的所有文件
     */
    @Test
    public void test1() throws IOException {
        File file1 = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test01_file\\hello.txt");
        //创建一个与file同目录下的另外一个文件，文件名为：haha.txt
        File destFile = new File(file1.getParent(), "haha.txt");
        boolean newFile = destFile.createNewFile();
        if(newFile){
            System.out.println("创建成功");
        }
        destFile.delete();
    }


}
