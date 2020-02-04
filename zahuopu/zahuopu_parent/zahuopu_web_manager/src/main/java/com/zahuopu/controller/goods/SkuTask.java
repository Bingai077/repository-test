package com.zahuopu.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zahuopu.service.goods.StockBackService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author bingai
 * @create 2020-01-30 23:07
 */
@Component
public class SkuTask {

    @Reference
    private StockBackService stockBackService;

    /**
     * sku的库存回滚(间隔一小时执行回滚)
     */
    //@Scheduled(cron = "0 * * * * ?")//一分钟回滚
    @Scheduled(cron = "0 0 0/1 * * ?")//一小时回滚
    public void skuStockBack(){
        System.out.println("=====starting huigun开始=======");
        stockBackService.doBack();
        System.out.println("=====ending huigun结束=======");
    }
}
