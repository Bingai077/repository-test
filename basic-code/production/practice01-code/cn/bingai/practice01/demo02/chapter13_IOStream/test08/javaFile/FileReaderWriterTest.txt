package cn.bingai.practice01.demo02.chapter13_IOStream.test02_IOStream;

import org.junit.Test;

import java.io.*;

/**
 * 一、流的分类：
 * 1.操作数据单位：字节流（InputStream、OutputStream）、字符流（Reader、Writer）
 * 2.数据流向：输入流（InputStream、Reader）、输出流（OutputStream、Writer）
 * 3.流的角色：节点流（FileInputStream、FileOutputStream、FileReader、FileWriter）、
 * 处理流(BufferedInputStream、BufferedOutputStream、BufferedReader、BufferedWriter)
 * <p>
 * 二、流的体系结构：
 * 抽象基类           节点流（或文件流）                               缓冲流（处理流的一种）
 * InputStream       FileInputStream (read (byte[] by))             BufferedInputStream (read (byte[] by))
 * OutputStream      FileOutputStream (write (byte[] by,0,len))     BufferedOutputStream (write (byte[] by,0,len)/flush())
 * Reader            FileReader (read (char[] ch))                  BufferedReader (read (char[] ch)/readLine())
 * Writer            FileWriter (write (char[] ch,0,len))           BufferedWriter (write (char[] ch,0,len)/flush())
 *
 * @author bingai
 * @create 2019-11-08 23:05
 */
public class FileReaderWriterTest {

    @Test
    public void testFileReader() {

        /*
            将hello.txt文件内容读入程序，并输出到控制台

            说明点：
            1.read()的理解：返回读入的一个字符，如果到达文件末尾，返回-1
            2.异常的处理：为了保证流资源一定可以执行关闭操作，需要使用try-catch-finally处理
            3.读入的文件一定要存在，否则就会报FileNotFoundException
         */
        FileReader fr = null;
        try {
            //1.实例化file类的对象，指明要操作的文件
            File file = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test02_IOStream\\hello.txt");
            //2.提供具体的流，
            fr = new FileReader(file);

            //3.数据的读入
            //read():返回读入的一个字符。如果到达文件末尾，返回-1
//        int data = fr.read();
//        while(data != -1){
//            System.out.print((char)data);
//            data = fr.read();
//        }

            //【优化】:语法上的改进
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭操作
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            //或者
//            if (fr != null) {
//                try {
//                    fr.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }

        }

    }

    //对read()方法的操作升级：使用read重载方法
    @Test
    public void testFileReader1() {
        FileReader fr = null;
        try {
            //1.File实例化
            File file = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test02_IOStream\\hello.txt");
            //2.FileReader流的实例化
            fr = new FileReader(file);

            //3.读入操作
            //read(char[[] ch):返回每次读入ch数组中的字符的个数。如果达到文件末尾，返回-1。
            char[] ch = new char[1024];
            int len;
            while ((len = fr.read(ch)) != -1) {
                //方式一：
//               for (int i = 0; i < len; i++) {
//                    System.out.print(ch[i]);
//                }
                //方式二：
                System.out.print(new String(ch, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源的关闭
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    /*数据的写出数据到硬盘的文件中

      说明：
      1.输出操作，对应的File可以不存在。并不会报异常
      2.File对应的硬盘中的文件：
          如果不存在，在输出的过程中。会自动创建此文件。
          如果存在：
                  如果流使用的构造器是：FileWriter(file,false)/FileWriter(file)：对原有文件的覆盖
                  如果流使用的构造器是：FileWriter(file,true)：不会覆盖原文件，而是在原有文件基础上追加内容

    */
    @Test
    public void testFileWriter() {
        FileWriter fw = null;
        try {
            //1.提供File类的对象，指明写出到的文件
            File file = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test02_IOStream\\hello1.txt");

            //2.提供FileWriter对象，用于数据的写出
            fw = new FileWriter(file);

            //3.写出操作
            fw.write("I have a dream!\n");

            fw.write("You need to have a dream!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流
            try {
                fw.close();
            } catch (IOException e) {

            }
        }


    }


    //文件复制
    @Test
    public void testFileReaderFileWriter() {
        //1.创建File类对象，指明读入和写出的文件
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File srcFile = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test02_IOStream\\hello.txt");
            File destFile = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test02_IOStream\\hello2.txt");
            //
//            File srcFile = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test02_IOStream\\1.jpg");
//            File destFile = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test02_IOStream\\2.jpg");

            //2.创建输入流和输出流的对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            //3.数据的读入和写出操作
            char[] ch = new char[1024];
            int len;
            while ((len = fr.read(ch)) != -1) {
                fw.write(ch, 0, len);//【特别注意】
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            //方式一：
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if  (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //方式二：
//            try {
//                if (fw != null)
//                    fw.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }finally {
//                try {
//                    if (fr != null)
//                        fr.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }

        }


    }

//文件复制
    @Test
    public void testCopyPicture() {
        //1.创建File类对象，指明读入和写出的文件
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test02_IOStream\\1.jpg");
            File destFile = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test02_IOStream\\2.jpg");

            //2.创建输入流和输出流的对象
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //3.数据的读入和写出操作
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                //fos.write(new String(bytes,0,len));//错误写法
                fos.write(bytes,0,len);//【特别注意】
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            //方式一：
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if  (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }


    }

}
