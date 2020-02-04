package com.zahuopu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.wxpay.sdk.WXPayUtil;
import com.zahuopu.pojo.order.Order;
import com.zahuopu.pojo.seckill.SeckillOrder;
import com.zahuopu.service.order.OrderService;
import com.zahuopu.service.order.WxPayService;
import com.zahuopu.service.seckill.SeckillOrderService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bingai
 * @create 2020-01-31 12:59
 */
@RestController
@RequestMapping("/wxpay")
public class WxPayController {

    @Reference
    private SeckillOrderService seckillOrderService;

    @Reference
    private WxPayService wxPayService;

    @GetMapping("/createNative")
    public Map createNative(String orderId){

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        SeckillOrder seckillOrder = seckillOrderService.queryByUserName(username);
        if(seckillOrder != null){
            if("0".equals(seckillOrder.getStatus()) && "0".equals(seckillOrder.getStatus()) && username.equals(seckillOrder.getUserId())){

                return wxPayService.createNative(seckillOrder.getId().toString(),(int)(seckillOrder.getMoney().floatValue()*100),"http://bingai.easy.echosite.cn/wxpay/notify.do",username);

            }else {
                return null;
            }

        }else {
            return null;
        }

    }

    /**
     * 回调
     */
    @RequestMapping("/notify")
    public Map notifyLogic(HttpServletRequest request){

        System.out.println("支付成功回调。。。。");
        try {
            InputStream inputStream =(InputStream)request.getInputStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int len=0;
            while((len=inputStream.read(buffer))!=-1){
                outputStream.write(buffer,0,len);
            }
            outputStream.close();
            inputStream.close();
            String result=new String(outputStream.toByteArray(),"utf-8");
            System.out.println(result);


            Map<String, String> map = WXPayUtil.xmlToMap(result);
            //获取用户名
            String username = map.get("attach");

            seckillOrderService.updateStatus(map.get("out_trade_no"),username,map.get("transaction_id"));//更新订单状态

            //wxPayService.notifyLogic(result);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new HashMap();

    }

}
