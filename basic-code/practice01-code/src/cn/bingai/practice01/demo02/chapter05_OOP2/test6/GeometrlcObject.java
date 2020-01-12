package cn.bingai.practice01.demo02.chapter05_OOP2.test6;

public class GeometrlcObject {
    protected String color;
    protected double weight;

    public GeometrlcObject() {
    }

    public GeometrlcObject(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public double findArea(){
        return 0.0;//几何图形求不了面积
    }

    @Override
    public String toString() {
        return "GeometrlcObject{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
