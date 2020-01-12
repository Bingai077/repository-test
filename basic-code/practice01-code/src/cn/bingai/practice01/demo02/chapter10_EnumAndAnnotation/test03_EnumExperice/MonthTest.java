package cn.bingai.practice01.demo02.chapter10_EnumAndAnnotation.test03_EnumExperice;

/**创建月份枚举类，枚举值包含十二个月份，月份要求用英文单词
 * @author bingai
 * @create 2019-11-05 8:52
 */

public class MonthTest{
    public static void main(String[] args) {
        System.out.println(Month.valueOf("SEPT"));

        Month[] months = Month.values();
        for (Month month : months) {
            System.out.println(month);
        }
    }
}


enum Month {
    JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEPT, OCT, NOV, DEC;
}
