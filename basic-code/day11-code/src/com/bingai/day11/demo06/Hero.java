package com.bingai.day11.demo06;
//成员变量可以使用任何类型的数据
//游戏当中的英雄角色类

public class Hero {

    private String name;//英雄名字
    private int age;//英雄的年龄

    private Weapon weapon;//武器，类作为成员变量

    public Hero() {
    }

    public Hero(String name, int age, Weapon weapon) {
        this.name = name;
        this.age = age;
        this.weapon = weapon;
    }

    public void attack() {
        System.out.println("年龄为" + age + "的" + name + "正在用" + weapon.getCode() + "攻击敌方！！");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
