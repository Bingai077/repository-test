package cn.bingai.practice01.demo02.chapter13_IOStream.test09;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author bingai
 * @create 2019-11-12 19:19
 */
public class Test1 {
    /*
        编写一个应用程序，将用户从键盘输入的10个整数存入文件，再顺序读出。

     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入10个整数：");
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();

        FileWriter fw = null;
        FileReader fr = null;
        try {
            fw = new FileWriter("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test09\\1-num.txt");
            fr = new FileReader("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test09\\1-num.txt");

            for (int num : nums) {
                fw.write(num + "\n");
                fw.flush();
            }

            char[] chars = new char[1024];
            int len;
            while ((len = fr.read(chars)) != -1) {
                System.out.println(new String(chars, 0, len));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }

    }
}
