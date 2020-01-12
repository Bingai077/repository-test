package cn.bingai.practice01.demo02.chapter09_constantClass;

import java.util.Scanner;

/**
 * @author bingai
 * @create 2019-11-03 11:12
 */
public class Test08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String str = sc.next();
        sc.close();

        System.out.println("字符串个数为：" + str.length());
        StringBuffer sb = new StringBuffer(str);
        System.out.println("字符串反序输出为:" + sb.reverse());


    }
}
