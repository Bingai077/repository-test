package cn.bingai.practice01.demo02.chapter09_constantClass.test02_Date;

import org.junit.Test;

/**
 * @author bingai
 * @create 2019-11-02 9:01
 */
public class IDEADebug {
    @Test
    public void testStringBuffer(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());//4,null的字符
        System.out.println(sb);//"null"

        StringBuffer sb1 = new StringBuffer(str);//NullPointerException
        System.out.println(sb1);//
    }

}
