package cn.bingai.practice01.demo02.chapter02_flowcontrol;

import java.util.Scanner;

/*
验证用户登录信息

boolean equals(Object anObject)  将此字符串与指定的对象比较。

equals比较的是字符串内容

==  判断的是内存地址值
 */
public class Test02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String useranme = sc.next();
        System.out.println("请输入密码：");
        String password = sc.next();
        if(!useranme.equals("陈斌杰")){
            System.out.println("用户名错误，请重新输入！！");
        }else if(!password.equals("bingai")){
            System.out.println("密码错误，请重新输入！！");
        }/*if(useranme.equals("陈斌杰") &&  password.equals("bingai"))*/else{
            System.out.println("登录信息正确！");
        }


    }
}
