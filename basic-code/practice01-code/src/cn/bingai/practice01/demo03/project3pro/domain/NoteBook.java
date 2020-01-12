package cn.bingai.practice01.demo03.project3pro.domain;

public class NoteBook implements Equipment {
    private String model;//机型
    private double price;//价格

    public NoteBook() {
    }

    public NoteBook(String model, double price) {
        this.model = model;
        this.price = price;
    }


    @Override
    public String getDescription() {
        return model + "(" + price + ")";
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
