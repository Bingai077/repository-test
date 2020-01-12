package cn.bingai.practice01.demo02.chapter05_OOP2.test11;

import java.util.Objects;

public class Vehicle {
    private int wheels;
    private double weight;

    public Vehicle() {
    }

    public Vehicle(int wheels, double weight) {
        this.wheels = wheels;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return wheels == vehicle.wheels &&
                Double.compare(vehicle.weight, weight) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(wheels, weight);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "wheels=" + wheels +
                ", weight=" + weight +
                '}';
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
