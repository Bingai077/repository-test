package cn.bingai.practice01.demo02.chapter15_Reflection.Test4;

import java.io.File;
import java.io.IOException;

/**
 * @author bingai
 * @create 2019-11-14 9:35
 */
public class Mytxt {

    private String filePath;

    public Mytxt() {
    }

    public Mytxt(String filePath) {
        this.filePath = filePath;
    }

    public boolean createFile(String filePath) throws IOException {
        boolean b = new File(filePath).createNewFile();
        return b;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
