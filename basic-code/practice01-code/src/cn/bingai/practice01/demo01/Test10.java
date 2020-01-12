package cn.bingai.practice01.demo01;

import java.util.Scanner;

/*
题目：一球从h米高度自由落下，每次落地后反跳回原高度的一半；
再落下，求它在 第n次落地时，共经过多少米？第n次反弹多高？

程序分析：反弹的高度:(1/2)的n次方*h
1、经过的距离：这个可以总结得到：第一次落地经过：h,第二次落地经过：h+(h/2)*2,
2、第三次落地经过：h+(h/2)*2+(h/2/2)*2 
3、那么第n次落地经过：  h+(h/2)*2+(h/2/2)*2 +...+h/(2的n-1次方)*2

 */
public class Test10 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你想知道的落地次数n：");
        int n = sc.nextInt();
        System.out.println("请输入你想知道的落地高度h：");
        double h = sc.nextDouble();
        double hight = h;
        double mile = h;
//        for (int i = 0; i < n; i++) {//从第一次开始
        for (int i = 1; i < n; i++) {
            mile = mile + hight;
            hight = hight / 2;
        }

        System.out.println("小球第n次落地时，共经过的米数(h):" + mile);
        System.out.println("第n次反弹的高度(h)：" + hight/2);
        sc.close();
    }
}
