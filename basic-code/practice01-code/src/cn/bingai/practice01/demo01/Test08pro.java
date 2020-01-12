package cn.bingai.practice01.demo01;

import java.util.Scanner;

/*
题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。
例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加由键盘控制。输出结果的形式如：2+22+222=246；
程序分析：关键是计算出每一项的值。
比如获取的数字为：a，出现的项数为：n
总结一下，可以得到一下规律：
1、第一项有一个a,最后一项有n个a
2、 第1和第2项相差2*10，第2和第三项相差2*100，第k和第k+1项相差2*（10的k次方）
*/
public class Test08pro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个1~9的数字：");
        int a = sc.nextInt();
        System.out.println("请输入相加数字的个数：");
        int num = sc.nextInt();

        method(a, num);

        System.out.println("               ");
        sc.close();


        //方法二：
//
//        int[] arr = new int[num];//创建数组长度为输入的项数
//        int i = 1;//while循环初始化的值
//        arr[0] = a;//数组的第一个值为a
//        while (i < num) {//把每一项的值赋值给数组里面的数
//            a = a * 10;
//            arr[i] = arr[i - 1] + a;
//            i++;
//        }
//        //求和
//        int sum = 0;
//        for (int s : arr) {
//            sum = sum + s;//累加求和
//            if (s == arr[num - 1]) {
//                System.out.print(s);
//                break;//最后一次只输出结果
//            }
//            System.out.print(s + "+");//前面的值输出结果，后面还要加一个加号
//        }
//        System.out.print("=" + sum);//结果显示


    }

    public static void method(int a, int num) {

        int b = 0;
        int sum = 0;

        if (a > 0 && a < 10 && num > 0) {
            for (int i = 0; i < num; i++) {
                b = b + a;
                sum = sum + b;
                a = a * 10;
                if (i == (num - 1)) {
                    break;
                }
                System.out.print(b + "+");

            }
            System.out.print(b + "=" + sum);
        } else {
            System.out.println("输入有误，请重新输入");
        }


    }


}
