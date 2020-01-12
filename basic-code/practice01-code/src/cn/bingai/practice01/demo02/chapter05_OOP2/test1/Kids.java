package cn.bingai.practice01.demo02.chapter05_OOP2.test1;
/*
定义类Kids继承ManKind，并包括
成员变量int yearsOld；
方法printAge()打印yearsOld的值。

在Kids中重新定义employeed()方
法，覆盖父类ManKind中定义的employeed()方法，输出“Kids
should study and no job.”
 */
public class Kids extends ManKind{

    private int yearOld;


    public Kids(int yearOld) {
        this.yearOld = yearOld;
    }

    public Kids(int sex, int salary, int yearOld) {
        super(sex, salary);
        this.yearOld = yearOld;
    }

    @Override
    public void employeed() {

        System.out.println("Kids should study and no job.");

    }


    public void printAge(){
        System.out.println(yearOld);
    }

    public int getYearOld() {
        return yearOld;
    }

    public void setYearOld(int yearOld) {
        this.yearOld = yearOld;
    }
}
