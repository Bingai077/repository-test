package cn.bingai.practice01.demo02.chapter10_EnumAndAnnotation.test01_Enum;

/**
 * 使用enum关键字定义枚举类
 * 说明:定义的枚举类默认继承于java.lang.Enum类
 * @author bingai
 * @create 2019-11-04 12:26
 */
public class SeasonTest1 {

    public static void main(String[] args) {
        Season1 autumn = Season1.AUTUMN;
        //toString()
        System.out.println(autumn.toString());//AUTUMN

        //System.out.println(Season1.class.getSuperclass());//class java.lang.Enum

        //values():
        Season1[] values = Season1.values();
        for (Season1 value : values) {
            System.out.println(value);
            value.show();
        }

        Thread.State[] values1 = Thread.State.values();
        for (Thread.State state : values1) {
            System.out.println(state);
        }

        //valueOf(String objName):返回枚举类中对象名是objName的对象
        //如果没有objName的枚举类对象，则抛异常：IllegalArgumentException
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);
        winter.show();

    }

}

interface Info{
    void show();
}



//自定义枚举类
enum  Season1 implements Info{

    //1.提供当前枚举类的对象，对个对象之间用“，”隔开，末尾对象“;”结束
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里？");
        }
    },
    SUMMER("夏天","夏日炎炎") {
        @Override
        public void show() {
            System.out.println("宁夏");
        }
    },
    AUTUMN("秋天","秋高气爽") {
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天","冰天雪地") {
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };

    //2.声明Season 对象的属性:private final修饰
    private final String seasonName;
    private final String seasonDesc;


    //3.私有化类的构造器

    private Season1(String seasonName, String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //4.其他诉求1：获取枚举类对象的属性

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

//    @Override
//    public String toString() {
//        return "Season1{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                "} " + super.toString();
//    }

//    @Override
//    public void show(){
//        System.out.println("这是一个季节");
//    }

}