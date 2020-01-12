package cn.bingai.practice01.demo02.chapter02_flowcontrol;
/*
     九九乘法表
     1 * 1 = 1
     2 * 1 = 2  2 * 2 = 4
     3 * 1 = 3
  */
public class Test23 {
    public static void main(String[] args) {
        for (int i = 1; i <= 9 ; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print(j + "*" + i + "=" + j*i + "\t");
            }
            System.out.println();

        }

    }
}
