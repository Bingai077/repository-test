package cn.bingai.practice01.demo02.chapter10_EnumAndAnnotation.test03_EnumExperice;

/**创建星期枚举类，有7个枚举值，包含计划属性plan，为此属性赋值
 * @author bingai
 * @create 2019-11-05 8:57
 */
public class WeekTest2 {
    public static void main(String[] args) {

        System.out.println(Week1.MONDAY);

        Week1[] values = Week1.values();
        for (Week1 value : values) {
            System.out.println(value);
        }


    }

}


enum Week1{
    MONDAY("打球"),
    TUESDAY("看书"),
    WEDNESDAY("书法"),
    THURSDAY("练钢琴"),
    FRIDAY("跑步"),
    SATURDAY("义工"),
    SUNDAY("休息");

    private final String plan ;


    private Week1(String plan) {
        this.plan = plan;
    }


}