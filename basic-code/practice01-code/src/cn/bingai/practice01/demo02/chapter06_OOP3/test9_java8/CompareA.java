package cn.bingai.practice01.demo02.chapter06_OOP3.test9_java8;
/*
    JDK8:除了定义全局常量和抽象方法外，还可以定义静态方法、默认方法
 */
public interface CompareA {

    //静态方法
    public static void method1(){
        System.out.println("CompareA：杭州");
    }

    //默认方法
    public default void method2(){
        System.out.println("CompareA：宁波");
    }

    default void method3(){
        System.out.println("CompareA：宁波");
    }
}
