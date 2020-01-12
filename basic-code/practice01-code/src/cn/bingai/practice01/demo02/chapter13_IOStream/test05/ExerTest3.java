package cn.bingai.practice01.demo02.chapter13_IOStream.test05;

import org.junit.Test;

import java.io.File;

/**
 * @author bingai
 * @create 2019-11-12 9:14
 */
public class ExerTest3 {
    /*
        遍历指定目录所有文件名称，包括子文件目录中的文件。
            拓展1：并计算指定目录占用空间的大小
            拓展2：删除指定文件目录及其下的所有文件
     */

    @Test
    public void Test3() {

        File file = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream");
        printSubFile(file);
        System.out.println();
        printAllSubFile(file);
        System.out.println();
        printAllSubFile1(file);

        System.out.println("==================");

        System.out.println("目录的大小为：" + getDirectorySize(file) + "字节");

        File file1 = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test05\\1");
        deleteDirectory(file1);
    }

    //打印文件夹下级内容

    private void printSubFile(File file) {

        if (file.isDirectory()) {
            String[] list = file.list();
            for (String s : list) {
                System.out.println(s);
            }

        } else {
            System.out.println(file + "是文件");
        }
    }

    //打印目录下所有子文件
    private void printAllSubFile(File file) {
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()) {
                printAllSubFile(file1);
            } else {
                System.out.println(file1.getName());
            }
        }

    }

    //打印目录下所有文件方式二
    private void printAllSubFile1(File file) {
        if (file.isFile()) {
            System.out.println(file.getName());
        } else {
            File[] files = file.listFiles();
            for (File file1 : files) {
                printAllSubFile1(file1);
            }
        }
    }

    //获取目录大小
    private long getDirectorySize(File file){
        long size = 0;
        if(file.isFile()){
            size += file.length();
        }else{
            File[] files = file.listFiles();
            for (File file1 : files) {
                size += getDirectorySize(file1);
            }
        }
        return size;
    }

    //删除文件夹
    // 如果file是文件，直接delete
    // 如果file是目录，先把它的下一级干掉，然后删除自己
    private boolean deleteDirectory(File file){

        if(file.isFile()){
            file.delete();
        }else{
            File[] files = file.listFiles();
            for (File file1 : files) {
                deleteDirectory(file1);
            }
        }
        file.delete();
        if(file.exists()){
//            System.out.println("删除失败");
            return false;
        }else {
//            System.out.println("删除成功");
            return true;
        }

    }



}
