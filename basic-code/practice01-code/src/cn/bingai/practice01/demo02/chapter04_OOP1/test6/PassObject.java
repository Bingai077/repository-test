package cn.bingai.practice01.demo02.chapter04_OOP1.test6;

/*
定义一个类PassObject， 在类中定义一个方法printAreas()， 该方法的定义
如下： public void printAreas(Circle c, int time)
在printAreas方法中打印输出1到time之间的每个整数半径值， 以及对应的面积。
例如， times为5， 则输出半径1， 2， 3， 4， 5， 以及对应的圆面积。
 */
public class PassObject {


    public void printAreas(Circle c, int time) {

        System.out.println("半径\t\t面积");
        for (int i = 1; i <= time; i++) {
            c.setRadius(i);
            System.out.println(c.getRadius() + "\t\t" + c.findArea(i));
        }

        c.setRadius(time + 1);
    }
}
