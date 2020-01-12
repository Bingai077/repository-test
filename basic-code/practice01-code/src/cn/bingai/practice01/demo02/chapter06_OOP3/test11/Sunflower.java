package cn.bingai.practice01.demo02.chapter06_OOP3.test11;


public class Sunflower implements Spermatophyte {

    public Sunflower() {
    }

    @Override
    public void respirations() {
        System.out.println("太阳花是植物，可以吸收二氧化碳，呼出氧气");
    }

    @Override
    public void reproduction() {
        System.out.println("太阳花可以用种子繁殖，也可以用枝条繁殖");
    }
}
