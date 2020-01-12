package cn.bingai.practice01.demo01;

import java.util.Scanner;

/*
题目：利用条件运算符的嵌套来完成此题：学习成绩>=90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。

程序分析：(a>b)?a:b这是条件运算符的基本例子。

 */
public class Test05 {
    public static void main(String[] args) {
        System.out.println("请输入学生成绩：");
        Scanner sc = new Scanner(System.in);
        int sorce = sc.nextInt();

        String grade = (sorce >= 90)?"A":(sorce >= 60 ? "B":"C");
        System.out.println("学生成绩属于：" + grade);

        sc.close();


    }
}

