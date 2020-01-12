package cn.bingai.practice01.demo02.chapter03_array;

import java.util.Scanner;

/*
    统计数组中各个字符的个数

    【next()读到空格结束】
 */
public class Test05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一行字符：");
        String str = scanner.nextLine();//next()读到空格结束
        scanner.close();

        char[] chars = str.toCharArray();
        int shuzi = 0;
        int zimu = 0;
        int kongge = 0;
        int hanzi = 0;
        int qita = 0;
        for (char c : chars) {
            if (c >= '0' && c <= '9') {
                shuzi++;
            } else if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                zimu++;
            } else if (c == ' ') {
                kongge++;
            } else if (c >= 19968 && c <= 40869) {//汉字：[0x4e00,0x9fa5]（或十进制[19968,40869]）
                hanzi++;
            } else {
                qita++;
            }
        }

        System.out.println("数字个数为：" + shuzi);
        System.out.println("字母个数为：" + zimu);
        System.out.println("空格个数为：" + kongge);
        System.out.println("汉字个数为：" + hanzi);
        System.out.println("其他字符个数为：" + qita);
    }

    /*
       判断是否为汉字
     */
//    public static boolean hanziCount(char c) {
//
//        byte b = (byte) c;
//        if(b < 0){
//            return true;
//        }
//       return false;
//    }


}


