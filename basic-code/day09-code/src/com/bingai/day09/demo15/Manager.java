package com.bingai.day09.demo15;

import java.util.ArrayList;

public class Manager extends User {
    public Manager() {
    }

    public Manager(String name, int money) {
        super(name, money);
    }

    public ArrayList<Integer> send(int totleMoney,int count){
        //创建一个集合存储若干红包的金额
        ArrayList<Integer> redList = new ArrayList<>();

        int leftMoney = super.getMoney();
        if(leftMoney <  totleMoney){
            System.out.println("余额不足");
            return redList;//返回空集合
        }
        //扣钱，重新设置余额
        super.setMoney(leftMoney - totleMoney);
        //发红包
        int avg = totleMoney / count;
        int mod = totleMoney % count;

        for (int i = 0; i < count- 1; i++) {
            redList.add(avg);
        }

        int last = avg + mod;
        redList.add(last);

        return redList;



    }


}
