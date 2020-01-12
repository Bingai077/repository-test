package cn.bingai.practice01.demo02.chapter13_IOStream.test07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**利用程序读取 test.txt 文件的内容, 并在控制台打印
 * @author bingai
 * @create 2019-11-12 12:35
 */
public class Test1 {
    public static void main(String[] args) {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test07\\1-test.txt"));
            char[] chars = new char[1024];
            int len;
            while((len = br.read(chars)) != -1){
                System.out.println(new String(chars,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
