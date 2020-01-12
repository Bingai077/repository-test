package cn.bingai.practice01.demo02.chapter02_flowcontrol;

/*
    空心/实心菱形如何表示
 */
public class Test11Pro {
    public static void main(String[] args) {
        printHollowDiamond(10);
        System.out.println("===========");
        printSolidDiamond(10);

    }

    public static void printHollowDiamond(int n) {


        /* //n=7
        for (int i = 4; i >= 1 ; i--) {//行
            for (int j = 1; j <= 7; j++) {//列
                if(j==i||j==8-i){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        for (int i = 2; i <= 4 ; i++) {//行
            for (int j = 1; j <= 7; j++) {//列
                if(j==i||j==8-i){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }*/

        if (n % 2 == 0) {
            n++;
        }
        for (int i = n/2+1; i >= 1; i--) {//行
            for (int j = 1; j <= n; j++) {//列
                if (j == i || j == n + 1 - i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        for (int i = 2; i <= n/2+1; i++) {//行
            for (int j = 1; j <= n; j++) {//列
                if (j == i || j == n + 1 - i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

    public static void printSolidDiamond(int n) {
        if (n % 2 == 0) {
            n++;
        }
        for (int i = n/2+1; i >= 1; i--) {//行
            for (int j = 1; j <= n; j++) {//列
                if (j >= i && j <= n + 1 - i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        for (int i = 2; i <= n/2+1; i++) {//行
            for (int j = 1; j <= n; j++) {//列
                if (j >= i && j <= n + 1 - i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }



}
