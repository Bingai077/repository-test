package cn.bingai.practice01.demo01;

import java.util.Scanner;

/*
题目：输入一行字符，分别统计出其英文字母、空格、数字和其它字符的个数。

程序分析：
这里的需要的知识点:
1、获取一行字符串，nextLine（）
2、把字符串的每一个字符赋值到一个数值中
3、对比每一个数值在ASK码的范围，就可以确定它符号的类别
4、char字符ASCII码的范围
         （1）数字0到9： 48~57
         （2）字母A到Z：65到90 a到z：97到122
         （3）空格是32 
 */
public class Test07 {
    public static void main(String[] args) {
        System.out.println("请输入一行字符串：");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        method(str);

        sc.close();
    }

    public static void method(String str) {

        char[] chars = str.toCharArray();
        int a = 0;//空格个数
        int b = 0;//数字个数
        int c = 0;//字母个数
        int d = 0;//其他个数

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {//后面写ASCII码32也可以
                a++;
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                b++;
            } else if ((chars[i] >= 'a' && chars[i] <= 'z') || (chars[i] >= 'A' && chars[i] <= 'Z')) {
                c++;
            } else {
                d++;
            }
        }
        System.out.println("英文字母个数为：" + c);
        System.out.println("空格个数为：" + a);
        System.out.println("数字个数为：" + b);
        System.out.println("其他字符个数为：" + d);

    }


}
