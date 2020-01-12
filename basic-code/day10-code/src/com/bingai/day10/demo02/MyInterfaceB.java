package com.bingai.day10.demo02;

public interface MyInterfaceB {



    public abstract void methodB();

    public abstract void methodAbs();

    public default void methoddefault(){
        System.out.println("默认方法BBB");
    }




}
