package cn.bingai.practice01.demo02.chapter09_constantClass;

import java.util.Scanner;

/**
 * 请编写一个 Application 实现如下功能：
 * 接受命令行中给出的一个字母串，先将该串原样输出，
 * 然后判断该串的第一个字母是否为大写，
 * 若是大写则统计该串中大写字母的个数，并将所有大写字母输出；
 * 否则输出信息串”第一个字母不是大写字母!”。
 *
 * @author bingai
 * @create 2019-11-03 10:59
 */
public class Test07 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String str = sc.next();
        sc.close();

        if (str.charAt(0) >= 'A' && str.charAt(0) <= 'Z') {
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                    System.out.println(str.charAt(i));
                }
            }
        }else{
            System.out.println("输入的字符串中第一个字母不是大写字母！");
        }

    }
}
