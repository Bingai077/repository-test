package cn.bingai.practice01.demo02.chapter06_OOP3.test6;

public class SalariedEmployee extends Employee {
    private double monthlySalary;

    public SalariedEmployee() {
    }

    public SalariedEmployee(String name, int number, Mydate birthday, double monthlySalary) {
        super(name, number, birthday);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double earnings() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" + super.toString() + "} ";
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
}
