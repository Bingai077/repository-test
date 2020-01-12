package cn.bingai.practice01.demo02.chapter06_OOP3.test17;

public class Person {
    private String name;
    private Vehicles veh;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Vehicles veh) {
        this.name = name;
        this.veh = veh;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", veh=" + veh +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicles getVeh() {
        return veh;
    }

    public void setVeh(Vehicles veh) {
        this.veh = veh;
    }
}
