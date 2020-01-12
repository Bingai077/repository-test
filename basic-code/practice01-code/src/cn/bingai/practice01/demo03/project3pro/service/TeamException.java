package cn.bingai.practice01.demo03.project3pro.service;
//自定义异常类
public class TeamException extends Exception {
    static final long serialVersionUID = 52L;

    public TeamException(){

    }

    public TeamException(String msg){
        super(msg);
    }

}
