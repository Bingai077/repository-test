package com.bingai.day12.exam01;

public class Test02 {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1.equals(s2));//true


        Student stu1 = new Student("斌改",23);
        Student stu2 = new Student("斌改",23);
//        System.out.println(stu1.equals(stu2));//false，重写前

        //认为同姓名同年龄的就是同一个人
        System.out.println(stu1.equals(stu2));//true，重写后

    }
}
