package cn.bingai.practice01.demo01;

import java.util.ArrayList;
import java.util.Scanner;

/*
题目：有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，问最后留下的是原来第几号的那位。
关键问题是怎么移除》？:布尔值确定，如果被选中被赋值为false

从第一个人开始判断，如果他在圈内，那么报数，再判断他报的数是否是3，如果是的话移出圈外
接着判断下一个人，是否到了最末，如果是的话，从零开始不断循环，直到最后剩下1个人


 */
public class Test37pro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入人数：");
        int n = sc.nextInt();
        sc.close();

        //定义一个数组，标识某人是否在圈内
        boolean[] isIn = new boolean[n];
        for (int i = 0; i < isIn.length; i++) {
            isIn[i] = true;
        }

        int inCount = n;//定义圈内人数
        int countNum = 0;//定义报数
        int index = 0;//定义索引
        while (inCount > 1) {//最后一个人时，退出循环
            if (isIn[index]) {//判断下一个人是否在圈内
                countNum++;//在的话报数
                if (countNum == 3) {//报到数字3
                    isIn[index] = false;//让他出圈
                    countNum = 0;//报数清零，下一个从零开始
                    inCount--;//圈内人数减一
                }
            }
            index++;//索引号一直往后加
            if (index == n) {//索引到最后时，再从头开始
                index = 0;
            }
        }

        for (int i = 0; i < isIn.length; i++) {
            if (isIn[i] == true) {
                System.out.println("最终留下的是：第" + (i + 1) + "号");//留下的为（索引+1）号
            }
        }


        //方法二：

        System.out.println("========================");
        final int M = 3;
        int s = 0;
        for (int i = 2; i <= n; i++) {
            s = (s + M) % i;
        }
        System.out.println("最终留下的是：第" + (s + 1) + "号");

        /*

        此题可用数学方法求解——递归。


设有n个人（编号0~(n-1)），从0开始报数，报到(m-1)的退出，剩下的人继续从0开始报数  （用数学方法解的时候需要注意应当从0开始编号，因为取余会取到0解。）

实质是一个递推，n个人中最终留下来的序号与n-1个人中留下来的人的序号有一个递推关系式。

假设除去第k个人，则

0, 1, 2, 3, ..., k-2, k-1, k, ..., n-1　         // 原始序列　(1)

0, 1, 2, 3, ..., k-2,      , k, ..., n-1　　      // 除去第k人，即除去序号为k-1的人   (2)

k, k+1, ..., n-1,    0,    1,        ..., k-2　　// 以序号k为起始，从k开始报0  (3)

0, 1,     ..., n-k-1, n-k, n-k+1, ..., n-2　  // 作编号转换，此时队列为n-1人　 (4)

变换后就完完全全成为了(n-1)个人报数的子问题，注意(1)式和(4)式，是同一个问题，不同的仅仅是人数。比较(4)和(3)，不难看出，0+k=k, 1+k=k+1, ... ，(3)式中'0'后面的数字，（(n-3)+k）%n=k-3,（(n-2)+k）%n=k-2, 对于(3)式中'0'前面的数字，由于比n小，也可看作(0+k)%n=k,  (1+k)%n=k+1,  故可得出规律：

设(3)中某一数为x' , (4)中对应的数为x，则有：x'=(x+k)%n.

设x为最终留下的人序号时，队列只剩下1人时，显然x=0; 此时可向前回溯至2人时x对应的序号，3人时x对应的序号……直至n人时x的序号，即为所求。


         */







    }


}
