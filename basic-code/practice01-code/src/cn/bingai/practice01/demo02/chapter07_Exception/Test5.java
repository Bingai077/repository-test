package cn.bingai.practice01.demo02.chapter07_Exception;

public class Test5 {
    static void methodA() {
        try {
            System.out.println("进入方法A");//第一步
            throw new RuntimeException("制造异常");//第三步
        }finally {
            System.out.println("用A方法的finally");//第二步
        }
    }
    static void methodB() {
        try {
            System.out.println("进入方法B");//第一步
            return;
        } finally {
            System.out.println("调用B方法的finally");//第二步
        }
    }
    public static void main(String[] args) {
        try {
            methodA();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        methodB();
    }

}
