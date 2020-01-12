package cn.bingai.practice01.demo02.chapter07_Exception;
/*
ArithmeticException 算术异常
 */
public class Test6_ArithmeticException {

    public static void main(String[] args) {

        double a = 1.0;
        System.out.println(a / 0);//Infinity
        for (int i = 10; i > 0; i--) {
            try{
                System.out.println(" " + (i / (i - 1)));
            }catch (ArithmeticException e){
                System.out.println("出现异常为：" + e.getMessage());
            }
        }

        System.out.println("结束ending");
    }
}


