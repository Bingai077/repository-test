package com.zahuopu.service.goods;

import com.zahuopu.pojo.order.OrderItem;

import java.util.List;

/**
 * @author bingai
 * @create 2020-01-30 22:46
 */
public interface StockBackService {

    /**
     * 添加回滚记录
     * @param orderItemList
     */
    public void addList(List<OrderItem> orderItemList);


    /**
     * 执行库存回滚
     */
    public void doBack();
}
