package com.bingai.test;

import com.bingai.junit.Calaulator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    /**
     * 初始化方法，
     * 用于资源申请，所有测试方法在执行之前都会先执行该方法
     *
     */
    @Before
    public void init(){
        System.out.println("init...");
    }

    /*
        释放资源的方法
        在所有测试方法执行完都会自动执行该方法

     */
    @After
    public void close(){
        System.out.println("close...");
    }

    /*
       测试add方法
     */
    @Test
    public void testAdd(){
        //System.out.println("我被执行了");
        //1.创建计算器对象
        System.out.println("testAdd...");
        Calaulator c = new Calaulator();
        //2.调用add方法
        int result = c.add(1,2);
        //System.out.println(result);

        //3.断言 我断言这个结果是3
        Assert.assertEquals(3,result);
    }

    @Test
    public void testSub(){
        //1.创建计算器对象
        Calaulator c = new Calaulator();
        //2.调用sub方法
        int result = c.sub(1,2);
        System.out.println("testSub...");
        //System.out.println(result);

        //3.断言 我断言这个结果是-1
        Assert.assertEquals(-1,result);
    }
}
