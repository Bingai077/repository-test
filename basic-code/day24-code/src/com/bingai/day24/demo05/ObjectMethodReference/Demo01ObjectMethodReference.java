package com.bingai.day24.demo05.ObjectMethodReference;

/*
    通过对象名引用成员方法
    使用前提是对象名是已经存在的，成员方法也是已经存在的
    就可以通过对象名来引用成员方法
 */
public class Demo01ObjectMethodReference {
    //定义一个方法，方法的参数传递printString接口
    public static void printString(Printable p) {
        p.print("Hello");
    }

    public static void main(String[] args) {
        //调用printString方法，方法的参数Printable是一个函数式接口，所以可以传递Lambda表达式
        printString(s -> {
            //创建MethodRefObject对象
            MethodRefObject obj = new MethodRefObject();
            //调用MethodRefObject对象中的成员方法printUppCaseString把字符串按照大写输出
            obj.printUppCaseString(s);

        });

        /*使用方法引用来优化Lambda
            对象是已经存在的MethodRefObject
            成员方法也是已经存在的printUppCaseString
            所以我们可以使用对象名引用成员方法
         */
        //创建MethodRefObject对象
        MethodRefObject obj = new MethodRefObject();
        printString(obj::printUppCaseString);//对象名::方法名


    }

}
