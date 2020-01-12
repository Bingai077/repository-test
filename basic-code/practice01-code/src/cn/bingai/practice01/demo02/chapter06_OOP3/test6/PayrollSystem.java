package cn.bingai.practice01.demo02.chapter06_OOP3.test6;

import java.util.Calendar;
import java.util.Scanner;

public class PayrollSystem {


    public static void main(String[] args) {

        //方式一：
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入当月月份：");
//        int month = sc.nextInt();

        //方式二：
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);//获取当前月份

        Employee[] emps = new Employee[5];

        emps[0] = new SalariedEmployee("斌改",1000,new Mydate(1990,8,8),5000);
        emps[1] = new HourlyEmployee("bingai",1001,new Mydate(1991,9,9),20,10);
        emps[2] = new SalariedEmployee("斌改",1002,new Mydate(1990,8,8),5000);
        emps[3] = new HourlyEmployee("bingai",1003,new Mydate(1991,10,9),20,10);
        emps[4] = new HourlyEmployee("bingai",1004,new Mydate(1991,9,9),20,10);

        for (int i = 0; i < emps.length; i++) {
            System.out.println(emps[i]);
            double salary = emps[i].earnings();
            System.out.println("月工资为：" + salary);
            
            if(month + 1 == emps[i].getBirthday().getMonth()){
                System.out.println("生日快乐，奖励100元。");
            }
        }

    }
}
