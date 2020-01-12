package com.bingai.day24.demo09.ConstructorMethodReference;

/*
    类的构造器(构造方法)引用
 */
public class Demo {
    //定义一个方法，参数传递姓名和personBuilder接口,方法中通过姓名创建Person对象
    public static void printName(String name, PersonBuilder pb) {
        Person person = pb.builderPerson(name);
        System.out.println(person.getName());
    }

    public static void main(String[] args) {//静态方法只能调用静态方法
        //调用printName方法，方法的参数PersonBuilder接口是一个函数式接口，所以可以传递Lambda表达式
        printName("bin", (String name) -> {
            return new Person(name);
        });
        //lambda简化
        printName("bingai", name -> new Person(name));

        /*
            使用方法引用优化Lambda表达式
            构造方法new Person(String name)已知
            创建对象已知 new
            就可以使用Person引用new创建对象
         */
        printName("斌改", Person::new);//使用Person类的带参构造方法，通过传递的姓名创建对象

    }


}
