package com.bingai.day24.demo07.SuperMethodReference;
/*
    定义子类
 */
public class Man  extends Human {
    //子类重写父类sayHello的方法

    @Override
    public void sayHello() {
        System.out.println("Hello,我是Man！");
    }

    //定义一个方法，参数传递Greetable接口
    public void method(Greetable g){
        g.greet();
    }

    public void show(){
        //调用method方法，方法的参数Greetable是一个函数式接口，所以可以传递Lambda表达式
        /*method(()->{
            //创建父类Human对象
            Human h = new Human();
            //调用父类的sayHello方法
            h.sayHello();
        });*/

        //因为有子父类关系，所以存在一个关键字super，所以我们可以直接使用super，调用父类成员方法
        //method(()-> super.sayHello());

        //优化Lambda表达式
        /*
            使用super引用父类的成员方法
            super是已经存在的
            父类的成员方法sayHello也是已经存在的
            所以我们可以直接使用super引用父类的成员方法
         */
        method(super::sayHello);
    }

    public static void main(String[] args) {
        new Man().show();
    }



}
