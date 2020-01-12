package cn.bingai.practice01.demo02.chapter09_constantClass;

import java.util.Scanner;

/**
 * 编写一个Java应用程序，从键盘读取用户输入两个字符串，
 * 并重载3个函数分别实现这两个字符串的拼接、整数相加和浮点数相加。
 * 要进行异常处理，对输入的不符合要求的字符串提示给用户，不能使程序崩溃。
 * @author bingai
 * @create 2019-11-03 11:34
 */
public class Test10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数字型字符串：");
        String str1 = sc.next();
        System.out.println("请输入第二个数字型字符串：");
        String str2 = sc.next();
        sc.close();

        if(Double.valueOf(str1) instanceof Double && Double.valueOf(str1) instanceof Double){
            Double db1 = Double.valueOf(str1);
            Double db2 = Double.valueOf(str2);
            int num1 = Integer.parseInt(str1);
            int num2 = Integer.parseInt(str2);

            System.out.println("两个字符串拼接结果为" + str1 + str2);
            System.out.println("两个字符串整数相加结果为" + (num1 + num2));
            System.out.println("两个字符串浮点数相加结果为" + (db1 + db2));

        }else{
            throw new RuntimeException("字符串类型错误！");
        }

    }
}
