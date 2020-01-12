package cn.bingai.practice01.demo02.chapter04_OOP1.test4;

import java.io.PrintStream;

public class Demo {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        method2(a, b);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    //法一：
    public static void method1(int a, int b) {
        a = a * 10;
        b = b * 20;
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        System.exit(0);
    }

    //法二：
    public static void method2(int a, int b) {
        PrintStream ps = new PrintStream(System.out) {
            @Override
            public void println(String x) {
                if ("a = 10".equals(x)) {
                    x = "a = 100";
                } else if("b = 10".equals(x)){
                    x = "b = 200";
                }
                super.println(x);
            }
        };
        System.setOut(ps);


    }

}
