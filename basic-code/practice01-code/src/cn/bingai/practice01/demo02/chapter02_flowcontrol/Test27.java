package cn.bingai.practice01.demo02.chapter02_flowcontrol;

import java.util.Scanner;

/*
    赌数游戏
        提供三个1-6的随机数，作为掷骰子得到的点数。如果各个点数相同，则为豹子。
        如果三个骰子点数和，小于或等于9，则为“小”。
        如果三个骰子点数和，大于9，则为“大”。
        用户随机选择：押大、押小或者押豹子。通过判断，输出客户是否押正确。


 */
public class Test27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请猜宝(大/小/豹子):");
        String guess = sc.next();
        sc.close();

        int a = (int) (Math.random() * 6 + 1);
        int b = (int) (Math.random() * 6 + 1);
        int c = (int) (Math.random() * 6 + 1);

        String result = "";
        if (a == b && b == c) {
            result = "豹子";
        } else if (a + b + c > 9) {
            result = "大";
        } else {
            result = "小";
        }

        if (guess.equals(result)) {
            System.out.println("恭喜您，押中了");
        } else {
            System.out.println("请重押");
        }
        System.out.println("骰子点数分别是：" + a + "," + b + "," + c);


    }
}
