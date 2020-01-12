package cn.bingai.practice01.demo02.chapter09_constantClass;

import org.junit.Test;


/**
 * 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反
 转为”abfedcg”
 * @author bingai
 * @create 2019-11-02 22:07
 */
public class Test02pro {
    @Test
    public void test(){

        String str = "abcdefg";
        String str1 = reverseStr(str, 2, 6);
        System.out.println(str1);


    }

    //方式三：使用StringBuffer/Stringbuilder替换String
    private String reverseStr(String str,int start,int end){
        if(str != null){

            String str1 = str.substring(start, end);
            StringBuilder sb = new StringBuilder(str1);
            StringBuilder sb1 = sb.reverse();
            System.out.println(sb1);

            String str2 = str.substring(0,start) + sb1.toString() + str.substring(end);
            return str2;

//            StringBuilder sb = new StringBuilder(str.length());
//            sb.append(str.substring(0,start));
//            for (int i = end - 1; i > 1 ; i--) {
//                sb.append(str.charAt(i));
//            }
//            sb.append(str.substring(end));
//            return sb.toString();

        }
        return null;
    }

    //方式二：转换为char[]
    private String reverseStr1(String str,int start,int end){
        if(str != null){
            char[] chars = str.toCharArray();
            for (int i = start,j = end - 1; i < j; i++,j--) {
                char temp = chars[i];
                chars[i] = chars [j];
                chars[j] = temp;
            }

            return new String(chars);
        }
        return null;
    }


    //方式三：使用String拼接
    private String reverseStr2(String str,int start,int end){

        //第1部分
        String newStr = str.substring(0,start);

        //第2部分
        for (int i = end - 1; i >= start; i--) {
            newStr += str.charAt(i);
        }

        //第3部分
        newStr += str.substring(end,str.length());
        return newStr;
    }



}
