package cn.bingai.practice01.demo03.project3pro.domain;

public class Designer extends Programmer{
    private double bonus;//奖金

    public Designer() {
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    @Override
    public String getDetailsForTeam() {
        return getTeamBaseDetails() + "  \t" + "设计师" + " \t" + bonus ;
    }

    @Override
    public String toString() {
        return getDetails() + "  \t" + "设计师" + " \t" + getStatus() + "\t" + bonus + "\t\t\t" + getEquipment().getDescription();
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
