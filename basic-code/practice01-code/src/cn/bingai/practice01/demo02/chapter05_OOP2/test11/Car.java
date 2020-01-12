package cn.bingai.practice01.demo02.chapter05_OOP2.test11;

import java.util.Objects;

public class Car {
    private String color;
    private String type;

    public Car() {
    }

    public Car(String color, String type) {
        this.color = color;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(color, car.color) &&
                Objects.equals(type, car.type);
    }

    @Override
    public int hashCode() {

        return Objects.hash(color, type);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
