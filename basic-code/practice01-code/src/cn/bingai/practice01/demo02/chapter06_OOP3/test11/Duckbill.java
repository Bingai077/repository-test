package cn.bingai.practice01.demo02.chapter06_OOP3.test11;

public class Duckbill implements Animal{

    public Duckbill() {
    }

    @Override
    public void respirations() {
        System.out.println("鸭嘴兽是动物，需要呼吸氧气");
    }

    @Override
    public void run() {
        System.out.println("鸭嘴兽只有两只脚，它可以用两只脚奔跑");
    }
}
