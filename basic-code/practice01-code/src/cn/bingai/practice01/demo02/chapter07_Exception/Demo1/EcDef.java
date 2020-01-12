package cn.bingai.practice01.demo02.chapter07_Exception.Demo1;

public class EcDef extends Exception {

    static final long serialVersionUID = 520L;

    public EcDef(){

    }

    public EcDef(String msg){
        super(msg);
    }


}
