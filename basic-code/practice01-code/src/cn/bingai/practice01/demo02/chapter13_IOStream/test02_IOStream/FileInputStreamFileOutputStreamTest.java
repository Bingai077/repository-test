package cn.bingai.practice01.demo02.chapter13_IOStream.test02_IOStream;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 测试FileInputStream和FileOutputStream的使用
 * <p>
 * 结论：
 * 1.对于文本文件，使用字符流处理，如（.txt/.java/.c/.cpp）
 * 2.对于非文本文件，使用字节流处理，如（.jpg/.mp3/.avi/.doc/.ppt）
 *
 *
 *
 * @author bingai
 * @create 2019-11-09 10:21
 */
public class FileInputStreamFileOutputStreamTest {

    //使用字节流FileInputStream处理文本文件，可能出现乱码
    @Test
    public void testFileInputStream() {
        FileInputStream fis = null;
        try {
            //1.造文件
            File file = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test02_IOStream\\hello.txt");

            //2.造流
            fis = new FileInputStream(file);

            //3.读数据
            byte[] by = new byte[1024];
            int len;
            while ((len = fis.read(by)) != -1) {
                System.out.print(new String(by, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关流
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //图片的复制（非文本文件）
    @Test
    public void testFileInputOutputStream() {

        File srcFile = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test02_IOStream\\1.jpg");
        File descFile = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test02_IOStream\\11.jpg");

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(descFile);

            byte[] by = new byte[1024];
            int len = 0;
            while ((len = fis.read(by)) != -1) {
                fos.write(by, 0, len);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //指定路径下文件的复制
    public void copyFile(String srcPath, String destPath) {

        File srcFile = new File(srcPath);
        File descFile = new File(destPath);

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(descFile);

            byte[] by = new byte[1024];
            int len = 0;
            while ((len = fis.read(by)) != -1) {
                fos.write(by, 0, len);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testCopyFile() {

        String srcPath = "D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test02_IOStream\\1.jpg";
        String destPath = "D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test02_IOStream\\2.jpg";
        long start = System.currentTimeMillis();
        copyFile(srcPath, destPath);
        long end = System.currentTimeMillis();
        System.out.println("复制操作花费的时间：" + (end - start) + "毫秒");
    }


}
