package cn.bingai.practice01.demo02.chapter04_OOP1.test2;

/*
    声明一个日期类型MyDate：有属性：年year,月month，日day。 创建2个日期
    对象，分别赋值为：你的出生日期，你对象的出生日期， 并显示信息。
 */
public class Demo {
    public static void main(String[] args) {
        MyDate myDate1 = new MyDate(1993, 5, 5);
        System.out.println("我的出生年月日为:" + myDate1.getYear() + "年" + myDate1.getMonth() + "月" + myDate1.getDay());
        MyDate myDate2 = new MyDate(1992, 3, 10);
        System.out.println("我对象的出生年月日为:" + myDate2.getYear() + "年" + myDate2.getMonth() + "月" + myDate2.getDay());

    }
}
