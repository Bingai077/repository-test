package com.bingai.utils;

import org.springframework.core.convert.converter.Converter;

import javax.xml.transform.Source;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author bingai
 * @create 2019-12-23 19:09
 * 把一个字符串转换日期
 */
public class StringToDateConverter implements Converter<String,Date>{
    /**
     *
     * @param s 传入字符串的值
     * @return
     */
    @Override
    public Date convert(String s) {
        //判断
        if(s == null){
            throw new RuntimeException("请您传入数据");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //把字符串转换为日期
            return df.parse(s);
        } catch (Exception e) {
            throw new RuntimeException("数据类型转换出现错误");
        }

    }
}
