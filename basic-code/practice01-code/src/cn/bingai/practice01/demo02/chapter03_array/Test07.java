package cn.bingai.practice01.demo02.chapter03_array;

import java.util.Arrays;
import java.util.Scanner;

/*
    从键盘读入学生成绩，找出最高分，
        并输出学生成绩等级。
        成绩>=最高分-10 等级为’A’
        成绩>=最高分-20 等级为’B’
        成绩>=最高分-30 等级为’C’
        其余 等级为’D’
        提示：先读入学生人数，根据人数创建int数组，
        存放学生成绩。
 */
public class Test07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生人数：");
        int num = scanner.nextInt();

        int[] sorces = new int[num];

        int max = sorces[0];
        for (int i = 0; i < sorces.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个学生成绩：");
            sorces[i] = scanner.nextInt();
            if(max < sorces[i]){
                max = sorces[i];
            }
        }
        scanner.close();


       /* for (int sorce : sorces) {
            if (max < sorce) {
                max = sorce;
            }
        }*/

        char level;
        for (int i = 0; i < sorces.length; i++) {
            if (max - sorces[i] <= 10) {
                level = 'A';
            } else if (max - sorces[i] <= 20) {
                level = 'B';
            } else if (max - sorces[i] <= 30) {
                level = 'C';
            } else {
                level = 'D';
            }
            System.out.println("第" + (i + 1) + "学生的成绩和等级分别是：" + sorces[i] + ", " + level);
        }


    }
}
