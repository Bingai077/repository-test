package cn.bingai.practice01.demo02.chapter13_IOStream.test04_ObjectStream;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author bingai
 * @create 2019-11-11 15:51
 */
public class FileUtilsTest {

    public static void main(String[] args) {

        File srcFile = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test04_ObjectStream\\1.jpg");
        File destFile = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test04_ObjectStream\\1-1.jpg");

        try {
            FileUtils.copyFile(srcFile,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
