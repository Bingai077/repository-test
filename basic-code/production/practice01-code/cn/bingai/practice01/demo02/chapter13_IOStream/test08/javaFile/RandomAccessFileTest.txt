package cn.bingai.practice01.demo02.chapter13_IOStream.test04_ObjectStream;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 RandomAccessFile的使用
 1.RandomAccessFile直接继承于java.lang.Object类，实现了DataInput和DataOutput接口
 2.RandomAccessFile既可以作为一个输入流，又可以作为一个输出流

 3.如果RandomAccessFile作为输出流时，
    如果写出到的文件不存在，则在执行过程中自动创建
    如果写出到的文件存在，则会对原有文件进行覆盖，默认情况下从头覆盖

 4.可以通过相关操作，实现RandomAccessFile“插入”效果

 * @author bingai
 * @create 2019-11-10 10:13
 */
public class RandomAccessFileTest {

    @Test
    public void test1()  {

        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test04_ObjectStream\\1.jpg"),"r");
            raf2 = new RandomAccessFile(new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test04_ObjectStream\\2.jpg"),"rw");

            byte[] by = new byte[1024];
            int len;
            while((len = raf1.read(by)) != -1){
                raf2.write(by,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(raf1 != null){
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(raf1 != null){

                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void test2() throws IOException {

        RandomAccessFile raf = new RandomAccessFile(new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test04_ObjectStream\\hello.txt"), "rw");

        raf.seek(3);//将指针调到角标为3的位置
        raf.write("xyz".getBytes());//覆盖数据

        raf.close();
    }

    /*
        使用RandomAccessFile实现数据的插入效果

     */
    @Test
    public void test3() throws IOException {

        String strPath = "D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test04_ObjectStream\\hello.txt";
        File file = new File(strPath);
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.seek(3);//将指针调到角标为3的位置

        //保存指针3后面所有的数据到StringBuilder中
        StringBuilder builder = new StringBuilder((int)file.length());
        byte[] by = new byte[1024];
        int len;
        while((len = raf.read(by)) != -1){
            builder.append(new String(by,0,len));
        }

        //调回指针，写入"xyz"
        raf.seek(3);
        raf.write("xyz".getBytes());
        raf.write(builder.toString().getBytes());

        raf.close();

        //思考：将StringBuilder替换为ByteArrayOutputStream


    }


}
