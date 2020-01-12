package cn.bingai.practice01.demo02.chapter06_OOP3.test15;

public class TestPerson {
    public static void main(String[] args) {
        Person p1 = new Teacher("张老师",42,"女");
        Person p2 = new Student("斌改",18,"男");
        p1.work();
        p1.hello();
        System.out.println(p1.toString());
        p2.work();
        p2.hello();
        System.out.println(p2.toString());
    }
}
