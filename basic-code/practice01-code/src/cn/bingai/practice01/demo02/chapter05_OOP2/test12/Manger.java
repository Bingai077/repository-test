package cn.bingai.practice01.demo02.chapter05_OOP2.test12;

public class Manger extends Employee {

    public Manger() {
    }

    public Manger(String name, String jobName, double salary) {
        super(name, jobName, salary);
    }

    @Override
    public double bonus() {
        return getSalary() * 2 ;
    }
}
