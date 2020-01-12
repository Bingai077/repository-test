package cn.bingai.practice01.demo02.chapter02_flowcontrol;

/*
    打印输出杨辉三角

    \t 相当于tab，缩进
    \r 回车
    \n 换行符
    \b 换成一个黑点
    \" 转义"
    \' 转义'
    \\ 转义\

 */
public class Test10 {
    public static void main(String[] args) {
        int[][] array = new int[10][10];
        //创建第一列
        for (int i = 0; i < array.length; i++) {
            array[i][0] = 1;
        }

        //创建其他元素，并打印
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == 0 || j == 0 || i == j) {
                    array[i][j] = 1;
                } else {
                    array[i][j] = array[i - 1][j - 1] + array[i - 1][j];
                }
                System.out.print(array[i][j] +"\t");
            }
            System.out.println();
        }





    }
}
