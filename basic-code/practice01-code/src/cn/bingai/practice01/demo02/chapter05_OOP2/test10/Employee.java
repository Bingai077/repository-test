package cn.bingai.practice01.demo02.chapter05_OOP2.test10;
/*
2）	Employee类中的属性有：办公室office（String类型），工资wage（double
类型），受雇日期hiredate（String类型）；
 */
public class Employee extends Person {
    private String office;
    private double wage;
    private String hiredate;

    public Employee() {
    }

    public Employee(String office, double wage, String hiredate) {
        this.office = office;
        this.wage = wage;
        this.hiredate = hiredate;
    }

    public Employee(String name, String address, String telephone, String email, String office, double wage, String hiredate) {
        super(name, address, telephone, email);
        this.office = office;
        this.wage = wage;
        this.hiredate = hiredate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "office='" + office + '\'' +
                ", wage=" + wage +
                ", hiredate='" + hiredate + '\'' +
                '}';
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }
}
