package cn.bingai.practice01.demo02.chapter09_constantClass;

import org.junit.Test;

import java.util.Arrays;

/**
 * 对字符串中字符进行自然顺序排序。
 提示：
 1）字符串变成字符数组。
 2）对数组排序，选择，冒泡， Arrays.sort();
 3）将排序后的数组变成字符串。
 * @author bingai
 * @create 2019-11-03 10:22
 */
public class Test05pro {
    @Test
    public void test(){
        String str = "shuhhcjsjgdeyuwjgcb215548524186274582";

        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        System.out.println(new String(chars));


    }
}
