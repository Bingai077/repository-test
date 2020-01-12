package cn.bingai.practice01.demo02.chapter05_OOP2.test11;

import java.util.Objects;

public class Truck extends SadanCar {
    private double payload;

    public Truck() {
    }

    public Truck(double payload) {
        this.payload = payload;
    }

    public Truck(int loader, double payload) {
        super(loader);
        this.payload = payload;
    }

    public Truck(int wheels, double weight, int loader, double payload) {
        super(wheels, weight, loader);
        this.payload = payload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Truck truck = (Truck) o;
        return Double.compare(truck.payload, payload) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), payload);
    }

    @Override
    public String toString() {
        return "Truck{" +
                "wheels=" + getWheels() +
                ", weight=" + getWeight() +
                ",loader=" + getLoader() +
                ",payload=" + payload +
                '}';
    }

    public double getPayload() {
        return payload;
    }

    public void setPayload(double payload) {
        this.payload = payload;
    }
}
