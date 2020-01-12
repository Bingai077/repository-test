package cn.bingai.practice01.demo02.chapter06_OOP3.test19;

public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Graphoscope gra1 = computer.product("desktopDisplay");
        Graphoscope gra2 = computer.product("LiquidCrystalDisplay");
        gra1.play();
        gra2.play();
    }
}
