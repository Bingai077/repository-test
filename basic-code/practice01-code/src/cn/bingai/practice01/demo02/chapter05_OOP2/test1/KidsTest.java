package cn.bingai.practice01.demo02.chapter05_OOP2.test1;
/*
 (1)定义一个ManKind类，包括
成员变量int sex和int salary；
方法void manOrWoman()：根据sex的值显示“man” (sex==1)或者“woman”(sex==0)；
方法void employeed()：根据salary的值显示“no job” (salary==0)或者“ job”(salary!=0)。
(2)定义类Kids继承ManKind，并包括
成员变量int yearsOld；
方法printAge()打印yearsOld的值。
(3)定义类KidsTest，在类的main方法中实例化Kids的对象someKid，用该对象访问
其父类的成员变量及方法。
 */
public class KidsTest {
    public static void main(String[] args) {
        Kids someKid = new Kids(16);

        someKid.printAge();

        someKid.setSalary(0);
        someKid.setSex(1);

        someKid.manOrWoman();
        someKid.employeed();

    }
}
