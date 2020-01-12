package cn.bingai.practice01.demo02.chapter07_Exception;

/*
    如何自定义异常类？
    1.继承于现有的异常结构：RuntimeException / Exception
    2.提供全局常量：serialVersionUID
    3.提供重载的构造器

 */
class Test4_MyException extends RuntimeException {

    static final long serialVersionUID = -48L;//序列号，标识

    public Test4_MyException() {

    }

    public Test4_MyException(String msg) {
        super(msg);
    }

}




