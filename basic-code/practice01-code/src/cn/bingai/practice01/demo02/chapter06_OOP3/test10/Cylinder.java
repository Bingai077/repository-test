package cn.bingai.practice01.demo02.chapter06_OOP3.test10;

public class Cylinder extends Circle {

    private double height;

    public Cylinder() {
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public double volume(){
        return PI * getRadius() *getRadius() * height;
    }

    @Override
    public double area() {
        System.out.println("底圆面积是：" + super.area());
        return (PI * getRadius() * getRadius() + 2 * PI * getRadius() * height);
    }


    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
