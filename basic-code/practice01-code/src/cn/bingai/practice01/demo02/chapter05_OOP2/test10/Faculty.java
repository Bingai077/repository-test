package cn.bingai.practice01.demo02.chapter05_OOP2.test10;
/*
3）	Faculty类中的属性有：学位degree（String类型），级别level（String类型）；
 */
public class Faculty extends Employee {
    private String degree;
    private String level;

    public Faculty() {
    }

    public Faculty(String degree, String level) {
        this.degree = degree;
        this.level = level;
    }

    public Faculty(String office, double wage, String hiredate, String degree, String level) {
        super(office, wage, hiredate);
        this.degree = degree;
        this.level = level;
    }

    public Faculty(String name, String address, String telephone, String email, String office, double wage, String hiredate, String degree, String level) {
        super(name, address, telephone, email, office, wage, hiredate);
        this.degree = degree;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "degree='" + degree + '\'' +
                ", level='" + level + '\'' +
                '}';
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
