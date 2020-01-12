package cn.bingai.practice01.demo02.chapter04_OOP1.test6;

import static java.lang.Math.PI;

/*
定义一个Circle类， 包含一个double型的radius属性代表圆的半径， 一个
findArea()方法返回圆的面积。
 */
public class Circle {
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double findArea(double r){
        return PI * r * r;
    }



    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
