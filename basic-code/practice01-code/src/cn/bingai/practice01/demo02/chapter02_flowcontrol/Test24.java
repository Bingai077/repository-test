package cn.bingai.practice01.demo02.chapter02_flowcontrol;

/*
     100000以内的所有质数
     质数：只能被1和它本身整除的自然数
 */
public class Test24 {
    public static void main(String[] args) {


        long start = System.currentTimeMillis();
        //优化

       int count = 0;//记录质数个数
           for (int i = 2; i <= 100000; i++) {//遍历

               boolean isFlag = true;//标识i是否被j除尽

            //优化二：对本身是质数的自然数是有效的
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0){//i被j除尽
                    isFlag = false;
                    break;//优化一：只对本身非质数的自然数有效
                }
            }

            if(isFlag){
                count++;
                //System.out.println(i + " ");
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("质数个数为" + count);
        System.out.println("所花费的毫秒数为"+(end - start));//12364//优化一break：1075/优化二：102/优化三：10








        /*for (int i = 2; i <= 100; i++) {//遍历

            boolean isFlag = true;//标识i是否被j除尽

            for (int j = 2; j < i; j++) {
                if (i % j == 0){//i被j除尽
                    isFlag = false;
                }
            }

            if(isFlag){
                System.out.print(i + " ");
            }
        }*/

    }
}
