package cn.bingai.practice01.demo02.chapter07_Exception;
//ClassCastException 强制类型转换异常
public class Test9_ClassCastException {
    public static void main(String[] args) {
        Object x = new Integer(0);
        System.out.println(String.valueOf(x));
        try{
            System.out.println((String) x);
        }catch (ClassCastException e){
            System.out.println(e.getMessage());;
        }
    }
}
