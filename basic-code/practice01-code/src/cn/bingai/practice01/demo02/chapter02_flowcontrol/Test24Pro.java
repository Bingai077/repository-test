package cn.bingai.practice01.demo02.chapter02_flowcontrol;

/*
     100000以内的所有质数.实现方式二
     质数：只能被1和它本身整除的自然数
 */
public class Test24Pro {
    public static void main(String[] args) {


        int count = 0;//记录质数个数

        label:for (int i = 2; i <= 100000; i++) {//遍历

            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0){//i被j除尽
                    continue label;
                }
            }
            //执行到此步骤的，都是质数
            count++;
            //System.out.println(i + " ");
        }

        System.out.println("质数个数为" + count);

    }
}
