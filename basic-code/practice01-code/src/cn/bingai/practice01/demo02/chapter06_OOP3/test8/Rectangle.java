package cn.bingai.practice01.demo02.chapter06_OOP3.test8;

public class Rectangle {
    private Double length;
    private Double width;

    public Rectangle() {
    }

    public Rectangle(Double length, Double width) {
        this.length = length;
        this.width = width;
    }

    public Double getArea() {
        return length * width;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }
}
