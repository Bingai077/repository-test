package cn.bingai.practice01.demo02.chapter05_OOP2.test13;

import java.util.Objects;

/*
1）封装一个西游记人物类Person：包含私有属性：姓名（name）、身高（height）、武器（weapon）、种族（race），并提供访问器（get方法）和修改器（set方法）
2）	在测试类中实例化三个对象：tangseng（唐僧）、sunwukong（孙悟空）、baigujing（白骨精），分别设置他们的种族为：人族、仙族、妖族
3）	在打印对象时，按照例如：“姓名：孙悟空；种族：仙族”的格式在控制台输出信息。
4）	提供一个技能方法void skill()，这个方法根据当前对象name属性判断技能，如果是孙悟空，就打印“七十二变”，如果是唐僧，就打印“紧箍咒”，如果是白骨精，就打印“九阴白骨爪”，在测试类中调用这个方法。
5）	重写equals方法进行判断，如果种族属性是人族或者仙族，则返回true，如果是妖族，则返回false，在测试类中对孙悟空和唐僧进行比较，打印结果，对唐僧和白骨金进行比较，并打印结果。

 */
public class Person {
    private String name;
    private double height;
    private String weapon;
    private String race;

    public Person() {
    }

    public Person(String name, double height, String weapon, String race) {
        this.name = name;
        this.height = height;
        this.weapon = weapon;
        this.race = race;
    }

    public void skill() {
        if (name.equals("孙悟空")) {
            System.out.println("七十二变");
        }
        if (name.equals("唐僧")) {
            System.out.println("紧箍咒");
        }
        if (name.equals("白骨精")) {
            System.out.println("九阴白骨爪");
        }
    }



    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(race, person.race);
    }*/

    @Override
    public boolean equals(Object o) {
        Person person = (Person) o;
        return Objects.equals("人族", person.race) || Objects.equals("仙族", person.race);
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", race='" + race + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }
}
