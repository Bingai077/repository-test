package cn.bingai.practice01.demo02.chapter10_EnumAndAnnotation.test03_EnumExperice;

/**创建星期枚举类，有7个枚举值，包含计划属性plan，为此属性赋值
 * @author bingai
 * @create 2019-11-05 8:57
 */
public class WeekTest1 {
    public static void main(String[] args) {

        Week monday = Enum.valueOf(Week.class, "MONDAY");

        monday.plan = "去上班";

        System.out.println(monday + monday.plan);
    }

}


enum Week{
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    public String plan;
}