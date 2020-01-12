package cn.bingai.practice01.demo02.chapter09_constantClass;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @author bingai
 * @create 2019-11-04 9:56
 */
public class Test13 {

    @Test
    public void test() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //解析：
        Date date = sdf.parse("2017-08-16");
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        System.out.println(date1);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        TemporalAccessor parse = dtf.parse("2017-08-16");
        System.out.println(parse);


    }



}
