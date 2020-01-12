package cn.bingai.practice01.demo02.chapter04_OOP1.test3;

/*
1.编写程序，定义三个重载方法并调用。方法名为mOL。
三个方法分别接收一个int参数、两个int参数、一个字符串参数。分别
执行平方运算并输出结果，相乘并输出结果，输出字符串信息。
在主类的main ()方法中分别用参数区别调用三个方法。
2.定义三个重载方法max()，第一个方法求两个int值中的最大值，第二个方
法求两个double值中的最大值，第三个方法求三个double值中的最大值，
并分别调用三个方法。
 */
public class Demo {
    public static void main(String[] args) {
        Demo test = new Demo();
        test.mOL(3);
        test.mOL(3, 4);
        test.mOL("mOL");

        System.out.println(test.max(3,4));
        System.out.println(test.max(3.3,4.3));
        System.out.println(test.max(3,4,2.0));

    }

    public void mOL(int i) {
        System.out.println(i * i);
    }

    public void mOL(int i, int j) {
        System.out.println(i * j);
    }

    public void mOL(String s) {
        System.out.println(s);
    }

    public int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public double max(double a, double b) {
        return (a > b) ? a : b;
    }

    public double max(double a, double b, double c) {
        double max = (a > b) ? a : b;
        return (max > c) ? max : c;
    }

}
