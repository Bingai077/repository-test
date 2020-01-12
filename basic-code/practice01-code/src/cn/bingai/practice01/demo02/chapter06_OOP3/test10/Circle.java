package cn.bingai.practice01.demo02.chapter06_OOP3.test10;

public class Circle implements Shape {

    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return PI * radius * radius;
    }

    public double perimeter(){
        return 2 * PI * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
