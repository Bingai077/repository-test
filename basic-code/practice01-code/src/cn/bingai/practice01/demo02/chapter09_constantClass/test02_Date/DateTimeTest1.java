package cn.bingai.practice01.demo02.chapter09_constantClass.test02_Date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * JDK8之前的日期时间API测试
 * 1.System类中的currentTimeMills()
 * 2.java.util.Date和子类java.sql.Date
 * 3.SimpleDateFormat
 * 4.Calendar
 *
 * @author bingai
 * @create 2019-11-02 9:20
 */
public class DateTimeTest1 {
    /*
        SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析

        1.两个操作：
        1.1：格式化：日期 ---> 字符串
        1.2：解析：格式化的逆过程，字符串 ---> 日期

        2.SimpleDateFormat的实例化

     */
    @Test
    public void testSimpleDateFormat() throws ParseException {
        //实例化SimpleDateFormat:使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期 ---> 字符串
        Date date = new Date();
//        System.out.println(date);
        String format = sdf.format(date);
        System.out.println(format);

        //解析：格式化的逆过程，字符串 ---> 日期
        String str = "2019/12/2 上午9:32";
        Date date1 = sdf.parse(str);
        System.out.println(date1);

        //***************按指定的方式格式化和解析*******************
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format1 = sdf1.format(date);
        System.out.println(format1);
        //解析:要求字符串必须符合SimpleDateFormat识别的格式(通过构造器参数体现)
        Date date2 = sdf1.parse("2020-05-20 13:14:52");
        System.out.println(date2);

    }

    /*
        练习一：字符串"2020-09-08"转化为java.sql.Date

        练习二："三天打鱼两天晒网"   1990-01-01  xxxx-xx-xx 打渔？晒网？
           举例：2020-09-08 ？ 总天数

           总天数 % 5 == 1,2,3 打渔
           总天数 % 5 == 4,0   晒网

           总天数的计算？
           方式一：(date2.getTime - date1.getTime())/(1000*60*60*24) + 1
           方式二：1990-01-01 ---> 2019-12-31 + 2020-01-01 ---> 2020-09-08
     */
    @Test
    public void textExer() throws ParseException {
        String birth = "2020-09-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(birth);
        System.out.println(date);
        //java.util.Date  ---> java.sql.Date
        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);

    }

    @Test
    public void textExer2() throws ParseException {

        String str1 = "2000-01-01";
        String str2 = "2019-11-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse(str1);
        Date date2 = sdf.parse(str2);
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24));
        System.out.println(days);
        switch (days % 5) {
            case 1:
            case 2:
            case 3:
                System.out.println("在打渔！");
                break;
            case 0:
            case 4:
                System.out.println("在晒网！");
                break;

        }

        //方式二
        int count = 0;
        for (int i = 2000; i <= 2019; i++) {
            if (i % 4 == 0 || i % 400 == 0 && i % 100 != 0) {
                count++;
            }
        }
        int days1 = (2019 - 2000) * 365 + count + (31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 2);
        System.out.println(days1);

    }


    /*
        Calendar日历类的使用

     */
    @Test
    public void CalendarTest(){
        //1.实例化
        //方式一：创建其子类(GregorianCalendar)的对象
        //方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.getClass());

        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);//2
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));//306

        //set()
        calendar.set(Calendar.DAY_OF_MONTH,22);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));//22

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,-3);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));//-19

        //getTime():日历类 ---> Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime():Date ---> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));//2



    }



}
