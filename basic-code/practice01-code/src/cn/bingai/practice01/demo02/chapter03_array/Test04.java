package cn.bingai.practice01.demo02.chapter03_array;

/*
    1,2,3,4能组成多少个互不相同的三位数
 */
public class Test04 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                for (int k = 1; k <= 4; k++) {
                    if (i != j && i != k && j != k) {
                        count++;
                        System.out.print((i * 100 + j * 10 + k) + "\t");
                    }
                }
            }
        }
        System.out.println();
        System.out.println("一共可以组成三位数的个数为：" + count);
    }
}
