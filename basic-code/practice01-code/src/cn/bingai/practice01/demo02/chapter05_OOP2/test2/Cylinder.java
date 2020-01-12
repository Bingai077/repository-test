package cn.bingai.practice01.demo02.chapter05_OOP2.test2;

import static java.lang.Math.PI;

public class Cylinder extends Circle{
    private double length;

    public Cylinder() {
        length = 1.0;
    }

    public Cylinder(double length) {
        this.length = length;
    }

    @Override
    public double findArae(double radius){//返回圆柱的面积
        return PI * radius * radius + 2 * PI * radius * length;
    }

    public double findVolume( double r){
        return length * super.findArae(r);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }


}
