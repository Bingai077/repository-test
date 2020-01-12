package cn.bingai.practice01.demo02.chapter05_OOP2.test10;
/*
3）	Faculty类中的属性有：学位degree（String类型），级别level（String类型）；
 */
public class Staff extends Employee{
    private String duty;

    public Staff() {
    }

    public Staff(String duty) {
        this.duty = duty;
    }

    public Staff(String office, double wage, String hiredate, String duty) {
        super(office, wage, hiredate);
        this.duty = duty;
    }

    public Staff(String name, String address, String telephone, String email, String office, double wage, String hiredate, String duty) {
        super(name, address, telephone, email, office, wage, hiredate);
        this.duty = duty;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "duty='" + duty + '\'' +
                '}';
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }
}
