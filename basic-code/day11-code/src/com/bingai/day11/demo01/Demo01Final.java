package com.bingai.day11.demo01;
/*
final关键字：代表最终的、不可改变的。

常见四种用法：
1.可以用来修饰一个【类】
2.可以用来修饰一个【方法】
3.可以用来修饰一个【局部变量】
4.可以用来修饰一个【成员变量】

 */
public class Demo01Final {

    public static void main(String[] args) {
        int num1 = 10;
        System.out.println(num1);//10
        num1 = 20;
        System.out.println(num1);//20

        //一旦使用final用来修饰局部变量，那么这个变量就不能进行更改。
        //【一次赋值，终生不变】
        final int num2 = 200;
        System.out.println(num2);//200

//        num2 = 250;//写法错误！不能改变！
//        num2 = 200;//错误写法！

        //正确写法！只要保证有唯一一次赋值即可
        final int num3;
        num3 = 30;

        //对于基本类型来说，不可变：说的是变量中的【数据】不可变
        //对于引用变量来说，不可变：说的是变量中的【地址】不可变

        Student stu1 = new Student("斌改");
        System.out.println(stu1);//com.bingai.day11.demo01.Student@2ac1fdc4
        System.out.println(stu1.getName());//斌改
        stu1 = new Student("明明");
        System.out.println(stu1);//com.bingai.day11.demo01.Student@5f150435
        System.out.println(stu1.getName());//明明

        System.out.println("=========");

        final Student stu2 = new Student("斌");
//        stu2 = new Student("明明");//错误写法！final修饰的引用数据类型，其中地址不可改变

        System.out.println(stu2);//com.bingai.day11.demo01.Student@1c53fd30
        System.out.println(stu2.getName());//斌改
        stu2.setName("明");
        System.out.println(stu2);//com.bingai.day11.demo01.Student@1c53fd30
        System.out.println(stu2.getName());//明明

    }
}
