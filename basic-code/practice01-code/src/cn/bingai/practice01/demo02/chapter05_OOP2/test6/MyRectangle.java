package cn.bingai.practice01.demo02.chapter05_OOP2.test6;

public class MyRectangle extends GeometrlcObject {

    private double width;
    private double height;

    public MyRectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public MyRectangle(String color, double weight, double width, double height) {
        super(color, weight);
        this.width = width;
        this.height = height;
    }

    @Override
    public double findArea(){
        return width * height;
    }


    @Override
    public String toString() {
        return "MyRectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
