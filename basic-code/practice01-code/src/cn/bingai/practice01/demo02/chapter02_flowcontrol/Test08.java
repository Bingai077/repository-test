package cn.bingai.practice01.demo02.chapter02_flowcontrol;

import java.util.Scanner;

/*
招聘计算机程序员

 */
public class Test08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入应聘者的姓名");
        String name = sc.next();
        System.out.println("请输入应聘者编程语言：");
        String language = sc.next();
        sc.close();
/*

        System.out.println("Java".hashCode());//2301506
        System.out.println("java".hashCode());//3254818
        System.out.println("JAVA".hashCode());//2269730
        System.out.println("c#".hashCode());//3104
        System.out.println("C#".hashCode());//2112
        System.out.println("Asp.net".hashCode());//955463181
        System.out.println("ASP.NET".hashCode());//9745901
        System.out.println("asp.net".hashCode());//-709190099
*/

        switch (language.hashCode()){
            case 2269730:
            case 3254818:
            case 2301506:
                System.out.println(name + "被分配到Java程序开发部门");
                break;
            case 3104:
            case 2112:
                System.out.println(name + "被分配到C#程序开发部门");
                break;
            case 955463181:
            case 9745901:
            case -709190099:
                System.out.println(name + "被分配到Asp.net程序测试部门");
                break;
            default:
                System.out.println("本公司不需要" + language + "开发人员");

        }





    }
}
