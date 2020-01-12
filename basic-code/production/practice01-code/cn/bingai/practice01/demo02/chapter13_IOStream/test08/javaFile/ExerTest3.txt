package cn.bingai.practice01.demo02.chapter13_IOStream.test06;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author bingai
 * @create 2019-11-12 11:16
 */
public class ExerTest3 {
    /*
         获取文本上每个字符出现的次数
        提示：遍历文本的每一个字符；字符及出现的次数保存在Map中；将Map中数据写入文件
     */
    @Test
    public void test() {

        Map<Character, Integer> map = new HashMap<>();

        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test06\\1.txt"));

            int c;
            while ((c = br.read()) != -1) {
                char c1 = (char) c;
                if (map.get(c1) == null) {
                    map.put(c1, 1);
                } else {
                    map.put(c1, map.get(c1) + 1);
                }

            }

//        System.out.println(map);

            //写入文件
            bw = new BufferedWriter(new FileWriter("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test06\\1-WordCount.txt"));
            Set<Character> keySet = map.keySet();
            for (Character ch : keySet) {
                switch (ch) {
                    case '\n':
                        bw.write("换行=" + map.get(ch));
                        break;
                    case '\r':
                        bw.write("回车=" + map.get(ch));
                        break;
                    case '\t':
                        bw.write("tab键=" + map.get(ch));
                        break;
                    case ' ':
                        bw.write("空格=" + map.get(ch));
                        break;
                    default:
                        bw.write(ch + "=" + map.get(ch));
                        break;
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}


