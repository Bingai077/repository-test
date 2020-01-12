package cn.bingai.practice01.demo03.project3pro.service;
//表示员工的三种状态
//public class Status {
//    private final String NAME;//私有的，不能改变的
//
//    private Status(String NAME) {//构造器私有化，外面不能造对象
//        this.NAME = NAME;
//    }
//
//    public static final Status FREE = new Status("FREE");
//    public static final Status VOCATION = new Status("VOCATION");
//    public static final Status BUSY = new Status("BUSY");
//
//    @Override
//    public String toString() {
//        return  NAME ;
//    }
//
//    public String getNAME() {
//        return NAME;
//    }
//
//}

public enum Status{
    FREE,BUSY,VOCATION;

}