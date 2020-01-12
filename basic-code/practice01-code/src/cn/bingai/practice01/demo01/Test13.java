package cn.bingai.practice01.demo01;

import static java.lang.StrictMath.sqrt;

/*
题目：一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？

程序分析：在10万以内判断，
用for循环判断：先将该数加上100后再开方，再将该数加上268后再开方，
如果开方后的结果再平方后分别和i+100,i+268相等，即是结果。

 */
public class Test13 {
    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            if (sqrt((i + 100)) % 1 == 0 && sqrt((i + 268 )) % 1 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println("        ");

        //方法二：
        for (int i = 0; i < 10000; i++) {
            int num1 = (int) Math.sqrt(i + 100);//开方，值已固定了
            int num2 = (int) Math.sqrt(i + 268);
            if ((num1 * num1 == (i + 100)) && (num2 * num2 == (i + 268))) {//符合条件的打印出来
                System.out.print(i + " ");
            }
        }

    }


}
