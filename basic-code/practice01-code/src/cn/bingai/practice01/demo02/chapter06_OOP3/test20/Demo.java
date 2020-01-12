package cn.bingai.practice01.demo02.chapter06_OOP3.test20;

public class Demo {
    public static void main(String args[]) {
        methodA(0);
        System.out.println(j);
    }

    private static int j = 0;

    private static boolean methodB(int k) {
        j += k;
        return true;
    }

    public static void methodA(int i) {//0
        boolean b;
        b = i < 10 | methodB(4);
        b = i < 10 || methodB(8);
    }

}
