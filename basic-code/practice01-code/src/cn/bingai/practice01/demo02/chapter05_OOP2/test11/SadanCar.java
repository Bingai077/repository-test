package cn.bingai.practice01.demo02.chapter05_OOP2.test11;

import java.util.Objects;

public class SadanCar extends Vehicle {
    private int loader;

    public SadanCar() {
    }

    public SadanCar(int loader) {
        this.loader = loader;
    }

    public SadanCar(int wheels, double weight, int loader) {
        super(wheels, weight);
        this.loader = loader;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SadanCar sadanCar = (SadanCar) o;
        return loader == sadanCar.loader;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), loader);
    }

    @Override
    public String toString() {
        return "SadanCar{" +
                "wheels=" + getWheels() +
                ", weight=" + getWeight() +
                ",loader=" + loader +
                '}';
    }

    public int getLoader() {
        return loader;
    }

    public void setLoader(int loader) {
        this.loader = loader;
    }
}
