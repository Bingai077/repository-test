package cn.bingai.practice01.demo02.chapter01_grammar;

/*
ASCII码：
A ~ Z:  65 ~ 90
a ~ z： 97 ~ 122
0： 48
space（空格）：32

键盘输入字符：char ch = sc.next().charAt(0);//字符串第一个元素即为字符
 */
import java.util.Scanner;

/*
常见字母大小写转换
 */
public class Test06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要转换的字母：");
        char ch = sc.next().charAt(0);//输入字符
        sc.close();

        if(ch >= 'A' && ch <= 'Z'){
            ch += 32;
            System.out.println("转换后的结果是：" + ch);
        }else if(ch >= 'a' && ch <= 'z'){
            ch -= 32;
            System.out.println("转换后的结果是：" + ch);
        }else{
            System.out.println("输入错误，请重新输入！");
        }


    }
}
