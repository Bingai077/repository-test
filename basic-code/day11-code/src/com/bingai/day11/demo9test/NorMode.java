package com.bingai.day11.demo9test;

import com.bingai.day11.red.OpenMode;

import java.util.ArrayList;

public class NorMode implements OpenMode {
    @Override
    public ArrayList<Integer> divide(final int totalMoney, final int totalCount) {
        ArrayList<Integer> list = new ArrayList<>();

        int eachMoney = totalMoney / totalCount;
        int dealt = totalMoney % totalCount;

        for (int i = 0; i < totalCount - 1; i++) {
            list.add(eachMoney);
        }

        list.add(eachMoney + dealt);

        return list;
    }
}
