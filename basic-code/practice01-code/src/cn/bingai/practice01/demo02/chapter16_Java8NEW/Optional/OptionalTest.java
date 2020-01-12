package cn.bingai.practice01.demo02.chapter16_Java8NEW.Optional;

import org.junit.Test;

import java.util.Optional;

/**
 * Optional 类:为了在程序中避免空指针异常而创建的
 *
 * 常用方法：ofNullable(T t)
 *          orElse(T t)
 *
 * @author bingai
 * @create 2019-11-15 17:30
 */
public class OptionalTest {

    // 创建Optional类对象的方法：
    // Optional.of(T t) : 创建一个 Optional 实例， t必须非空；
    // Optional.empty() : 创建一个空的 Optional 实例
    // Optional.ofNullable(T t)： t可以为null
    @Test
    public void test1() {

        Girl girl = new Girl();
        //girl = null;
        //of(T t):保证t非空
        Optional<Girl> optionalGirl = Optional.of(girl);

    }

    @Test
    public void test2() {

        Girl girl = new Girl();
        girl = null;
        //ofNullable(T t)： t可以为null
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);

        //orElse(T t):如果当前的Optional内部封装的t是非空的，则返回内部的t
        //如果内部的t是空的，则返回orElse()方法中的参数t1
        Girl girl1 = optionalGirl.orElse(new Girl("Coco"));
        System.out.println(girl1);
    }


    public String getGirlName(Boy boy){
        return boy.getGirl().getName();
    }


    @Test
    public void test3() {
        Boy boy = new Boy();
        boy = null;
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }

    //优化以后的getGirlName():
    public String getGirlName1(Boy boy){
        if(boy != null){
            Girl girl = boy.getGirl();
            if(girl != null){
                return girl.getName();
            }
        }
        return null;
    }

    @Test
    public void test4() {
        Boy boy = new Boy();
        boy = null;
        String girlName = getGirlName1(boy);
        System.out.println(girlName);
    }

    //使用Optional类的getGirlName():
    public String getGirlName2(Boy boy){

        //此时boy1一定非空
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("MingMing")));

        Girl girl = boy1.getGirl();

        //girl1一定非空
        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        Girl girl1 = girlOptional.orElse(new Girl("Ming"));

        return girl1.getName();
    }

    @Test
    public void test5() {
        Boy boy = null;
        boy = new Boy();
        boy = new Boy(new Girl("Coco"));
        String girlName = getGirlName2(boy);
        System.out.println(girlName);
    }








}
