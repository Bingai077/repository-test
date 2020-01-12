package cn.bingai.practice01.demo02.chapter05_OOP2.test2;

import static java.lang.Math.PI;

public class Circle {
    private double radius;

    public Circle() {
        radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double findArae(double radius){
        return PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }



}
