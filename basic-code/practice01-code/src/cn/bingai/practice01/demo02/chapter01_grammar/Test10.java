package cn.bingai.practice01.demo02.chapter01_grammar;

import java.util.Arrays;
import java.util.Scanner;

/*
实现输入字符的加密和解密

【关键技术】：异或运算
如果某个字符或者数值x与一个数组m进行异或运算得到y，
那么再用y与m进行异或运算就可以还原为x。

 */
public class Test10 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入英文字符串：");//chenbinjie
        String password = sc.nextLine();
        sc.close();

        char[] array = password.toCharArray();
        for (int i = 0; i < array.length; i++) {
            array[i] = (char)(array[i] ^ 20000);
        }
        System.out.println("加密结果为：" + Arrays.toString(array));//加密结果为：[乃, 么, 久, 乎, 乂, 义, 乎, 乊, 义, 久]
    }

}
