package cn.bingai.practice01.demo02.chapter02_flowcontrol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/*
    首先讲一下选号规则，
    前区红色球可以在1-33个编号中任意选择6个，蓝色球可以在1-16中选择一个

    六等奖是中了0到2个红色球加一个蓝色球，金额5元，
    五等奖是中了3个红球加一个蓝球或4个红球，金额十元，
    四等奖是中了4红球加1蓝球或5红球，金额200元，
    三等奖是中了5红球加1蓝球，金额3000元，
    二等奖是中了6个红球，金额有浮动，
    一等奖是中了6红球加1蓝球，奖金浮动最高1000万，
    当奖池资金低于1亿元时，奖金总额为当期高奖级奖金的70%，
    单注奖金按注均分，奖池高于一亿时，总额为当期高奖金奖金的50%与奖池中资金之和，
    另一部分为当期高奖级奖金的20%，单注最高限额封顶500万元。

 */
public class Test29_excel {
    public static void main(String[] args) {

        //获取开奖号码
        int[] sysRedNums = new int[6];
        for (int i = 0; i < sysRedNums.length; i++) {// [0,1) [0,30) [1,31)
            sysRedNums[i] = (int) (Math.random() * 33) + 1;

            for (int j = 0; j < i; j++) {
                if (sysRedNums[i] == sysRedNums[j]) {
                    i--;
                    break;
                }
            }
        }
        Arrays.sort(sysRedNums);
        int sysBlueNum = (int) (Math.random() * 16) + 1;


        System.out.println("请明明投注：");
        System.out.println("请输入机选注数：");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int numberCount = 0;
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int num4 = 0;
        int num5 = 0;
        int num6 = 0;


        String str = "";
        ArrayList<Object> list = new ArrayList<>();

        while (true) {
            //获取用户输入
            int redNums[] = new int[6];
            //System.out.println("请选择6个红球号码(1-33)：");

                /*for (int i = 0; i < redNums.length; i++) {
                    redNums[i] = sc.nextInt();
                }*/

            for (int i = 0; i < redNums.length; i++) {// [0,1) [0,30) [1,31)
                redNums[i] = (int) (Math.random() * 33) + 1;

                for (int j = 0; j < i; j++) {
                    if (redNums[i] == redNums[j]) {
                        i--;
                        break;
                    }
                }
            }

            //System.out.println("请选择蓝球号码(1-16)：");
            //int blueNum = sc.nextInt();
            int blueNum = (int) (Math.random() * 16) + 1;


            Arrays.sort(redNums);
            System.out.println("您购买的彩票为：" + Arrays.toString(redNums) + "[" + blueNum + "]");


            //红球比较
            int count = 0;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if (redNums[i] == sysRedNums[j]) {
                        count++;
                    }
                }
            }

            //显示结果
            if (count == 6 && blueNum == sysBlueNum) {
                str = "恭喜您，获得一等奖，奖金：1000万";
                num1++;
            } else if (count == 6) {
                str = "恭喜您，获得二等奖，奖金：500万";
                num2++;
            } else if (count == 5 && blueNum == sysBlueNum) {
                str = "恭喜您，获得三等奖，奖金：3000元";
                num3++;
            } else if ((count == 4 && blueNum == sysBlueNum) || count == 5) {
                str = "恭喜您，获得四等奖，奖金：200元";
                num4++;
            } else if ((count == 3 && blueNum == sysBlueNum) || count == 4) {
                str = "恭喜您，获得五等奖，奖金：10元";
                num5++;
            } else if ((count == 2 && blueNum == sysBlueNum) || (count == 1 && blueNum == sysBlueNum) || blueNum == sysBlueNum) {
                str = "恭喜您，获得六等奖，奖金：5元";
                num6++;
            } else {
                str = "感谢投注，再来一张！";
            }

            list.add(str);
            numberCount++;

            //System.out.println("===============================");
            //System.out.println("继续投注请按：1，结束投注请按：2");
            //int num = sc.nextInt();
            //if (num == 2) {
            if (number == numberCount) {
                break;
            }
            System.out.println("===============================");


        }
        sc.close();


        System.out.println("==================================================");
        System.out.println("本期开奖号码为：" + Arrays.toString(sysRedNums) + "[" + sysBlueNum + "]");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("第" + (i + 1) + "张彩票开奖结果是：" + list.get(i));
        }
        System.out.println("==================================================");
        System.out.println("本次一共花费" + number * 2 + "元");
        System.out.println("中奖情况为：");
        System.out.println("一等奖：" + num1 + "次");
        System.out.println("二等奖：" + num2 + "次");
        System.out.println("三等奖：" + num3 + "次");
        System.out.println("四等奖：" + num4 + "次");
        System.out.println("五等奖：" + num5 + "次");
        System.out.println("六等奖：" + num6 + "次");
        int num = num1 * 10000000 + num2 * 5000000 + num3 * 3000 + num4 * 200 + num5 * 10 + num6 * 5 - number * 2;
        System.out.println("本次一共赚了" + num + "元");


    }
}
