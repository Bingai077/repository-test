package cn.bingai.practice01.demo02.chapter15_Reflection.Test2_allConstructor;

import java.io.Serializable;

/**
 * @author bingai
 * @create 2019-11-13 19:15
 */
public class Creature<T> implements Serializable{
    private char gender;
    public double weight;

    public void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }




}
