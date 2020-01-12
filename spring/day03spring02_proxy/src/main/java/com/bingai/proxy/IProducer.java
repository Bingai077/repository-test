package com.bingai.proxy;

/**对生产厂家要求的接口
 * @author bingai
 * @create 2019-12-21 18:38
 */
public interface IProducer  {
    /**
     * 销售
     * @param money
     */
    public void saleProduct(Double money);

    /**
     * 售后
     * @param money
     */
    public void afterService(double money);

}
