package cn.bingai.practice01.demo01;

import java.util.Scanner;

/*
题目：输入两个正整数m和n，求其最大公约数和最小公倍数。

程序分析：利用辗除法。 
这里有一个知识点要记住的，最大公约数和最小公倍数的求法  
1、先求最大公约数bigDivisor
2、就可以很方便获得最小公倍数multiple=input1*input2/bigDivisor


这里最重要的就是求最大公约数：求法如下 
1、用大的数对小的数求余
2、把小的数赋值给大的数，把求余获得的结果赋值给小的数，
3、循环上一步的操作，直到求余的结果为零
4、上一步被求余的数就是我们要的最大公约数，不信的话，你可以动手试试

 */
public class Test06pro {
    public static void main(String[] args) {
        //方法一：
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入第一个正整数：");
//        int input1 = sc.nextInt();
//        System.out.println("请输入第二个正整数：");
//        int input2 = sc.nextInt();
//        int bigDivisor = 0;
//        int mult = input1 * input2;//保存两个数的乘积
//
//        int temp = 1;//用于交换的中间数
//
//        if (input1 < input2) {//确保第一个大于等于第二个数
//            temp = input1;
//            input1 = input2;
//            input2 = temp;
//        }
//
//        while (temp != 0) {//其余结果不等于0，就一直循环
//            temp = input1 % input2;//大的数除小的数求余数
//            input1 = input2;//小的数等于大的数
//            input2 = temp;//余数等于小的数
//        }
//
//        bigDivisor = input1;
//        int multiple = mult / bigDivisor;
//        System.out.println("两个数最大公倍数是：" + bigDivisor);
//        System.out.println("两个数最小公约数是：" + multiple);
//        sc.close();


        //方法二：
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个正整数：");
        int input1 = sc.nextInt();
        System.out.println("请输入第二个正整数：");
        int input2 = sc.nextInt();
        method(input1,input2);

        sc.close();
    }

    public static void method(int input1,int input2){
        //int bigDivisor = 0;
        //两个数的最大公约数不会超过两个数的最大值，两个数的最小公倍数为两数相乘除以最大公约数。
        int max = input1 > input2 ? input1 : input2;
        for (int i = max; i >= 1; i--) {
            if (input1 % i == 0 && input2 % i == 0) {
                //bigDivisor = i;
                System.out.println("两个数最大公倍数是：" + i);
                System.out.println("两个数最小公约数是：" + input1 * input2 / i);

                break;
            }
        }

    }




}
