package cn.bingai.practice01.demo01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
题目：有五个学生，每个学生有3门课的成绩，从键盘输入以上数据（包括学生号，姓名，三门课成绩），
计算出平均成绩，将原有的数据和计算出的平均分数存放在磁盘文件"stud"中。

最后这题涉及文件存储，输入输出流
 */
public class Test50pro {
    public static void main(String[] args) {
        //创建数组
        int  N =5;//学生人数
        String[] number = new String[N];
        String[] name = new String[N];
        double[][] grade = new double[N][3];
        double[] avg = new double[N];

        //输入学生信息放入数组
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < N; i++) {
            System.out.println("请输入第"+(i+1)+"个学生的学号：");
            number[i] = sc.next();
            System.out.println("请输入第"+(i+1)+"个学生的姓名：");
            name[i] = sc.next();
            for (int j = 0; j < 3; j++) {
                System.out.println("请输入第"+(i+1)+"个学生的第"+(j+1)+"门课的成绩：");
                grade[i][j] = sc.nextDouble();
            }
        }
        sc.close();

        //计算平均分
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                avg[i] = avg[i]+grade[i][j];
            }
            avg[i] /= 3;
        }

        //写入磁盘文件
        try {
            FileWriter fw = new FileWriter("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo01\\Test50Student.txt");
            BufferedWriter br = new BufferedWriter(fw);
            //br.write("No.  " + "Name  " + "grade1  " + "grade2  " + "grade3  " + "average");
            for (int i = 0; i < N; i++) {
                br.write("学号：" + number[i] + " ");
                br.write("姓名：" + name[i] + " ");
                br.write("成绩："  + "{");
                for (int j = 0; j < 3; j++) {
                    br.write(grade[i][j] + " ");
                }
                br.write("}");
                br.write("平均成绩：" + avg[i] + " ");
                br.newLine();
            }
            System.out.println("写入成功！");
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
