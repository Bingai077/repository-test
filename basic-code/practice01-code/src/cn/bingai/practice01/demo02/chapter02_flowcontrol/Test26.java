package cn.bingai.practice01.demo02.chapter02_flowcontrol;

import java.util.Scanner;
/*
    求ax^2+bx+c=0方程的根。
 */
public class Test26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ax^2+bx+c=0");
        System.out.println("请输入a：");
        double a = sc.nextDouble();
        System.out.println("请输入b：");
        double b = sc.nextDouble();
        System.out.println("请输入c：");
        double c = sc.nextDouble();
        sc.close();

        if (a != 0) {
            if (b * b - 4 * a * c > 0) {
                double x1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
                double x2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
                System.out.println("方程有两个不同根，分别为：" + x1 + "," + x2);
            } else if (b * b - 4 * a * c == 0) {
                double x = -b / (2 * a);
                System.out.println("方程有两个相同根，为：" + x);
            } else {
                System.out.println("方程无解");
            }
        } else {
            if (b != 0) {
                double x = -c / b;
                System.out.println("方程有一个根，为：" + x);
            } else {
                System.out.println("这是一个等式");
                if (c == 0){
                    System.out.println("等式成立");
                }else {
                    System.out.println("等式不成立");
                }
            }

        }

    }
}
