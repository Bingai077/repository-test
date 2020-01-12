package cn.bingai.practice01.demo02.chapter07_Exception;
//StringIndexOutOfBoundsException 字符串索引越界异常
public class Test12_StringIndexOutOfBoundsException {
    public static void main(String[] args) {
        String str = "I am Bingai";
        char ch = str.charAt(30);
        System.out.println(ch);
    }
}
