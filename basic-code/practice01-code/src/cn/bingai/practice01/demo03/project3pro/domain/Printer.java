package cn.bingai.practice01.demo03.project3pro.domain;

public class Printer implements Equipment {

    private String name;
    private String type;

    public Printer() {
    }

    public Printer(String name, String type) {
        this.name = name;//机型
        this.type = type;//机器类型
    }

    @Override
    public String getDescription() {
        return name + "(" + type + ")";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
