package com.bingai.day11.demo01;
/*
对于成员变量来说，如果使用final关键字来修饰，那么这个变量也照样不变。

1.由于变量具有默认值，用了final之后必须手动赋值，不再给默认值

2.对于final的成员变量，要么使用直接赋值，要么通过构造方法赋值。二者选其一。

3.必须保证类当中所有的重载方法，都最终会对final的成员变量赋值。
 */
public class Person {

    private final String name /*= "斌改"*/;

    public Person(){
        name = "斌";
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //不能再对name赋值
//    public void setName(String name) {
//        this.name = name;
//    }
}
