package cn.bingai.practice01.demo02.chapter04_OOP1.test10;

/*
另一个StudentTest类中的main方法中，创建Student对象，并访问say方法和所有属性，并将调用结果打印输出。
 */
public class StudentTest {
    public static void main(String[] args) {

        Student stu = new Student("斌改", "男", 26, 2016082612, 99);
        String s = stu.say();
        System.out.println(s);
    }
}
