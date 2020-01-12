package com.bingai.day24.demo09.ConstructorMethodReference;
/*
    定义一个创建Person对象的函数式接口
 */
@FunctionalInterface
public interface PersonBuilder {
    //定义一个方法，根据传递的姓名创建Person对象返回
    Person builderPerson(String name);

}
