package com.bingai.day12.demo03.Datemat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
    java.text.DateFormat:DateFormat 是日期/时间格式化子类的抽象类
    作用：
        格式化（也就是日期 -> 文本）、解析（文本-> 日期）和标准化
    成员方法：
        String format(Date date)   按照指定的模式，把Date日期，格式化为符合模式的字符串

        Date parse(String source)  把符合模式的字符串，解析为Date日期

    DateFormat类是一个抽象类，无法创建对象直接使用，可以使用DateFormat的子类
    java.text.SimpleDateFormat extends DateFormat

    构造方法：
         SimpleDateFormat(String pattern)
          用给定的模式和默认语言环境的日期格式符号构造 SimpleDateFormat。
            参数：
                String pattern：传递指定的模式
            模式：区分大小写的
                  y    年
                  M    月
                  d    日
                  H    小时
                  m    分钟
                  s    秒
               写对应的模式，会把模式替换为对应的日期和时间
                    "yyyy-MM-dd HH:mm:ss"
                    "yyyy年MM月dd日 HH时mm分ss秒"
             注意：
                 模式中的字母不能更改，连接模式的符号可以改变


 */
public class Demo01DateFormat {
    public static void main(String[] args) throws ParseException {

        demo01();
        System.out.println("=========");
        demo02();

    }
/*
        使用DateFormat类中的format，把日期格式化为文本
        String format(Date date)   按照指定的模式，把Date日期，格式化为符合模式的字符串
        使用步骤：
            1.创建SimpleDateFormat对象，构造方法在传递指定的模式
            2.调用SimpleDateFormat对象中的方法format，按照构造方法中指定的模式，把Date日期格式化为符合模式的字符串（文本）

 */
    private  static void demo01(){
        //1.创建SimpleDateFormat对象，构造方法在传递指定的模式
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        //2.调用SimpleDateFormat对象中的方法format，按照构造方法中指定的模式，把Date日期格式化为符合模式的字符串（文本）
        Date date = new Date();
        String format = sdf.format(date);
        System.out.println(date);//Tue Oct 08 14:51:19 CST 2019
//        System.out.println(format);//2019-10-08 14:51:19
        System.out.println(format);//2019年10月08日 14时52分35秒
    }

    /*
    使用DateFormat类中的parse,把文本解析为日期
    Date parse(String source)  把符合模式的字符串，解析为Date日期
    使用步骤：
        1.创建SimpleDateFormat对象，构造方法在传递指定的模式
        2.调用SimpleDateFormat对象中的方法parse，把符合构造方法中模式的字符串，解析为Date日期
    注意：
        public Date parse(String source) throws ParseException
        parse方法声明了一个异常叫ParseException解析异常
        如果字符串和构造方法中的模式不一样，那么程序就会抛出异常
        调用一个抛出了异常的方法，就必须处理这个异常
        要么throw继续声明抛出这个异常，要么try...catch自己处理这个异常
     */
    private  static void demo02() throws ParseException {
        //1.创建SimpleDateFormat对象，构造方法在传递指定的模式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
       // 2.调用SimpleDateFormat对象中的方法parse，把符合构造方法中模式的字符串，解析为Date日期
        Date date = sdf.parse("2019年10月08日 14时52分35秒");
        System.out.println(date);
    }
}
