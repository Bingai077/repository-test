package cn.bingai.practice01.demo02.chapter06_OOP3.test19;

public class Computer {
    private  Graphoscope graph;

    public Graphoscope  product(String gra){
        if(gra.equalsIgnoreCase("DesktopDisplay")){
            return new DesktopDisplay();
        }else if(gra.equalsIgnoreCase("LiquidCrystalDisplay")){
            return new LiquidCrystalDisplay();
        }else{
            throw new RuntimeException("无法生产");
        }
    }


}
