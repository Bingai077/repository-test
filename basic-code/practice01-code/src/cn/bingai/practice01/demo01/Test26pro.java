package cn.bingai.practice01.demo01;

import java.util.Scanner;

/*
题目：请输入星期几的第一个字母来判断一下是星期几，如果第一个字母一样，则继续判断第二个字母。

程序分析：用情况语句比较好，如果第一个字母一样，则判断用情况语句或if语句判断第二个字母。
 */
public class Test26pro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个英文字母：");
        String str = sc.next();

        if ("t".equalsIgnoreCase(str)) {
            System.out.println("请输入第二个英文字母：");
            String str1 = sc.next();
            if ("u".equalsIgnoreCase(str1)) {
                System.out.println("星期二");
            } else if ("h".equalsIgnoreCase(str1)) {
                System.out.println("星期四");
            } else {
                System.out.println("输入有误，请重新输入！");
            }
        } else if ("s".equalsIgnoreCase(str)) {
            System.out.println("请输入第二个英文字母：");
            String str2 = sc.next();
            if ("a".equalsIgnoreCase(str2)) {
                System.out.println("星期六");
            } else if ("u".equalsIgnoreCase(str2)) {
                System.out.println("星期日");
            } else {
                System.out.println("输入有误，请重新输入！");
            }
        } else if ("m".equalsIgnoreCase(str)) {
            System.out.println("星期一");
        } else if ("w".equalsIgnoreCase(str)) {
            System.out.println("星期三");
        } else if ("f".equalsIgnoreCase(str)) {
            System.out.println("星期五");
        } else {
            System.out.println("输入有误，请重新输入！");
        }

        //System.out.println("============================");
        //方法二：用case语句
//        switch (str) {
//            case "T":
//            case "t":
//                System.out.println("请输入第二个英文字母：");
//                String str1 = sc.next();
//                if ("u".equalsIgnoreCase(str1)) {
//                    System.out.println("星期二");
//                } else if ("h".equalsIgnoreCase(str1)) {
//                    System.out.println("星期四");
//                } else {
//                    System.out.println("输入有误，请重新输入！");
//                }
//                break;
//            case "S":
//            case "s":
//                System.out.println("请输入第二个英文字母：");
//                String str2 = sc.next();
//                if ("a".equalsIgnoreCase(str2)) {
//                    System.out.println("星期六");
//                } else if ("u".equalsIgnoreCase(str2)) {
//                    System.out.println("星期日");
//                } else {
//                    System.out.println("输入有误，请重新输入！");
//                }
//                break;
//            case "M":
//            case "m":
//                System.out.println("星期一");
//                break;
//            case "W":
//            case "w":
//                System.out.println("星期三");
//                break;
//            case "F":
//            case "f":
//                System.out.println("星期五");
//                break;
//            default:
//                System.out.println("输入有误，请重新输入！");
//                break;
//
//
//        }


        sc.close();


    }
}
