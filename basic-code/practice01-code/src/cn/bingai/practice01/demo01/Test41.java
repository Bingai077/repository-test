package cn.bingai.practice01.demo01;

/*
题目：海滩上有一堆桃子，五只猴子来分。第一只猴子把这堆桃子凭据分为五份，多了一个，这只猴子把多的一个扔入海中，拿走了一份。第二只猴子把剩下的桃子又平均分成五份，又多了一个，它同样把多的一个扔入海中，拿走了一份，第三、第四、第五只猴子都是这样做的，问海滩上原来最少有多少个桃子？

程序分析：有个疑问就是题目没说第五个猴子拿到的只有一个桃子，但是别人都知道？？不理解
这其实就是一个递归问题每次*5 +1
这个用逆向思维
              5     4      3     2      1     

桃子个数       6    31    156   781     3906

猴子拿的个数   1      6    31    156     781

 */
public class Test41 {
    public static void main(String[] args) {

        System.out.println(fun(5));
        System.out.println(fun1(5));
        System.out.println(fun2(0));

    }

    public static int fun(int n) {
        while (n > 0) {
            return 5 * fun(n - 1) + 1;
        }
        return 1;
    }

    public static int fun1(int n) {
        if (n == 1) {
            return 6;
        } else {
            return 5 * fun1(n - 1) + 1;
        }
    }

    public static int fun2(int n) {
        if (n == 5) {
            return 1;
        } else {
            return 5 * fun2(n + 1) + 1;
        }

    }


}
