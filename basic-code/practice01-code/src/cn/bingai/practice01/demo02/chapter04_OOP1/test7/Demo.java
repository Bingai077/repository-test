package cn.bingai.practice01.demo02.chapter04_OOP1.test7;

/*
1.已知有一个数列： f(0) = 1,f(1) = 4,f(n+2)=2*f(n+1) + f(n),其中n是大于0
的整数，求f(10)的值。

2. 已知一个数列： f(20) = 1,f(21) = 4,f(n+2) = 2*f(n+1)+f(n),
其中n是大于0的整数，求f(10)的值。

3.输入一个数据n，计算斐波那契数列(Fibonacci)的第n个值
1 1 2 3 5 8 13 21 34 55
规律：一个数等于前两个数之和
要求： 计算斐波那契数列(Fibonacci)的第n个值，并将整个数列打印出来
 */
public class Demo {
    public static void main(String[] args) {
        Demo test = new Demo();
        System.out.println(test.f(10));
        System.out.println(test.f1(10));
        System.out.println(test.f2(10));

    }

    public int f(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 4;
        } else {
            //return f(n+2)-2*f(n+1);
            return 2 * f(n - 1) + f(n - 2);
        }
    }

    public int f1(int n) {
        if (n == 20) {
            return 1;
        } else if (n == 21) {
            return 4;
        } else {
            return f1(n + 2) - 2 * f1(n + 1);
        }
    }

    public int f2(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else {
            return f2(n - 1) + f2(n - 2);
        }
    }

}
