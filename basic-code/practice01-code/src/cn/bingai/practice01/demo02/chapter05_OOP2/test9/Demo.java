package cn.bingai.practice01.demo02.chapter05_OOP2.test9;

import java.util.Scanner;
import java.util.Vector;

/*
利用Vector代替数组处理：从键盘读入学生成绩（以负数代表输入结束），找出
最高分，并输出学生成绩等级。
提示：数组一旦创建，长度就固定不变，所以在创建数组前就需要知道它的
长度。而向量类java.util.Vector可以根据需要动态伸缩。
创建Vector对象： Vector v=new Vector();
给向量添加元素： v.addElement(Object obj); //obj必须是对象
取出向量中的元素： Object obj=v.elementAt(0);
注意第一个元素的下标是0，返回值是Object类型的。
计算向量的长度： v.size();
若与最高分相差10分内： A等； 20分内： B等；
30分内： C等；其它： D等
 */
public class Demo {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();

        Scanner sc = new Scanner(System.in);
        int max = 0;
        while (true) {
            System.out.println("输入学生成绩(负数结束)：");
            int score = sc.nextInt();

            if (score < 0) {
                break;
            }
            if(score >= 100){
                System.out.println("请重新输入！");
                continue;//结束循环
            }

            v.add(score);

            max = score > max ? score : max;

        }
        sc.close();

//        int max = 0;
        /*for (Integer score : v) {
            max = score > max ? score : max;
        }*/

        String str = "";
        for (Integer score : v) {
            if (score >= (max - 10)) {
                str = "A";
            } else if (score >= (max - 20)) {
                str = "B";
            } else if (score >= (max - 30)) {
                str = "C";
            } else {
                str = "D";
            }

            System.out.println("分数是：" + score + "，等级为：" + str);
        }


    }
}
