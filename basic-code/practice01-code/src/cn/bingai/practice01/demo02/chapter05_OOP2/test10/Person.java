package cn.bingai.practice01.demo02.chapter05_OOP2.test10;
/*
实现一个名为Person的类和它的子类Employee，Employee有两个子类Faculty和Staff。
1）	Person类中的属性有：姓名name（String类型），地址address（String类型），
电话号码telphone（String类型）和电子邮件地址email（String类型）；

 */
public class Person {

    private String name;
    private String address;
    private String telephone;
    private String email;

    public Person() {
    }

    public Person(String name, String address, String telephone, String email) {
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
