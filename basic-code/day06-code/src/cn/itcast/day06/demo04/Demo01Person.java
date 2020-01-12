package cn.itcast.day06.demo04;

public class Demo01Person {
    public static void main(String[] args) {
        Person person = new Person();
        //设置我自己的名字
        person.name = "陈斌杰";
        person.sayHello("王思聪");

        System.out.println(person);//cn.itcast.day06.demo04.Person@5594a1b5
    }

}
