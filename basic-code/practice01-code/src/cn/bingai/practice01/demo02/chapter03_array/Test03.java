package cn.bingai.practice01.demo02.chapter03_array;

/*
    求矩阵的迹
 */
public class Test03 {
    public static void main(String[] args) {
        int[][] array = {{1,2,3,5,7},{4,5,6,8,8},{7,8,9,9,9},{10,11,12,13,14},{13,14,15,16,88}};
        System.out.println("矩阵是：");
        for (int[] arr : array) {
            for (int a : arr) {
                System.out.print(a + "\t");
            }
            System.out.println();
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(i == j){
                    sum += array[i][j];
                }
            }
        }

        System.out.println("矩阵的迹是：" + sum);



    }

}
