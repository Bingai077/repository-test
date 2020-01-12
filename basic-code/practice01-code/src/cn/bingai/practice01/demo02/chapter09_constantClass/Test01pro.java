package cn.bingai.practice01.demo02.chapter09_constantClass;

import org.junit.Test;

/**
 * 模拟一个trim方法，去除字符串两端的空格。
 *
 * @author bingai
 * @create 2019-11-02 21:00
 */
public class Test01pro {

    @Test
    public void test() {
        String str = "     bin  -  gai    ";

        String str1 = trimSpace(str);
        System.out.println(str1);

    }

    private String trimSpace(String str) {


        int start = 0;
        int end = str.length() - 1;
        while (start <= end && str.charAt(start) == ' '){
            start++;
        }
        while (start <= end && str.charAt(end) == ' '){
            end--;
        }

        String str1 = str.substring(start,end + 1);

        return str1;

    }

}
