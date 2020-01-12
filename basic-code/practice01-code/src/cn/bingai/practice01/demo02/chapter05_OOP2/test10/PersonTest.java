package cn.bingai.practice01.demo02.chapter05_OOP2.test10;
/*
5）	现有对象Person p1 =new Faculty()和Person p2 =new Staff ()，
    请分别为p1的属性赋值“本科”和Staff类的duty赋值“职员”

 */
public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Faculty("本科","副高");
        System.out.println(p1);

        Person p2 = new Staff("职员");
        System.out.println(p2);

    }

}
