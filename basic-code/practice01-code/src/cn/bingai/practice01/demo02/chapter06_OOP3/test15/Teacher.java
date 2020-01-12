package cn.bingai.practice01.demo02.chapter06_OOP3.test15;

public class Teacher extends Person {

    public Teacher() {
    }

    public Teacher(String name, int age, String sex) {
        super(name, age, sex);
    }

    @Override
    public void work() {
        System.out.println("教书育人");
    }

    @Override
    public void hello() {
        System.out.println("同学好");
    }

    @Override
    public String toString() {
        return "Teacher{} " + super.toString();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    @Override
    public String getSex() {
        return super.getSex();
    }

    @Override
    public void setSex(String sex) {
        super.setSex(sex);
    }
}
