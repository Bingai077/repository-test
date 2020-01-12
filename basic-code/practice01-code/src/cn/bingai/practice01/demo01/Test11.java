package cn.bingai.practice01.demo01;

/*
题目：有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？

程序分析：可填在百位、十位、个位的数字都是1、2、3、4。这里要用3个for循环

用if判断条件是否符合，符合条件的数字打印出来,并计算个数总和

 */
public class Test11 {

    public static void main(String[] args) {

        System.out.println("组成的三位数分别是：");
        int count = 0;
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                for (int k = 1; k <= 4; k++) {
                    if (i != j && i != k && j != k) {
                        count++;
                        System.out.print(100 * i + 10 * j + k+" ");
                    }
//                    if(count % 12 == 0) {
//                        System.out.println();
//                    }

                }
            }
        }

        System.out.println("                        ");
        System.out.print("组成的三位数的个数为：" + count);
    }
}
