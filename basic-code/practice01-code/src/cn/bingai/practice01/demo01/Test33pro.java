package cn.bingai.practice01.demo01;

/*
题目：打印出杨辉三角形（要求打印出10行如下图）
程序分析：          1       
                  1 1       
                 1 2 1     
                1 3 3 1   
               1 4 6 4 1
             1 5 10 10 5 1
1、二维数组的使用
2、第一列的数都是1
3、使用两个for循环，i控制行，j控制列；
从第二行第二列起arr[i][j]=arr[i-1][j-1]+arr[i-1][j]
 */
public class Test33pro {

    public static void main(String[] args) {


        int[][] arr = new int[10][10];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = 1;//首列设为 1
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {//列的长度
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];//赋值
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - i; j >= 0; j--) {//空行
                System.out.print("  ");
            }

            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {//去零
                    System.out.print(arr[i][j] + "   ");//打印
                }
            }
            System.out.println();//换行
        }



//        arr[0][0] = 1;
//        arr[1][0] = 1;
//        arr[0][1] = 1;
//        for (int i = 1; i < 11; i++) {
//
//            for (int j = 2; j < 11; j++) {
//                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
//                System.out.print(arr[i][j] + " ");
////                if(arr[i][j] == 0){
////                    System.out.println();
////                }
//            }
//            System.out.println();
//        }

    }

}