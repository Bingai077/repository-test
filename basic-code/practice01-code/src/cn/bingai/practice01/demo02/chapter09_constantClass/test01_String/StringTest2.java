package cn.bingai.practice01.demo02.chapter09_constantClass.test01_String;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**涉及到String与其他结构之间的转换
 * @author bingai
 * @create 2019-11-02 0:47
 */
public class StringTest2 {

    /*
    String 与 byte[]之间的转换

        编码 String ---> byte[]:调用String的getByte()方法
        解码 byte[] ---> String:调用String的构造器


        编码：字符串 --> 字节（看得懂的 ---> 转看不懂的二进制数据）
        解码：字节 --> 字符串（看不懂的二进制数据 ---> 看的懂）

        【说明】在解码时使用的字符集必须和编码集使用的字符集一致，否则会出现乱码

     */

    @Test
    public void Test2() throws UnsupportedEncodingException {


        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes();//使用默认的字符集进行转换，UTF-8，三个字节一汉字
        System.out.println(Arrays.toString(bytes));


            byte[] gbks = str1.getBytes("GBK");//使用GBK字符集进行编码，汉字2个字节
            System.out.println(Arrays.toString(gbks));



        String str2 = new String(bytes);//使用默认字符集，进行解码。
        System.out.println(str2);

        String str3 = new String(gbks);
        System.out.println(str3);//出现乱码，编码集和解码集不一致

        String str4 = new String(gbks, "gbk");
        System.out.println(str4);//没有出现乱码

    }



    /*
    String 与 char[]之间的转换

        String ---> char[]:调用String的toCharArray()
        char[] ---> String:调用String的构造器


     */
    @Test
    public void Test1(){

        String str1 = "abc123";
        char[] charArray = str1.toCharArray();
        System.out.println( Arrays.toString(charArray));

        char[] arr = new char[]{'h','e','l','l','o'};
        String str2 = new String(arr);
        System.out.println(str2);




    }



    /*
        String 与基本数据类、包装类之间的转换
        String ---> 基本数据类、包装类:调用包装类的静态方法：parseXxx(str)
        基本数据类、包装类 ---> String:调用String重载的valueOf(xxx)
     */

    @Test
    public void Test(){
        String str = "123";
        //
        int num = Integer.parseInt(str);
        System.out.println(num);

        String str1 = String.valueOf(num);
        System.out.println(str1);
        String str3 = num + "";
        System.out.println(str3);

        System.out.println(str1 == str3);//false,一个堆，一个常量池






    }
}
