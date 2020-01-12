package cn.bingai.practice01.demo02.chapter06_OOP3.test6;

public class HourlyEmployee extends Employee {

    private double wage;
    private double hour;

    public HourlyEmployee() {
    }

    public HourlyEmployee(String name, int number, Mydate birthday, double wage, double hour) {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }


    @Override
    public double earnings() {
        return wage * hour;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" + super.toString()  + "} " ;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }
}
