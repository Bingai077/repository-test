package cn.bingai.practice01.demo02.chapter06_OOP3.test16;

public class Triangle extends Shape {
    private double length;
    private double width;
    private double height;

    public Triangle() {
    }

    public Triangle(String color, double length, double width, double height) {
        super(color);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public double celPerimeter() {
        return (length + width + height);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "length=" + length +
                ", width=" + width +
                ", height=" + height +
                "} " + super.toString();
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
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
