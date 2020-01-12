package cn.bingai.practice01.demo02.chapter03_array;
/*
    实现矩阵的装置

    【二维矩阵的列长度表示】： array[0].length

    【增强for遍历二维数组】
    for (int[] arr : array) {
            for (int a : arr) {
                System.out.print(a + "\t");
            }

    【增强for一般只用来遍历】
 */
public class Test02Pro {
    public static void main(String[] args) {
        int[][] array = {{1,2,3},{4,5,6},{7,8,9},{10,11,12},{13,14,15}};
        System.out.println("转置前的矩阵是：");
        printArray(array);

        int array1[][] = new int[array[0].length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array1[j][i]=array[i][j];
            }
        }
        System.out.println("转置后的矩阵是：");
        printArray(array1);

    }

    //增强for遍历二维数组
    public static void printArray(int[][] array){
        for (int[] arr : array) {
            for (int a : arr) {
                System.out.print(a + "\t");
            }
            System.out.println();
        }
    }
}
