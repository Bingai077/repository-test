package cn.bingai.practice01.demo01;

import java.util.Scanner;

/*
题目：判断一个整数能被几个9除

程序分析：这个题目也不知道是哪个傻瓜想出来的，我只能说垃圾，不知道它想问什么的？

下面是网上下的答案，我不想做！

我猜它是判断输入的数比9 的多少次方大？而且跟素数有毛关系？？

 */
public class Test45 {
    public static void main(String[] args) {
        System.out.println("请输入一个数：");
        Scanner sc = new Scanner(System.in);
        long l = sc.nextLong();
        sc.close();

        int  count = 0;
        long n = l;
        while(n > 8){
            n = n / 9;
            count++;
        }
        System.out.println(l + "能被" + count +"个9除");

    }
}
