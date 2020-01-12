package cn.bingai.practice01.demo01;

import java.lang.reflect.Modifier;

/*
题目：判断101-200之间有多少个素数，并输出所有素数。 

程序分析：判断素数的方法：用一个数分别去除2到sqrt(这个数)，
如果能被整除， 则表明此数不是素数，反之是素数。

素数只能被1或者其本身整除
 */
public class Test02pro {
    public static void main(String[] args) {
//方法一：
        //        int n = 0;
//        for (int i = 101; i < 200; i++) {
//           int j = 2;
//            for (j = 2; j < i; j++) {
//                if (i % j == 0) {//能被其他数整除，不是素数。
//                    break;//结束循环
//                }
//            }
//            if(i == j){//j在原来的基础上再增加1//只能被本身整除，是素数
//                n++;
//                System.out.println(i + "是素数");
//            }
//        }
//        System.out.println("101~200之间的素数的个数是：" + n);


//       方法二：
//        int num = 0;
//        System.out.println("100~200间的素数有：");
//        for (int i = 100; i < 200 ; i++) {
//            boolean flag = true;
//            for (int j = 2; j < i; j++) {
//                if(i % j == 0){
//                    flag = false;
//                    break;
//                }
//            }
//            if(flag){
//                num++;
//                System.out.print(i + " ");
//            }
//        }
//        System.out.println("                    ");
//        System.out.println("总共有：" + num +"个");


//        方法三：
//
//        int num = 0;
//        System.out.println("100~200间的素数有：");
//        for (int i = 100; i < 200; i++) {
//            int count= 0;
//            for (int j = 1; j <= i; j++) {
//                if(i % j == 0){
//                    count++;
//  //                  break;//不能要break
//                }
//            }
//            if(count == 2){
//                num++;
//                System.out.print(i + " ");
//            }
//        }
//        System.out.println("                    ");
//        System.out.println("总共有：" + num +"个");


//      方法四：
        int num = 0;
        System.out.println("100~200间的素数有：");
        for (int i = 101; i < 200 ; i +=2 ) {

            boolean flag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {//j <= Math.sqrt(i)也可以
                if(i % j == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                num++;
                System.out.print(i + " ");
            }
        }
        System.out.println("                    ");
        System.out.println("总共有：" + num +"个");









    }

}
