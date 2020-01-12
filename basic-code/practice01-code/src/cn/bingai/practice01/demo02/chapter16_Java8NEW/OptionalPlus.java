package cn.bingai.practice01.demo02.chapter16_Java8NEW;

import org.junit.Test;

import java.util.Optional;

/**
 * @author bingai
 * @create 2019-11-15 21:47
 */
public class OptionalPlus {

    @Test
    public void test(){
        //empty():创建的Optional对象内部的value = null
        Optional<Object> op1 = Optional.empty();
        if(!op1.isPresent()){//Optional封装的数据是否包含数据
            System.out.println("数据为空");
        }
        System.out.println(op1);
        System.out.println(op1.isPresent());
        //如果Optional封装的数据value为空，则get()报错。否则，value不为空时，返回value
        //System.out.println(op1.get());
    }

    @Test
    public void test2(){
        String str = "hello";
        //str = null;
        //of(T t):封装数据t生成Optional对象。要求t非空，否则报错。
        Optional<String> op1 = Optional.of(str);
        //get()通常与of()方法搭配使用。用于获取内部封装的数据value
        String s = op1.get();
        System.out.println(s);
    }

    @Test
    public void test3(){
        String str = "beijing";
        str = null;
        //ofNullable(T t):封装数据t给Optional内部的value。不要求t非空
        Optional<String> op1 = Optional.ofNullable(str);
        //orElse(T t1):如果Optional内部value非空，则返回此value值。
        //如果value为空，则返回t1
        String str2 = op1.orElse("shanghai");
        System.out.println(str2);

    }

}
