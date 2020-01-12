package com.bingai.day11.demo9test;

import com.bingai.day11.red.OpenMode;

import java.util.ArrayList;
import java.util.Random;

public class RandMode implements OpenMode {
    @Override
    public ArrayList<Integer> divide(final int totalMoney, final int totalCount) {
        ArrayList<Integer> list = new ArrayList<>();
        int leftMoney = totalMoney;
        int leftCount = totalCount;

        Random r = new Random();

        //前n-1个
        for (int i = 0; i < totalCount - 1; i++) {
            int money = 1 + r.nextInt(leftMoney / leftCount) * 2;
            list.add(money);
            leftMoney = leftMoney - money;
            leftCount--;

        }

        //最后一个
        list.add(leftMoney);


        return list;
    }
}

