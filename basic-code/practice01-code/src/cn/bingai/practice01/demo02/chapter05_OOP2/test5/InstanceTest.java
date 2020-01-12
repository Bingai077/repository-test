package cn.bingai.practice01.demo02.chapter05_OOP2.test5;

/*
建立InstanceTest 类，在类中定义方法
method(Person e);
在method中:
    (1)根据e的类型调用相应类的getInfo()方法。
    (2)根据e的类型执行：
    如果e为Person类的对象， 输出：
    “a person”;
    如果e为Student类的对象， 输出：
    “a student”
    “a person ”
    如果e为Graduate类的对象，输出：
    “a graduated student”
    “a student”
    “a person”
 */
public class InstanceTest {
    public static void main(String[] args) {
        InstanceTest test = new InstanceTest();
        /*Person person1 = new Person();
        Person person2 = new Student();
        Person person3 = new Graduate();


        test2_exer.method(person1);
        System.out.println("===");
        test2_exer.method(person2);
        System.out.println("===");
        test2_exer.method(person3);*/

        test.method(new Person());
        System.out.println("===");
        test.method(new Student());
        System.out.println("===");
        test.method(new Graduate());



    }

    public void method(Person e) {
        /*if (e instanceof Person) {
            System.out.println(e.getInfo());
        } else if (e instanceof Student) {
            System.out.println(e.getInfo());
        } else if (e instanceof Graduate) {
            System.out.println(e.getInfo());
        }*/
        String info = e.getInfo();
        System.out.println(info);

        //方式一：
         if (e instanceof Graduate) {
            System.out.println("a graduated student");
             System.out.println("a student");
             System.out.println("a person");
         } else if (e instanceof Student) {
             System.out.println("a student");
             System.out.println("a person");
         } else  {
             System.out.println("a person");
        }

        //方式二：
       /* if (e instanceof Graduate) {
            System.out.println("a graduated student");
        }
        if (e instanceof Student) {
            System.out.println("a student");
        }
        if (e instanceof Person) {
            System.out.println("a person");
        }*/


    }

}
