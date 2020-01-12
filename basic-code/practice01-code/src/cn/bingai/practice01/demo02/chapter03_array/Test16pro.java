package cn.bingai.practice01.demo02.chapter03_array;
/*
    【插入排序法】
    一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：

1.从第一个元素开始，该元素可以认为已经被排序
2.取出下一个元素，在已经排序的元素序列中从后向前扫描
3.如果该元素（已排序）大于新元素，将该元素移到下一位置
4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
5.将新元素插入到该位置后
6.重复步骤2~5
 */
public class Test16pro {
    public static void insertSort(int[] data) {
        System.out.println("开始排序");
        int arrayLength = data.length;
        for (int i = 1; i < arrayLength; i++) {
            int temp = data[i];
            if (data[i] - data[i - 1] < 0) {
                int j = i - 1;
                for (; j >= 0 && data[j] - temp > 0; j--) {
                    data[j + 1] = data[j];
                }
                data[j + 1] = temp;
            }
            System.out.println(java.util.Arrays.toString(data));
        }

    }

    public static void main(String[] args) {
        int[] data = { 9, -16, 21, 23, -30, -49, 21, 30, 30 };
        System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
        insertSort(data);
        System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
    }
}
