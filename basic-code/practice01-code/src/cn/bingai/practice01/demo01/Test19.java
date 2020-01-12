package cn.bingai.practice01.demo01;

/*
题目：打印出如下图案（菱形）

   *

   ***

 ******

********

 ******

  ***

   *

程序分析：先把图形分成两部分来看待，前四行一个规律，后三行一个规律，

利用双重 for循环，第一层控制行，第二层控制列。

详细分析第一部分图形的规律：

1、这是一个等腰三角形，*的打印次数1、3、5、7等差数列

2、还要注意空格打印的 次数3、2、1、0逐渐递减

第二部分同理可得！ 
*/
public class Test19 {

    public static void main(String[] args) {
        //打印上半部分
        for (int i = 1; i <= 7; i = i + 2) {
            for (int j = 7 - i; j > 0; j = j - 2) {//控制星号前空格
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {//控制星号
                System.out.print("*");
            }
            System.out.println();
        }

        //打印下半部分
        for (int i = 1; i <= 5; i = i + 2) {
            for (int j = 1; j <= i ; j=j+2) {//控制星号前空格
                System.out.print(" ");
            }
            for (int j = 5 - i; j >= 0; j--) {//控制星号
                System.out.print("*");
            }
            System.out.println();
        }


    }
}
