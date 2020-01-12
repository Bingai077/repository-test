package com.bingai.day14.demo03.hashCode;

import java.sql.SQLOutput;

/*
    哈希值：是一个十进制的整数，由系统随机给出(就是对象的地址值，是一个逻辑地址，是模拟出来得到的地址，不是数据实际存储的物理地址)
    在Object类中有一个方法，可以获取对象的hash值
    int hashCode()   返回该对象的哈希码值。
    hashCode()方法的源码：
         public native int hashCode();
         native:代表该方法调用的是本地系统的方法

 */
public class Demo01HashCode {
    public static void main(String[] args) {
        //Person类继承了Object类，所以可以使用Object类的hashCode方法
        Person person = new Person();
        int i = person.hashCode();
        System.out.println(i);//717356484
        Person person1 = new Person();
        System.out.println(person1.hashCode());//1595212853
    /*
        toString()方法的源码：
             public String toString() {
                   return getClass().getName() + "@" + Integer.toHexString(hashCode());
             }
     */
        System.out.println(person);//com.bingai.day14.demo03.hashCode.Person@2ac1fdc4 (十六进制)//和71735648(十进制)相同//1
        System.out.println(person1);//com.bingai.day14.demo03.hashCode.Person@5f150435//1
        System.out.println(person == person1);//false

        /*
            String类的哈希值
                String类重写了Object类的hashCode()方法

         */
        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1.hashCode());//96354
        System.out.println(s2.hashCode());//96354

        System.out.println("重地".hashCode());//1179395
        System.out.println("通话".hashCode());//1179395




    }


}
