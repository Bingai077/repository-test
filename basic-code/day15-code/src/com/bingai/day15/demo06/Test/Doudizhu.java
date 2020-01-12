package com.bingai.day15.demo06.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
    斗地主案例：有序版本
    1.准备牌
    2.洗牌
    3.发牌
    4.排序
    5.看牌


 */
public class Doudizhu {
    public static void main(String[] args) {
        //1.准备牌
        //创建一个Map集合，存储牌的索引和组装好的牌
        HashMap<Integer, String> poker = new HashMap<>();
        //创建一个List集合，存储牌的索引
        ArrayList<Integer> pokerIndex = new ArrayList<>();
        //定义两个集合，存储花色和牌的序号
        List<String> colors = List.of("♥", "♣", "♠", "♦");
        List<String> numbers = List.of("2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");
        //先把大王和小王存储到集合中
        int index = 0;
        poker.put(index, "☺☺");
        pokerIndex.add(index);
        index++;
        poker.put(index, "☹");
        pokerIndex.add(index);
        index++;
        //循环嵌套遍历两个集合，组装52张牌，存储到集合中
        for (String number : numbers) {
            for (String color : colors) {
                poker.put(index, color + number);
                pokerIndex.add(index);
                index++;
                ;
            }
        }
        System.out.println(poker);
        System.out.println(pokerIndex);

        //2.洗牌
        //使用Collections中的方法shuffle(List)
        Collections.shuffle(pokerIndex);
        System.out.println(pokerIndex);

        //3.发牌
        //定义四个集合，存储玩家牌的索引，和底牌的索引
        ArrayList<Integer> player1 = new ArrayList<>();
        ArrayList<Integer> player2 = new ArrayList<>();
        ArrayList<Integer> player3 = new ArrayList<>();
        ArrayList<Integer> dipai = new ArrayList<>();
        //遍历存储牌索引的List集合，获取每一张牌的索引
        for (int i = 0; i < pokerIndex.size(); i++) {
            Integer in = pokerIndex.get(i);//in和i不一样，顺序变了
            //System.out.println(i +" "+ in);
            //先判断底牌
            if(i >= 51){//发给底牌
                dipai.add(in);
            }else if(i % 3 == 0){
                player1.add(in);//发给玩家1
            }else if(i % 3 == 1){
                player2.add(in);//发给玩家2
            }else {
                player3.add(in);//发给玩家3
            }
        }

        //4.排序
        //使用Collections中的方法sort(List),默认升序排序
        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);
        Collections.sort(dipai);

        System.out.println(player1);

        //5.看牌，调用看牌的方法
        lookPoker("刘德华",poker,player1);
        lookPoker("周润发",poker,player2);
        lookPoker("周星星",poker,player3);
        lookPoker("底牌",poker,dipai);


    }

    /*
        定义一个看牌的方法，提高代码的复用性
        参数：
            String name:玩家名称
            HashMap<Integer, String> poker：存储牌的poker集合
            ArrayList<Integer> list：存储玩家和底牌的list集合
        查表法：
            遍历玩家或者底牌集合，获取牌的索引
            使用牌的索引，去Map集合中，找到对应的牌
     */
    public static void lookPoker(String name,HashMap<Integer, String> poker,ArrayList<Integer> list){
        //输出玩家的名称，不换行
        System.out.print(name + ": ");
        //遍历玩家或者底牌集合，获取牌的索引
        for (Integer key : list) {
            //使用牌的索引，去Map集合中，找到对应的牌
            String value = poker.get(key);
            System.out.print(value + " ");
        }
        System.out.println();//打印完每一个玩家的牌，换行
    }

}
