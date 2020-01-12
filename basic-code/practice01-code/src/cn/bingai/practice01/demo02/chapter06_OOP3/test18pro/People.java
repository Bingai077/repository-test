package cn.bingai.practice01.demo02.chapter06_OOP3.test18pro;

public class People {
    public static void main(String[] args) throws Exception {
        FruitGardener fg = new FruitGardener();
        Fruit apple = fg.getFruit("apple");
        apple.plant();
        apple.grow();
        apple.harvest();

        Fruit stuawberry = fg.getFruit("stuawberry");
        stuawberry.plant();
        stuawberry.grow();
        stuawberry.harvest();

        Fruit grape = fg.getFruit("grape");
        grape.plant();
        grape.grow();
        grape.harvest();
    }
}
