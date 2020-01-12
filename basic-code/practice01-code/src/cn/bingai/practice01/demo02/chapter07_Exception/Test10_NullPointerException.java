package cn.bingai.practice01.demo02.chapter07_Exception;
//NullPointerException 空指针异常
public class Test10_NullPointerException {
    public static void main(String[] args) {
        try{
            String name = null;
            System.out.println(name.equals("斌改"));

        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }
}
