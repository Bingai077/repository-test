package com.bingai.cglib;

import com.bingai.proxy.IProducer;

/**一个生产者
 * @author bingai
 * @create 2019-12-21 18:34
 */
public class Producer{

    /**
     * 销售
     * @param money
     */
    public void saleProduct(Double money){
        System.out.println("销售产品，并拿到钱:" + money);
    }

    /**
     * 售后
     * @param money
     */
    public void afterService(double money){
        System.out.println("提供售后服务，并拿到钱" + money);
    }





}
