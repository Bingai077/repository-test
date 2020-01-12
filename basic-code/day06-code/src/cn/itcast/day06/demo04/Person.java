package cn.itcast.day06.demo04;

/*
当方法的局部变量和成员变量重名的时候，根据“就近原则”，优先使用局部变量。
如果需要访问本类当中的成员变量，需要使用格式：

this.成员变量名

“通过谁调用的方法，谁就是this”

this作用：在重名的情况下起到区分的效果

 */
public class Person {

    String name;//我自己的姓名

    //参数name是自己的名字
    //成员变量name是自己的名字

    public void sayHello(String name){
        System.out.println(name + "你好。我是" + this.name);
        System.out.println(this);//cn.itcast.day06.demo04.Person@5594a1b5

    }

}
