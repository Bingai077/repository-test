package cn.bingai.practice01.demo02.chapter09_constantClass;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bingai
 * @create 2019-11-03 11:49
 */
public class Test11 {
    /*
        模拟一个trim方法，去除字符串两端的空格。
     */
    @Test
    public void test() {
        String str = "      bin-gai       ";
        String str1 = trimString(str);
        System.out.println(str1);
    }

    private String trimString(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end && str.charAt(start) == ' ') {
            start++;
        }
        while (start < end && str.charAt(end) == ' ') {
            end--;
        }
        return str.substring(start, end + 1);
    }

    /*
        将一个字符串进行反转。
        将字符串中指定部分进行反转。
        比如将“abcdefg”反转为”abfedcg”
     */
    @Test
    public void test1() {
        String str = "abcdefg";
        String str1 = reverseString(str, 2, 6);
        System.out.println(str1);
    }

    private String reverseString(String str, int start, int end) {
        String str1 = str.substring(start, end);
        StringBuffer sb = new StringBuffer(str1);

        String str2 = str.substring(0, start) + sb.reverse().toString() + str.substring(end, str.length());

        return str2;
    }


    /*
       拓展：I am a student!   写一个方法：实现输出 !student a am I
    */
    @Test
    public void test2() {
        String str = "I am a student! ";
        String str1 = reverseString1(str);
        System.out.println(str1);
    }

    private String reverseString1(String str) {
        String[] arr = str.split(" |!");
        System.out.println(Arrays.toString(arr));
        StringBuffer sb = new StringBuffer();
        sb.append("!");

        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i] + " ");
        }

        return sb.toString();
    }

    /*
      获取一个字符串在另一个字符串中出现的次数。
      判断str2在str1中出现的次数
   */
    @Test
    public void test3() {
        String str = "abbabababababababababababababababbababababab";
        String str1 = "ab";
        int count = countString(str, str1);
        System.out.println(count);
    }

    private int countString(String str, String str1) {
        if (str.length() >= str1.length()) {
            int count = 0;
            int index = 0;
            //int indexOf(String str,int fromIndex)：
            // 从fromIndex指定位置开始，获取str在字符串中出现的位置
            while ((index = str.indexOf(str1, index)) != -1) {
                index += str1.length();
                count++;
            }

            return count;
        } else {
            return 0;
        }

    }


    /*
      获取两个字符串中最大相同子串。
  */
    @Test
    public void test4() {
        String str = "abbabababababababababababababababbababababab";
        String str1 = "abababbbaabababababbbaabababababaabbbabbabababb";
        String str2 = maxCommonString(str, str1);
        System.out.println(str2);
    }

    //有一个最大子串
    private String maxCommonString(String str, String str1) {
        String maxStr = (str.length() >= str1.length()) ? str : str1;
        String minStr = (str.length() < str1.length()) ? str : str1;

        for (int i = 0; i < minStr.length(); i++) {

            for (int j = 0, k = minStr.length() - i; k <= minStr.length(); j++, k++) {

                String temp = minStr.substring(j, k);
                if (maxStr.contains(temp)) {
                    return temp;
                }

            }

        }
        return null;
    }


    // 如果存在多个长度相同的最大相同子串（数组解决方案）
    @Test
    public void test7() {
        String str = "abcdefghijklmnopqrstuvwxyz";
        String str1 = "abcdefmnopqruvwxyz";
        String[] strArr = maxCommonString1(str, str1);
        System.out.println(Arrays.toString(strArr));
    }

    private String[] maxCommonString1(String str, String str1) {
        if (str != null && str1 != null) {
            String strMin = str.length() <= str1.length() ? str : str1;
            String strMax = str.length() > str1.length() ? str : str1;
            StringBuilder sb = new StringBuilder();


            for (int i = 0; i < strMin.length(); i++) {

                for (int j = 0, k = strMin.length() - i; k <= strMin.length(); j++, k++) {
                    if (strMax.contains(strMin.substring(j, k))) {
                        sb.append(strMin.substring(j, k) + ",");
                    }
                }
                //System.out.println(sb);
                //if(strMax.contains(strMin.substring(j,k))){//错误
                if (sb.length() != 0) {
                    break;
                }
            }
            String[] split = sb.toString().split(",");
            return split;
        }
        return null;

    }


    // 如果存在多个长度相同的最大相同子串（集合解决方案）
    @Test
    public void test8() {
        String str = "abcdefghijklmnopqrstuvwxyz";
        String str1 = "abcdefmnopqruvwxyz";
        List<String> str2 = maxCommonString2(str, str1);
        System.out.println(str2);
    }

    private List<String> maxCommonString2(String str, String str1) {

        if (str != null && str1 != null) {
            String strMin = str.length() > str1.length() ? str1 : str;
            String strMax = str.length() > str1.length() ? str : str1;
            ArrayList<String> list = new ArrayList<>();

            int len = strMin.length();
            for (int i = 0; i < len; i++) {

                for (int j = 0, k = len - i; k <= len; j++, k++) {
                    String str2 = strMin.substring(j, k);
                    if (strMax.contains(str2)) {
                        list.add(str2);
                    }
                }
                if (list.size() != 0) {
                    break;
                }
            }
            return list;


        }
        return null;
    }


    /*
     对 字符串 中 字符 进行自然顺序排序
 */
    @Test
    public void test5() {

        String str = "shcxzjhh1554712xdaxHJSGHDV JD";
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        System.out.println(new String(chars));

    }


    /*
        中国有句俗语叫“三天打鱼两天晒网”。
        如果从1990年1月1日起开始执行“三天打鱼两天晒网”。
        如何判断在以后的某一天中是“打鱼”还是“晒网”？

     */
    @Test
    public void test6() {
/*
        //Duration:用于计算两个“时间”间隔，以秒和纳秒为基准
        LocalTime localTime = LocalTime.now();
        LocalTime localTime1 = LocalTime.of(15, 23, 32);
        //between():静态方法，返回Duration对象，表示两个时间的间隔
        Duration duration = Duration.between(localTime1, localTime);
        System.out.println(duration);
        System.out.println(duration.getSeconds());
        System.out.println(duration.getNano());
        LocalDateTime localDateTime = LocalDateTime.of(2016, 6, 12, 15, 23, 32);
        LocalDateTime localDateTime1 = LocalDateTime.of(2017, 6, 12, 15, 23, 32);
        Duration duration1 = Duration.between(localDateTime1, localDateTime);
        System.out.println(duration1.toDays());


        //Period:用于计算两个“日期”间隔，以年、月、日衡量
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = LocalDate.of(2028, 3, 18);
        Period period = Period.between(localDate, localDate1);
        System.out.println(period);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
        Period period1 = period.withYears(2);
        System.out.println(period1);*/


        LocalDateTime dateNow = LocalDateTime.now();
        System.out.println(dateNow);
        LocalDateTime date = LocalDateTime.of(1990, 1, 1, 0, 0, 0);
        System.out.println(date);

        Duration duration = Duration.between(date, dateNow);
        System.out.println(duration.toDays());
        int days = (int) duration.toDays();

        switch (days % 5) {
            case 0:
            case 4:
                System.out.println("打鱼");
                break;
            case 1:
            case 2:
            case 3:
                System.out.println("晒网");
                break;
        }


    }


}
