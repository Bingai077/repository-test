package cn.bingai.practice01.demo02.chapter06_OOP3.test14;

public class Test2 {
    public static void main(String[] args) {
        A a = new A();
        A.B b = a.new B();
        b.show();
    }
}

class A{

    class B{
        public static final String name = "bingai";

        public void show(){
            System.out.println(name);
        }
    }
}