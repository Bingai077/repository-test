package cn.bingai.practice01.demo02.chapter03_array;

/*
    获取arr数组中所有元素的和。
    提示：使用for的嵌套循环即可。
 */
public class Test08 {
    public static void main(String[] args) {
        int[][] arr = {{3, 5, 8}, {12, 9}, {7, 0, 6, 4}};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
        }
        System.out.println(sum);
    }
}
