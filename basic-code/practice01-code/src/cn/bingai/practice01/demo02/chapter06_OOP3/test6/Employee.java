package cn.bingai.practice01.demo02.chapter06_OOP3.test6;

public abstract class Employee {

    private String name;
    private int number;
    private Mydate birthday;

    public Employee() {
    }

    public Employee(String name, int number, Mydate birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    public abstract double earnings();

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", birthday=" + birthday +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Mydate getBirthday() {
        return birthday;
    }

    public void setBirthday(Mydate birthday) {
        this.birthday = birthday;
    }
}
