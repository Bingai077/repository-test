package cn.bingai.practice01.demo01;

import static java.lang.Math.sqrt;

/*
题目：求100之内的素数

素数的判断方法：这个数除以2到比它本身少1的数都不能整除，那么这个数就是素数了！
 */
public class Test27 {

    public static void main(String[] args) {

        System.out.println("100之内的素数有：");


        int count = 0;
        for (int i = 1; i < 100; i++) {
            int num = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    num++;
                }
            }
            if (num == 2) {
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.println("       ");
        System.out.println(count);

        //方法二：
        for (int i = 2; i < 100 ; i++) {
            if(isPrime(i)){
                System.out.print(i + " ");
            }
        }

    }


    public static boolean isPrime(int n){
        boolean flag = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0){
                flag = false;
                break;
            }
        }
        return flag;
    }

}


