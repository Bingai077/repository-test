package cn.bingai.practice01.demo02.chapter02_flowcontrol;

/*
    猴子分桃问题
 */
public class Test13 {
    public static void main(String[] args) {
        int i = fun(0);
        System.out.println("海滩上最少有" + i + "个桃子");
    }

    public static int fun(int n) {
        if (n == 5) {
            return 1;
        } else {
            return 5 * fun(n + 1) + 1;
        }

    }
}
