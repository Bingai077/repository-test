package com.bingai.day10.demo06;
/*
【向上转型】一定是安全的，没问题的，正确的。但是也有一个弊端。
对象一旦向上转型为父类，就无法调用子类原本特有的内容。

解决方案：用对象的【向下转型】【还原】

 */
public class Demo01Main {
    public static void main(String[] args) {
        //对象的【向上转型】就是：父类引用指向子类对象。

        Animal animal = new Cat();//本来创建的时候是一只猫
        animal.eat();


//        animal.catchMouse();//错误写法！调用不了

        //向下转型，进行【还原】动作
        Cat cat = (Cat) animal;
        cat.catchMouse();//猫抓老鼠

        //错误的向下转型
        //本来new的时候是一只猫，现在非要当做狗
        Dog dog = (Dog) animal;//编译通过，运行异常：ClassCastException,类转换异常
        //java.lang.ClassCastException




    }
}
