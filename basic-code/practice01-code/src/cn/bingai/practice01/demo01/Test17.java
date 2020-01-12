package cn.bingai.practice01.demo01;

/*
题目：猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个第二天早上又将剩下的桃子吃掉一半，
又多吃了一个。以后每天早上都吃了前一天剩下的一半零一个。到第10天早上想再吃时，见只剩下一个桃子了。
求第一天共摘了多少。

程序分析：采取逆向思维的方法，从后往前推断。

天  数       1    2    3     4     5    。。。10

桃子数      1     4    10    22    46          ？

所以桃子数计算方法：前一天桃子数 * 2+2

 */
public class Test17 {

    public static void main(String[] args) {

        int sum = 1;
        for (int i = 2; i <= 10; i++) {
            sum = sum * 2 + 2;
        }
        System.out.println("猴子第一天摘的桃子数：" + sum);

    }

}
