package cn.bingai.practice01.demo02.chapter06_OOP3.test11;

public class Test {
    public static void main(String[] args) {
        Duckbill duckbill = new Duckbill();
        Sunflower sunflower = new Sunflower();
        duckbill.respirations();
        duckbill.run();
        sunflower.reproduction();
        sunflower.respirations();

    }
}
