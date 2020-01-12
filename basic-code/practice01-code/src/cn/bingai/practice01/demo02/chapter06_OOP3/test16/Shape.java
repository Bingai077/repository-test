package cn.bingai.practice01.demo02.chapter06_OOP3.test16;

public abstract class Shape {

    private String color;

    public Shape() {
    }

    public Shape(String color) {
        this.color = color;
    }

    public abstract double celPerimeter();

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + color + '\'' +
                '}';
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
