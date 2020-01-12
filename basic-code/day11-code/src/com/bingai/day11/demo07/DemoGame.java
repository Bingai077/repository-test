package com.bingai.day11.demo07;

public class DemoGame {

    public static void main(String[] args) {
        Hero hero = new Hero();
        hero.setName("诸葛亮");//设置英雄名称

        //设置英雄技能，使用单独定义的实现类
        Skill skill = new SkillImpl();
        hero.setSkill(skill);
        hero.atttack();
        System.out.println("             ");
        System.out.println("=============");

        //使用匿名对象
        hero.setSkill(new SkillImpl());
        hero.atttack();
        System.out.println("             ");
        System.out.println("=============");

        //使用匿名内部类
        Skill skill1 = new Skill() {
            @Override
            public void use() {
                System.out.print("“五行八卦，乌云骤起”");
            }
        };
        hero.setSkill(skill1);
        hero.atttack();
        System.out.println("             ");
        System.out.println("=============");


        //同时使用匿名对象和匿名内部类
        hero.setSkill(new Skill() {
            public void use() {
                System.out.print("“瞒天过海，暗度陈仓”");
            }
        });
        hero.atttack();


    }

}
