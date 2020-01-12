package cn.bingai.practice01.demo03.project3pro.domain;

public class Architect extends Designer {
    private int stock;//公司奖励的股票数量

    public Architect() {
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }



    @Override
    public String getDetailsForTeam() {
        return  getTeamBaseDetails() + "  \t" + "架构师" + " \t" + getBonus() + " \t" + stock ;
    }

    @Override
    public String toString() {
        return getDetails() + "  \t" + "架构师" + " \t" + getStatus() + "\t" + getBonus() + "\t" + stock + "\t" + getEquipment().getDescription();

    }
}
