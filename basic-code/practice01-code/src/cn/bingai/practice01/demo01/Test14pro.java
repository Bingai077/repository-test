package cn.bingai.practice01.demo01;

import java.util.Scanner;

/*
题目：输入某年某月某日，判断这一天是这一年的第几天？

程序分析：以3月5日为例，应该先把前两个月的加起来，然后再加上5天即本年的第几天，
特殊情况，闰年且输入月份大于3时需考虑多加一天。

闰年的条件：year除以400能整除，或者year除以4能整除，但是不能是100的倍数
四年一闰，百年不闰，四百年再闰
 */
public class Test14pro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年：");
        int year = sc.nextInt();
        System.out.println("请输入月：");
        int month = sc.nextInt();
        System.out.println("请输入日：");
        int day = sc.nextInt();


        if (isRight(year, month, day)) {
            System.out.println("您输入的日期是：" + year + "年" + month + "月" + day + "日");
            int days = sum(year, month, day);
            System.out.println("该天是" + year + "年的第" + days + "天");

        } else {
            System.out.println("输入有误，请重新输入！");
        }

        sc.close();

    }


    public static boolean isRight(int year, int month, int day) {//判断输入年、月、日是否有错
        boolean a = false;
        boolean b = false;
//        boolean c = false;

        if (year >= 0 && month >= 1 && month <= 12) {
            a = true;
        }
//        if (month >= 1 && month <= 12) {
//            b = true;
//        }
        if (isDayRight(year, month, day)) {
            b = true;
        }

        return (a && b);
    }


    public static boolean isDayRight(int year, int month, int day) {
        boolean a = false;
        int dayOfMonth[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeadYear(year)) {
            dayOfMonth[1] = 29;
        }

        if (month >= 1 && month <= 12 && day > 0 && day <= dayOfMonth[month - 1]) {
            a = true;//前面必须加month限制条件，不然数组有可能越界
        }

//        if (day > 0 && day <= dayOfMonth[month - 1]) {
//            a = true;
//        }

        return a;
    }


    public static boolean isLeadYear(int year) {
        boolean a = false;
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            a = true;
        }
        return a;
    }

    public static int sum(int year, int month, int day) {
        int sum = 0;
        int dayOfMonth[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeadYear(year)) {
            dayOfMonth[1] = 29;
        }
        for (int i = 0; i < month - 1; i++) {//month-1,如果是12月5日，只加到11月
            sum = sum + dayOfMonth[i];
        }
        return sum + day;


    }


}


// 方法二：
//for(--month;month>0;month--)
//
//        {
//
//        switch(month)
//
//        {
//
//        case 1:case 3:case 5:case 7:case 8:case 10:case 12:day+=31;break;
//
//        case 2:day+=er;break;
//
//        case 4:case 6:case 9:case 11:day+=30;break;
//
//default:day+=0;
//
//        }
//
//        }
//
//        printf("请输入日期：");
//
//        scanf("%d",&tian);
//
//        day+=tian;
//
//        printf("这是%d年的第%d天",year,day);



/*
如果能借助Java自身所提供类来实现的话，比较简单：
1、用SimpleDateFormater将字符串转换为Date对象；
2、创建Calendar，调用setTime()；
3、调用Calendar函数 get(Calendar.DAY_OF_YEAR)，就是你要的结果了。
 */