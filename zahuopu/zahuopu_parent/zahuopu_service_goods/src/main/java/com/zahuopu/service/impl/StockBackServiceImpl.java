package com.zahuopu.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zahuopu.dao.SkuMapper;
import com.zahuopu.dao.StockBackMapper;
import com.zahuopu.pojo.goods.StockBack;
import com.zahuopu.pojo.order.OrderItem;
import com.zahuopu.service.goods.StockBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author bingai
 * @create 2020-01-30 22:48
 */
@Service(interfaceClass = StockBackService.class)
public class StockBackServiceImpl implements StockBackService {

    @Autowired
    private StockBackMapper stockBackMapper;

    @Transactional
    public void addList(List<OrderItem> orderItemList) {

        for (OrderItem orderItem : orderItemList) {
            StockBack stockBack = new StockBack();
            stockBack.setOrderId(orderItem.getOrderId());
            stockBack.setSkuId(orderItem.getSkuId());
            stockBack.setStatus("0");
            stockBack.setNum(orderItem.getNum());
            stockBack.setCreateTime(new Date());
            stockBackMapper.insert(stockBack);
        }

    }

    @Autowired
    private SkuMapper skuMapper;

    //执行库存回滚
    @Transactional
    public void doBack() {
        System.out.println("---------start库存回滚-----------");
        //查询库存回滚表中状态为0的记录
        StockBack stockBack0 = new StockBack();
        stockBack0.setStatus("0");

        List<StockBack> stockBackList = stockBackMapper.select(stockBack0);
        for (StockBack stockBack : stockBackList) {
            //添加库存
            skuMapper.deductionStock(stockBack.getSkuId(),-stockBack.getNum());

            //减少销量
            skuMapper.addSaleNum(stockBack.getSkuId(),-stockBack.getNum());

            stockBack.setStatus("1");

            stockBackMapper.updateByPrimaryKey(stockBack);
        }
        System.out.println("---------end库存回滚结束-----------");

    }
}
