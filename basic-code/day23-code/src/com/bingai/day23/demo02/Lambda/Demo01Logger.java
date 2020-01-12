package com.bingai.day23.demo02.Lambda;

/*
    日志案例

    发现以下代码存在一些性能浪费的问题
    调用showLog方法，传递的第二个参数是一个拼接后的字符串
    先把字符串拼接好，然后再调用showLog方法
    showLog方法如果传递的日志等级不是1级
    那么就不会传递拼接后的字符串
    所以感觉字符串就白拼接了，存在了浪费
 */
public class Demo01Logger {
    //定义一个根据日志的级别，显示日志信息的方法
    public static void showLog(int level, String message) {
        //对日志的等级进行判断，如果是1级别，输出日志的信息
        if (level == 1) {
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        //定义三个日志信息
        String msg1 = "Hello";
        String msg2 = "World";
        String msg3 = "Java";

        //调用showlog方法，传递日志级别和日志信息
        showLog(2, msg1 + msg2 + msg3);
    }

}
