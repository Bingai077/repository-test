package cn.bingai.practice01.demo02.chapter09_constantClass;

import org.junit.Test;

/**
 * @author bingai
 * @create 2019-11-03 10:25
 */
public class Test06 {

    @Test
    public void testString() {
        String str1 = "尚硅谷";
        String str2 = "尚硅谷";
        String str3 = new String("尚硅谷");
        System.out.println(str1 == str2);//true
        System.out.println(str1 == str3);//false
        System.out.println(str1.equals(str3));//true
        str1 = "尚硅谷atguigu.com";
        String str4 = "atguigu.com";
        String str5 = "尚硅谷" + "atguigu.com";
        System.out.println(str1 == str5);//true

        String str6 = (str2 + str4).intern();
        System.out.println(str1 == str6);//false  ---->true
    }

    @Test
    public void test() {
        String s = "people";
        String t = "people";
        String c[] = {"p","e","o","p","l" ,"e"};
        System.out.println( t .equals(new String("people")));



    }


}
