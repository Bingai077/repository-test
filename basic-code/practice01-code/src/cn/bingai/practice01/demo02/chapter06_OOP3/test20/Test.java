package cn.bingai.practice01.demo02.chapter06_OOP3.test20;

public class Test {
    static int x, y, z;

    static {
        int x = 5;
        x--;
    }

    static {
        x--;
    }

    public static void main(String[] args) {
        System.out.println("x=" + x);
        z--;//-1
        method();
        System.out.println("result:" + (z + y + ++z));//1+0+2
    }

    public static void method() {
        y = z++ + ++z;//z++:-1  z:0  ++z:1  z:1  y:0
    }


}

