package cn.bingai.practice01.demo02.chapter02_flowcontrol;

import java.util.Scanner;

/*
    使用 switch 把小写类型的 char型转为大写。只转换 a, b, c, d, e. 其它的输
出 “other”。
 */
public class Test17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字母：");
        char c = sc.next().charAt(0);
        sc.close();

        switch (c) {
            case 'a':
                System.out.println('A');
                break;
            case 'b':
                System.out.println('B');
                break;
            case 'c':
                System.out.println('C');
                break;
            case 'd':
                System.out.println('D');
                break;
            case 'e':
                System.out.println('E');
                break;
            default:
                System.out.println("other");
                break;

        }


    }

}
