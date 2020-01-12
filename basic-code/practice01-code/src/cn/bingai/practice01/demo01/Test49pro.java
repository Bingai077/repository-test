package cn.bingai.practice01.demo01;

import java.util.Scanner;

/*
题目：计算字符串中子串出现的次数

程序分析：
把string类型的字符串的每个元素，转换为char数组里面的每个数组的值string.toCharArray()
判断char数组中是否存在空格，存在的话子字符串数量加1
 */
public class Test49pro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = sc.next();
        System.out.println("请输入子串：");
        String str1 = sc.next();

        int count = 0;
        //跳不出
//        for (int i = 0; i < str.length(); i++) {
//            if(str.indexOf(str1) > -1){
//                count++;
//                i = str.indexOf(str1,i)+str1.length();
//            }
//        }



//        int i = 0;
//        while(str.indexOf(str1) != -1 && i < str.length()){//循环条件
//        while (str.contains(str1)) {//循环条件
//            str = str.substring(str.indexOf(str1) + str1.length());
//            count++;
////            i = str.indexOf(str1,i)+str1.length();
//        }
//
//        System.out.println("字符串中子串出现的次数为：" + count);


        //方法2
        int num = 0;
        for (int i = 0; i < str.length()-str1.length() ; i++) {
            String str2 = str.substring(i,i+str1.length());
            if(str2.equals(str1)){
                num++;
            }
        }
        System.out.println(num);




    }
}
