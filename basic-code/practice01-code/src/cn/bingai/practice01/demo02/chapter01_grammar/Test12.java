package cn.bingai.practice01.demo02.chapter01_grammar;
/*
如何求一个0~255范围内的整数的十六进制值，例如60的十六进制表示形式3C
 */
public class Test12 {
    public static void main(String[] args) {
        System.out.println(Integer.toHexString(60));//3c
        System.out.println(Integer.toBinaryString(60));//111100


    }
}
