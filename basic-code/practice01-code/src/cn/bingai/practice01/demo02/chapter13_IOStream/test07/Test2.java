package cn.bingai.practice01.demo02.chapter13_IOStream.test07;

import java.io.*;

/**利用程序复制 test.txt 为 test1.txt
 * @author bingai
 * @create 2019-11-12 12:42
 */
public class Test2 {
    public static void main(String[] args) {

        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test07\\1-test.txt"));
            bw = new BufferedWriter(new FileWriter("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test07\\1-test-copy.txt"));

            char[] chars = new char[1024];
            int len;
            while((len = br.read(chars)) != -1){
                bw.write(chars,0, len);
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

}
