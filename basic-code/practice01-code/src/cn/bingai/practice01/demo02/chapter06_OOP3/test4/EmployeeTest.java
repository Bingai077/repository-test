package cn.bingai.practice01.demo02.chapter06_OOP3.test4;

public class EmployeeTest {
    public static void main(String[] args) {
        CommonEmployee ce = new CommonEmployee();
        Manager manager = new Manager("库克",1001,5000,50000);
        manager.work();

        ce.work();
    }
}
