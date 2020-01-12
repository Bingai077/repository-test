package com.bingai.day11.demo06;

public class DemoMain {
    public static void main(String[] args) {
        //创建一个英雄角色
        Hero hero = new Hero();
        //为英雄起一个名字，并且设置年龄
        hero.setAge(20);
        hero.setName("关羽");

        //创建一个武器对象
        Weapon weapon = new Weapon("青龙偃月刀");
        //为英雄配备武器
        hero.setWeapon(weapon);

        hero.attack();//年龄为20的关羽正在用青龙偃月刀攻击敌方！！
    }


}
