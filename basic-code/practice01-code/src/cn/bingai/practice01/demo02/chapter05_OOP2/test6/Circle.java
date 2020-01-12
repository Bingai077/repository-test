package cn.bingai.practice01.demo02.chapter05_OOP2.test6;

public class Circle extends GeometrlcObject {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, double weight, double radius) {
        super(color, weight);
        this.radius = radius;
    }

    public double findArea(){
        return Math.PI * radius *radius;
    }


    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
