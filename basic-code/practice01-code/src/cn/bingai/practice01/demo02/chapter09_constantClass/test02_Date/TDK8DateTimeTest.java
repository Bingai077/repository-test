package cn.bingai.practice01.demo02.chapter09_constantClass.test02_Date;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * jdk8中的日期时间API的测试
 *
 * @author bingai
 * @create 2019-11-02 10:57
 */
public class TDK8DateTimeTest {

    @Test
    public void testDate() {
        Date date1 = new Date(2020 - 1900, 9 - 1, 8);
        System.out.println(date1);//Fri Oct 08 00:00:00 CST 3920

    }

    /*
        LocalDate、 LocalTime、 LocalDateTime 类的使用
        说明：
            1. LocalDateTime 类使用频率最高
            2. 类似于Calendar

        实例化：
        now() / * now(ZoneId zone) 静态方法， 根据当前时间创建对象/指定时区的对象
        of() 静态方法， 根据指定日期/时间创建对象

        getDayOfMonth()/getDayOfYear() 获得月份天数(1-31) /获得年份天数(1-366)
        getDayOfWeek() 获得星期几(返回一个 DayOfWeek 枚举值)
        getMonth() 获得月份, 返回一个 Month 枚举值
        getMonthValue() / getYear() 获得月份(1-12) /获得年份
        getHour()/getMinute()/getSecond() 获得当前对象对应的小时、 分钟、 秒
        withDayOfMonth()/withDayOfYear()/
        withMonth()/withYear() 将月份天数、 年份天数、 月份、 年份修改为指定的值并返回新的对象
        plusDays(), plusWeeks(),
        plusMonths(), plusYears(),plusHours() 向当前对象添加几天、 几周、 几个月、 几年、 几小时
        minusMonths() / minusWeeks()/
        minusDays()/minusYears()/minusHours() 从当前对象减去几月、 几周、 几天、 几年、 几小时

     */
    @Test
    public void test1(){
        //now():获取当前的日期
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);//2019-11-02
        System.out.println(localTime);//11:35:49.621862500
        System.out.println(localDateTime);//2019-11-02T11:35:49.621862500


        //of():设置指定的年月日，时分秒，没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 5, 20, 13, 14, 52);
        System.out.println(localDateTime1);//2020-05-20T13:14:52

        //getXxx()：获取相关属性
        System.out.println(localDateTime.getDayOfMonth());//2
        System.out.println(localDateTime.getDayOfWeek());//SATURDAY
        System.out.println(localDateTime.getMonth());//NOVEMBER
        System.out.println(localDateTime.getMonthValue());//11
        System.out.println(localDateTime.getMinute());//43

        //withXxx():设置相关属性，体现可变性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);//2019-11-02
        System.out.println(localDate1);//2019-11-22

        LocalDateTime localDateTime2 = localDateTime.withHour(4);
        System.out.println(localDateTime);//2019-11-02T11:47:40.936267200
        System.out.println(localDateTime2);//2019-11-02T04:47:40.936267200

        //不可变性
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime3);//2020-02-02T11:49:46.671940600
        System.out.println(localDateTime);//2019-11-02T11:51:02.954191200

        LocalDateTime localDateTime4 = localDateTime.minusDays(6);
        System.out.println(localDateTime4);


    }
    /*
        Instance的使用
        类似于 java.util.Date类

     */

    @Test
    public void test2(){

        //now():获取本初子午线对应的标准时间
        Instant instance = Instant.now();
        System.out.println(instance);//2019-11-02T04:00:46.308987700Z

        //添加时间偏移量
        OffsetDateTime offsetDateTime = instance.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//2019-11-02T12:03:48.222122600+08:00

        //toEpochMilli():获取对应的毫秒数（自1970-01-01 00:00:00）
        long milli = instance.toEpochMilli();
        System.out.println(milli);//1572667617258

        //ofEpochMilli():通过给定的毫秒数，获取Instance实例  --->  Date类的getTime()方法
        Instant instant1 = Instant.ofEpochMilli(1572667617258L);
        System.out.println(instant1);//2019-11-02T04:06:57.258Z


    }


        /*

            DateTimeFormatter：用来格式化或解析日期、时间
            类似于SimpleDateFormat


         */
    @Test
    public void teat3(){
        //实例化方式一： 预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);

        //解析：字符串 ---> 日期
        TemporalAccessor parse = formatter.parse("2019-12-02T17:10:28.2576374");
        System.out.println(parse);

        //实例化方式二： 本地化相关的格式。如： ofLocalizedDateTime()
        //FormatStyle.LONG/FormatStyle.MEDIUM/FormatStyle.SHORT:适用于LocalDateTime
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        //格式化
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);

        //本地化相关格式。如：ofLocalizedDate()
        //FormatStyle.FULL/FormatStyle.LONG/FormatStyle.MEDIUM/FormatStyle.SHORT:适用于LocalDate
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        //格式化
        String Str3 = formatter2.format(localDate);
        System.out.println(Str3);

        //【重点】实例化方式三： 自定义的格式。如： ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println(str4);

        //解析
        TemporalAccessor parse1 = formatter3.parse("2019-11-02 05:32:30");
        System.out.println(parse1);


    }


}


