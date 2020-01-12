package cn.bingai.practice01.demo02.chapter03_array;

import java.util.Arrays;

/*
【快速排序法】对数组进行排序
快速排序使用分治策略来把一个序列（list）分为两个子序列（sub-lists）。步骤为：

1.从数列中挑出一个元素，称为"基准"（pivot）。
2.重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任一边）。在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
3.递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序。
递归到最底部时，数列的大小是零或一，也就是已经排序好了。这个算法一定会结束，因为在每次的迭代（iteration）中，它至少会把一个元素摆到它最后的位置去。
 */
public class Test15pro {
    public static void main(String[] args) {
        int[] arr = {1, 2, 44, 5, 4, 221, 6, 2552, 252, 1021, 52, 402, 22, 520, 21};
        System.out.println("排序前" + Arrays.toString(arr));
        //从小到大
        quickSort(arr);
        System.out.println("排序后" + Arrays.toString(arr));
    }

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private static void subSort(int[] data, int start, int end) {
        if (start < end) {
            int base = data[start];
            int low = start;
            int high = end + 1;
            while (true) {
                while (low < end && data[++low] - base <= 0)
                    ;
                while (high > start && data[--high] - base >= 0)
                    ;
                if (low < high) {
                    swap(data, low, high);
                } else {
                    break;
                }
            }
            swap(data, start, high);

            subSort(data, start, high - 1);//递归调用
            subSort(data, high + 1, end);
        }
    }
    public static void quickSort(int[] data){
        subSort(data,0,data.length-1);
    }

}
