package com.bingai.day10.demo05;
/*
访问成员变量的两种方式：
1.直接通过【对象名称】访问成员变量：看等号左边是谁，优先用谁，没有则向上找。
2.间接通过【成员方法】访问成员变量：看该方法属于谁，优先用谁，没有则向上找。


 */
public class Demo01MultiField {
    public static void main(String[] args) {
        //使用多态的写法，父类引用指向子类对象
        Fu obj = new Zi();
        System.out.println(obj.num);//10
//        System.out.println(obj.age);//error,向上找
        System.out.println("===============");

        //子类没有覆盖重写，就是父，
        //子类如果覆盖重写，就是子。
        //  obj.showNum();//10,子类没有覆盖重写，就是父类中的10
        obj.showNum();//20,子类覆盖重写，就是子类中的20

    }

}
