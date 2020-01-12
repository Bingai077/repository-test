package cn.bingai.practice01.demo02.chapter05_OOP2.test13;

public class Test {
    public static void main(String[] args) {
        Person p1 = new Person("孙悟空", 188, "金箍棒", "仙族");
        Person p2 = new Person("唐僧",180,"咒语","人族");
        Person p3 = new Person("白骨精",1888,"爪子","妖族");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        p1.skill();
        p2.skill();
        p3.skill();

        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p3));
    }
}
