package com.bingai.day16.demo02.Exception;

import java.io.IOException;

/*
    try...catch：异常处理的第二种方式
    格式：
        try{
            可能产生异常的代码
        }catch(定义一个异常的变量，用来接收try中抛出的异常对象){
            异常的处理逻辑，产生异常对象后，怎么处理异常对象
            一般工作中，会把异常信息记录到一个日志中
        }
        ...
        catch(异常类名 变量名){

        }
    注意：
        1.try中可能会抛出多个异常对象，那么就可以使用多个catch来处理这些异常对象
        2.如果try中产生了异常，那么就会执行catch中的异常处理逻辑，执行完毕catch中的处理逻辑，继续执行try...catch之后的代码
          如果try中没有产生异常，那么就不会执行catch中异常的处理逻辑，执行完try中的代码，继续执行try...catch之后的代码

 */
public class Demo01TryCatch {
    public static void main(String[] args) {
        try{
            //尽可能产生异常的代码
            readFile("c:\\a.tdt");
            System.out.println("资源释放");
        }catch(IOException e){
            System.out.println(e);//try中抛出什么异常对象，catch就定义什么异常变量，用来接收这个异常对象
            System.out.println(e.getMessage());//文件的后缀名不对
            System.out.println(e.toString());//java.io.IOException: 文件的后缀名不对,重写了Object类的toString方法
            e.printStackTrace();//
            /* java.io.IOException: 文件的后缀名不对
            at com.bingai.day16.demo02.Exception.Demo01TryCatch.readFile(Demo01TryCatch.java:57)
            at com.bingai.day16.demo02.Exception.Demo01TryCatch.main(Demo01TryCatch.java:28)
        */
        }

        System.out.println("后续代码");

        /*
            Throwable中定义了三个处理异常的方法
            public String getMessage() :获取异常的描述简短信息,原因，提示给用户的时候,就提示错误原因。
            public String toString() :获取异常的类型和异常描述的详细信息(一般不用)。
            public void printStackTrace() :打印异常的跟踪栈信息并输出到控制台，打印的异常信息是最全面的
         */




    }

    public static void readFile(String fileName) throws IOException {

        /*
            如果传递的路径不是.txt结尾
            那么我们就抛出IO异常对象，告知方法的调用者，文件的后缀名不对
         */
        if(!fileName.endsWith(".txt")){
            throw new IOException("文件的后缀名不对");
        }
        System.out.println("路径没有问题，读取文件");
    }

}
