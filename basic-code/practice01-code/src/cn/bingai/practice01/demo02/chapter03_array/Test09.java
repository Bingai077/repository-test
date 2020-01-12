package cn.bingai.practice01.demo02.chapter03_array;

/*
使用二维数组打印一个 10 行杨辉三角。

【提示】
        1. 第一行有 1 个元素, 第 n 行有 n 个元素
        2. 每一行的第一个元素和最后一个元素都是 1
        3. 从第三行开始, 对于非第一个元素和最后一个元
        素的元素。即：
        yanghui[i][j] = yanghui[i-1][j-1] + yanghui[i-1][j];
 */
public class Test09 {
    public static void main(String[] args) {

        int[][] yanghui = new int[10][10];

        for (int i = 0; i < yanghui.length; i++) {
            for (int j = 0; j <= i; j++) {
                //两边元素赋值
                if (i == j || i == 0 || j == 0) {
                    yanghui[i][j] = 1;
                } else {//中间元素赋值
                    yanghui[i][j] = yanghui[i - 1][j - 1] + yanghui[i - 1][j];
                }
                System.out.print(yanghui[i][j] +"\t");
            }
            System.out.println();
        }


    }
}
