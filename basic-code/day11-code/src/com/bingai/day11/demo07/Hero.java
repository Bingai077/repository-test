package com.bingai.day11.demo07;

public class Hero {

    private String name;//英雄的名称
    private Skill skill;//英雄的法术技能

    public Hero() {
    }

    public Hero(String name, Skill skill) {
        this.name = name;
        this.skill = skill;
    }

    public void atttack(){
        System.out.print(name + "使用了技能");
        skill.use();//调用接口抽象方法
        System.out.print("攻击了对方！！");
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
