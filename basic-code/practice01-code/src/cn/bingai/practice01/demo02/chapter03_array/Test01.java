package cn.bingai.practice01.demo02.chapter03_array;

/*
    获取数组中的最大值和最小值


 */
public class Test01 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 51, 35, 48, 21, 5, 6, 3145, 33, 22, 53};
        System.out.println("数组中的元素有：");
        int max = arr[0];
        int min = arr[0];
        for (int i : arr) {
            System.out.print(i + " ");
            if (max < i) {
                max = i;
            }
            if (min > i) {
                min = i;
            }
        }
        System.out.println("最大数是" + max + "，最小数是：" + min);

    }
}
