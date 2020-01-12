package cn.bingai.practice01.demo02.chapter05_OOP2.test14;

public class Test1 {

    public static void main(String[] args) {
        Base b1 = new Base();//base : 100
        Base b2 = new Sub();//sub : 100//base : 70//父方法被调用一次，也需执行

    }
}
class Base{
    Base(){
        method(100);
    }
    public void method(int i){
        System.out.println("base : " + i);
    }
}
class Sub extends Base{
    Sub(){
        super.method(70);
    }
    public void method(int j){
        System.out.println("sub : " + j);
    }
}
