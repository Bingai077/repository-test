package com.bingai.day11.demo9test;

import com.bingai.day11.red.RedPacketFrame;

/*
要做的事情有：
    1.设置一下程序的标题，通过构造方法的字符串参数。
    2.设置群主名称
    3.设置分发策略：平均，还是随机？

红包分发策略：
    1.普通红包(平均):totalMoney/totalCount,余数放在最后一个红包当中
    2.手气红包(随机):最少1分钱，最多不超过平均数的2倍。应该越发越少。

 */
public class RedMain {

    public static void main(String[] args) {

        RedPacketFrame redPacketFrame = new RedPacketFrame("斌改的网络课") {
            @Override
            public void setOwnerName(String ownerName) {
                super.setOwnerName(ownerName);
            }


        };

        redPacketFrame.setOwnerName("斌改");

        //等额
//        NorMode nor = new NorMode();
//        redPacketFrame.setOpenWay(nor);

        //随机
        RandMode rand =new RandMode();
        redPacketFrame.setOpenWay(rand);





    }
}
