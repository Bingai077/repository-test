package cn.bingai.practice01.demo02.chapter03_array;

import java.util.Arrays;

/*
    创建一个长度为6的int型数组，要求取值为1-30，同时元素值各不相同
 */
public class Test10 {
    public static void main(String[] args) {

        int[] arr = new int[6];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 30 + 1);
            for (int j = 0; j < i; j++) {
                if(arr[i] == arr[j]){
                    i--;
                    break;//break加了效率更高
                }
            }

        }

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
