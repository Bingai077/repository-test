package cn.bingai.practice01.demo02.chapter02_flowcontrol;
/*
编写程序从1循环到150，并在每行打印一个值，另外在每个3的倍数行
上打印出“foo”,在每个5的倍数行上打印“biz”,在每个7的倍数行上打印
输出“baz”。

 */
public class Test20 {
    public static void main(String[] args) {
        for (int i = 1; i <= 150; i++) {
            System.out.print(i);
            if (i % 3 == 0){
                System.out.print(" foo");
            }
            if (i % 5 == 0){
                System.out.print(" biz");
            }
            if (i % 7 == 0){
                System.out.print(" baz");
            }
            System.out.println();

        }
    }
}
