package cn.bingai.practice01.demo01;
/*
题目：有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13... 求出这个数列的前20项之和。

程序分析：请抓住分子与分母的变化规律。分数：fraction
1、第一项是2/1
2、前面一项分子和分母相加的和，为下一项的分子
3、前面一项分子，为下一项的分母

 */
public class Test20 {
    public static void main(String[] args) {//统一数据类型
        double up =2;//分子
        double down = 1;//分母
        double fraction = up / down;//分数
        double temp = 0;
        double sum =0;
        for (int i = 1; i <= 20; i++) {
            temp = up + down;//先把分子分母的和赋值给一个交换数，
            down = up;
            up = temp;
            fraction = up / down;
            sum = sum + fraction;
        }
        System.out.println("前20项的和为：" + sum);


    }

}
