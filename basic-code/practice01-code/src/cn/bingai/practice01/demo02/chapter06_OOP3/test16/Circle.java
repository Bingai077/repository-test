package cn.bingai.practice01.demo02.chapter06_OOP3.test16;

public class Circle extends Shape {

    private double radius;

    public Circle() {
    }

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double celPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                "} " + super.toString();
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
