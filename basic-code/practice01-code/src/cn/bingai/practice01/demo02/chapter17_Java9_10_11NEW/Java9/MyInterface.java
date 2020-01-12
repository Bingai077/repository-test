package cn.bingai.practice01.demo02.chapter17_Java9_10_11NEW.Java9;

/**
 * @author bingai
 * @create 2019-11-16 18:27
 */
public interface MyInterface {
    //如下的三个方法的权限修饰符都是public
    void methodAbstract();

    static void methodStatic(){
        System.out.println("我是接口中的静态方法");
    }

    default void methodDefault(){
        System.out.println("我是接口中的默认方法");

        methodPrivate();
    }

    //jdk 9中允许接口中定义私有方法
    private void methodPrivate(){
        System.out.println("我是接口中的私有方法");
    }
}
