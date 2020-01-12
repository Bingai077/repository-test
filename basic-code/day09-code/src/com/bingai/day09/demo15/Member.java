package com.bingai.day09.demo15;

import java.util.ArrayList;
import java.util.Random;

public class Member extends User {

    public Member() {
    }

    public Member(String name, int money) {
        super(name, money);
    }

    public void receive(ArrayList<Integer> list){
        //从多个红包中随便抽取一个给自己
        //随机获取一个list集合中的索引编号
        int index = new Random().nextInt(list.size());
        Integer delte = list.remove(index);

        int money = super.getMoney();
        super.setMoney(money + delte);



    }
}
