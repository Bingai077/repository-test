package com.zahuopu.service.order;

import java.util.Map;

/**
 * @author bingai
 * @create 2020-01-31 12:47
 */
public interface WxPayService {




    /**
     * 生成微信支付二维码（统一下单）
     * @param orderId 订单号
     * @param money  金额（分）
     * @param notifyUrl  回调地址
     * @Param attach 附加数据
     * @return
     */
    public Map createNative(String orderId,Integer money,String notifyUrl,String... attach);

    /**
     * 微信支付回调
     * @param xml
     */
    public void notifyLogic(String xml);

}
