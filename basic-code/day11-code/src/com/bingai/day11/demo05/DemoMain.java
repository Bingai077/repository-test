package com.bingai.day11.demo05;
/*
如果接口的实现类，或者是接口的子类，只需要使用唯一的一次。
那么这种情况下就可以省略掉该类的定义，而改为使用【匿名内部类】。

匿名内部类的定义格式：
接口名称 对象名 = new 接口名称(){
    //覆盖重写所有抽象方法
};

对格式“new 接口名称(){...}”进行解析：
1.new代表创建对象的动作
2.接口名称就是匿名内部类需要实现的接口
3.{...}这才是匿名内部类的内容

另外还要注意几点问题：
1.匿名内部类，在【创建对象】的时候，只能使用一次
如果希望【多次创建对象】，而且类的内容一样的话，那么就必须使用【单独定义】的实现类了。
2.匿名对象，在【调用方法】的时候，只能调用唯一一次。
如果希望是同一个对象，【调用多次方法】，那么必须给【对象】起一个名字。
3.【匿名内部类】是省略了【实现类/子类名称】，但【匿名对象】是省略了【对象名称】
 强调：匿名内部类和匿名对象不是一回事！
 */
public class DemoMain {
    public static void main(String[] args) {
//        MyInterface obj = new MyInterfaceImpl();
//        obj.method();

//        MyInterface some = new MyInterface();//错误写法，抽象类

        //使用匿名内部类,但不是匿名对象，对象名称就叫obj
        MyInterface obj = new MyInterface() {//只是匿名内部类
            @Override
            public void method1() {
                System.out.println("匿名内部类实现了方法！111");
            }
            public void method2() {
                System.out.println("匿名内部类实现了方法！222");
            }
        };

        obj.method1();//匿名内部类实现了方法
        obj.method2();

        System.out.println("==================");

        //使用了匿名内部类，而且省略了对象名称，也是匿名对象
         new MyInterface() {//既是匿名内部类，也是匿名对象
            @Override
            public void method1() {
                System.out.println("匿名内部类实现了方法！111-2");
            }
            public void method2() {
                System.out.println("匿名内部类实现了方法！222-2");
            }
        }.method1();
//        }.method1().method2();//把method1的返回值作为对象来调用method2

        //因为匿名对象无法调用第二次方法，所以需要再创建一个匿名内部类的匿名对象
        new MyInterface() {
            @Override
            public void method1() {
                System.out.println("匿名内部类实现了方法！111-2");
            }
            public void method2() {
                System.out.println("匿名内部类实现了方法！222-2");
            }
        }.method2();

//        obj1.method1();//匿名内部类实现了方法
//        obj1.method2();
    }

}
