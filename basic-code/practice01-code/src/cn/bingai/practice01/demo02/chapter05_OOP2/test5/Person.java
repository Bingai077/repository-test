package cn.bingai.practice01.demo02.chapter05_OOP2.test5;

class Person {
    protected String name = "person";
    protected int age = 50;

    public String getInfo() {
        return "Name: " + name + "\n" + "age: " + age;
    }
}