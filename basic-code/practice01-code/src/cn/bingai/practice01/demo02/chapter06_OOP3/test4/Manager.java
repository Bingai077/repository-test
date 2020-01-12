package cn.bingai.practice01.demo02.chapter06_OOP3.test4;

public class Manager extends Employee{
    private double bonus;

    public Manager() {
    }

    public Manager(double bonus) {
        this.bonus = bonus;
    }

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("管理员工，提效");
    }


}
