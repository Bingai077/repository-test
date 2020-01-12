package cn.bingai.practice01.demo02.chapter05_OOP2.test12;

public class Test {
    public static void main(String[] args) {
        Employee e1 = new Employee("bingai", "1911082612", 15000);
        Employee e2 = new Manger("bin", "1811082622", 15000);
        double b1 = e1.bonus();
        System.out.println(b1);

        double b2 = e2.bonus();
        System.out.println(b2);


        double a = 2.0;
        double b = 2.0;
        Double c = 2.0;
        Double d = 2.0;
        System.out.println(a == b);//true
        System.out.println(c == d);//false
        System.out.println(a == d);//true

        Integer i1 = 128;
        Integer i2 = 128;
        int i3 = 128;
        int i4 = 128;
        System.out.println(i1 == i2);//false
        System.out.println(i3 == i4);//true
        System.out.println(i1 == i3);//true



    }
}
