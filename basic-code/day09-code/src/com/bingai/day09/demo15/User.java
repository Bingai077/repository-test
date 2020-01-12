package com.bingai.day09.demo15;

public class User {

    private String name;
    private int money;//余额

    public User() {
    }

    public User(String name, int money) {
        this.name = name;
        this.money = money;
    }

    //显示一下当前用户有多少钱
    public void show(){
        System.out.println("我叫：" + name + "我有多少钱：" + money);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
