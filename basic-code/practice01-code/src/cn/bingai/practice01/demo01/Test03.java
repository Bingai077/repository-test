package cn.bingai.practice01.demo01;

/*
题目：打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，
其各位数字立方和等于该数本身。

例如：153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。

程序分析：利用for循环控制100-999个数，每个数分解出个位，十位，百位。

 */
public class Test03 {
    public static void main(String[] args) {

//        解法一：
//        int a;//个位
//        int b;//十位
//        int c;//百位
//        System.out.println("“水仙花数”为：");
//        for (int i = 100; i < 1000; i++) {
//            a = i % 10;
//            b = (i % 100 - a) / 10;
//            c = (i - b * 10 - a) / 100;
//            if (i == a * a * a + b * b * b + c * c * c) {
//                System.out.println(i);
//            }
//
//        }


//         解法二：
        int count = 0;
        System.out.println("“水仙花数”为：");
        for (int i = 100; i < 1000; i++) {
            int a = i % 10;
            int b = i / 10 % 10;
            int c = i / 100;
            if (i == (a * a * a + b * b * b + c * c * c)) {
                System.out.println(i);
                count++;
            }
        }
        System.out.println("“水仙花数”的个数为：" + count);


    }

}
