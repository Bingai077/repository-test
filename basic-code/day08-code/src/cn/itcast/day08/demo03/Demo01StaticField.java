package cn.itcast.day08.demo03;
/*
如果一个成员变量使用了static关键字，那么这个对象不在属于自己，而是属于所在的类。
多个对象共享同一份数据。

 */
public class Demo01StaticField {
    public static void main(String[] args) {

        Student one = new Student("陈",18);
        one.room = "101教室";
        Student two = new Student("斌",19);
        System.out.println("姓名：" + one.getName()
                + ",年龄：" + one.getAge() + "，教室：" + one.room
                +",学号：" + one.getId());
        System.out.println("姓名：" + two.getName()
                + ",年龄：" + two.getAge() + "，教室：" + two.room
                +",学号：" + two.getId());

    }

}
