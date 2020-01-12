package cn.bingai.practice01.demo02.chapter01_grammar;
/*
输出计算机支持的最大整数值

【基本数据类型】
【整型】：
byte        1字节  8位有符号     -2^7  ~  2^7-1   -128 ~ 127
short       2字节  16位有符号    -2^15 ~ 2^15-1
int         4字节  32位有符号    -2^31 ~ 2^31-1
long        8字节  64位         -2^63 ~ 2^63-1
【浮点型】：
float       4字节  32位         -3.4e-038 ~ 3.4e+038
double      8字节  64位         -1.7e-308 ~ 1.7e+308
【字符型】:
char        2字节               0 ~ 65535
【布尔型】：
boolean     1字节               true、false

【引用数据类型】
【类】、【数组】、【接口】

 */
public class Test04 {

    public static void main(String[] args) {
        System.out.println("int支持的最大值是：" + Integer.MAX_VALUE);//2147483647
    }
}
