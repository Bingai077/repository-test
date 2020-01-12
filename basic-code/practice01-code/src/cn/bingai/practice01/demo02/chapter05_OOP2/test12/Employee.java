package cn.bingai.practice01.demo02.chapter05_OOP2.test12;

import java.util.Objects;

public class Employee {
    private String name;
    private String jobName;
    private double salary;

    public Employee() {
    }

    public Employee(String name, String jobName, double salary) {
        this.name = name;
        this.jobName = jobName;
        this.salary = salary;
    }

    public double bonus(){
        return salary * 1.5;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", jobName='" + jobName + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(name, employee.name) &&
                Objects.equals(jobName, employee.jobName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, jobName, salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
