package cn.bingai.practice01.demo02.chapter05_OOP2.test14;

class A {
    private int a;

    public void setA(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }
}

class B extends A {
    private int a;

    public void setA(int a) {
        this.a = a;
    }
     public int getA(){
     return a;
     }
}


public class Test2 {
    public static void main(String[] args) {
        A c = new B();

        c.setA(5);

        System.out.println(c.getA());//5
    }



}
