package cn.bingai.practice01.demo02.chapter07_Exception;
/*
IndexOutOfBoundsException 数组下标越界
 */
public class Test7_IndexOutOfBoundsException {
    public static void main(String[] args) {
        int[] arr = new int[5];
        try{
            for (int i = 0; i < 10; i++) {
                arr[i] = i;
                System.out.println(arr[i] + "\t");
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("异常是：" + e.getMessage());
        }
        System.out.println("ending");

    }

}
