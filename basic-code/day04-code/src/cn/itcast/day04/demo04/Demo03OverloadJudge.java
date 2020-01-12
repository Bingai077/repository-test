package cn.itcast.day04.demo04;

public class Demo03OverloadJudge {

    public static void open(){}//正确重载
    public static void open(int a){}//正确重载
//    static void open(int a,int b){}
    public static void open(double a,int b){}//正确重载
//    public static void open(int a,double b){}
//    public void open(int i,double d){}
    public static void OPEN(){}//不是重载
    public static void open(int i,int j){}


}
