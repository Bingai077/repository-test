package cn.itcast.day05.demo03;

public class Demo06ArrayMin {
    public static void main(String[] args) {

        int[] array={5,15,30,20,10000,30,35,110,-20};

        int min = array[0];

        for (int i = 1; i < array.length; i++) {

            if(array[i] < min){
                min = array[i];
            }
        }

        System.out.println("最小值：" + min);


    }

}
