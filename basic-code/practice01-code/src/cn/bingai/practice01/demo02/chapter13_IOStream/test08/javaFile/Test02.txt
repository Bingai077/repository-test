package cn.bingai.practice01.demo02.chapter13_IOStream.test08;

import org.junit.Test;

import java.io.*;
import java.util.HashSet;

/**
 * @author bingai
 * @create 2019-11-12 15:03
 */
public class Test02 {
    /*
        1)	利用java代码在D盘下创建一个mytemp文件夹
        2)	显示D盘下所有的.Java文件，包括D盘的子文件夹下的.java文件
        3)	把上述显示的文件都复制到mytemp文件夹中

     */
    @Test
    public void Test() {

        File srcFile = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream");
        File destFile = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test08\\javaFile");

        if (!destFile.exists()) {
            destFile.mkdirs();
        }

        printAndCopyDirection(srcFile, destFile);

    }

    private void printAndCopyDirection(File srcFile, File destFile) {

        HashSet<String> javaPathSet = new HashSet<>();
        HashSet<String> allJavaFiles = printAllJavaFiles(srcFile, javaPathSet);
        System.out.println("该文件夹下所有的java文件为：");
        for (String file : allJavaFiles) {
            String[] split = file.split("=");
            String srcFile1 = file.split("=")[0];
            String fileName = file.split("=")[1];
            //System.out.println(srcFile1);
            System.out.println(fileName);

            copyAllJavaFile(srcFile1, destFile, fileName);
        }

        System.out.println("复制所有java文件成功！");

    }

    //复制文件（写入写出）
    private void copyAllJavaFile(String srcFile, File destFile, String fileName) {

        BufferedReader br = null;
        BufferedWriter bw = null;
        try {

            br = new BufferedReader(new FileReader(new File(srcFile)));
            bw = new BufferedWriter(new FileWriter(new File(destFile, fileName.replace(".java",".txt"))));

            String str;
            while((str = br.readLine()) != null){
                bw.write(str);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




    }

    //java【文件路径】放入集合
    private HashSet<String> printAllJavaFiles(File srcFile, HashSet<String> fileSet) {

        if (srcFile.isFile()) {
            if (srcFile.getName().endsWith(".java")) {
                fileSet.add(srcFile.getAbsolutePath() + "=" + srcFile.getName());
            }
        } else {
            File[] files = srcFile.listFiles();
            for (File file : files) {
                printAllJavaFiles(file, fileSet);
            }
        }
        return fileSet;

    }


}
