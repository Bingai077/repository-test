package cn.bingai.practice01.demo03.project3pro.domain;

import cn.bingai.practice01.demo03.project3pro.service.Status;

public class Programmer extends Employee{
    private int MemberId;//加了开发团队后的ID
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer() {
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }


    @Override
    public String toString() {
        return getDetails() + "  \t" + "程序员" +" \t" + status + "\t\t\t\t\t" + equipment.getDescription();
    }

    public String getTeamBaseDetails(){
        return MemberId + "/" + getId() + " \t" + getName() + " \t" + getAge() + "\t" + getSalary();
    }

    public String getDetailsForTeam() {
        return getTeamBaseDetails() + "  \t" + "程序员";
    }

    public int getMemberId() {
        return MemberId;
    }

    public void setMemberId(int memberId) {
        this.MemberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
