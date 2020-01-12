package cn.bingai.practice01.demo02.chapter13_IOStream.test09;

import java.io.*;
import java.util.HashMap;

/**
 * @author bingai
 * @create 2019-11-12 22:17
 */
public class Test2 {

    /*
       请将文本信息恢复顺序。
     */
    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test09\\1.txt"));
            bw = new BufferedWriter(new FileWriter("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test09\\1-1.txt"));

            String str;
            while((str = br.readLine()) != null){
                String[] split = str.split("\\.");
                map.put(split[0],split[1]);
            }

            for (int i = 1; i < map.size(); i++) {
                String key = String.valueOf(i);
                String value = map.get(key);
                bw.write(key + "." + value);
                bw.newLine();
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
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}