package com.bingai.day13.demo04.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
    斗地主综合案例：
        1.准备牌
        2.洗牌
        3.发牌
        4.看牌

 */
public class DouDiZhu {
    public static void main(String[] args) {
        //1.准备牌
        //定义一个存储54张牌的ArrayList集合，泛型使用String
        ArrayList<String> poker = new ArrayList<>();

        //定义两个数组，一个数组存储牌的花色，一个数组存储牌的序号
        String[] colors = {"♠", "♥", "♣", "♦"};
        String[] numbers = {"2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"};
        //先把大王和小王存储到poker集合中
        poker.add("☺☺");//大王
        poker.add("☹");//小王
        //循环嵌套遍历两个数组，组装52张牌
        for (String number : numbers) {
            for (String color : colors) {
                //System.out.println(color + number);
                //把组装好的牌存储到poker集合中
                poker.add(number + " " + color);//增强for循环可以往集合中存储数据
            }
        }
        //System.out.println("洗牌前：" + poker);


        /*
            2.洗牌
                使用集合的工具类Collections中的方法
                static void shuffle(List<?> List) 使用默认随机源对指定列表进行置换。
         */
        Collections.shuffle(poker);
        //System.out.println("洗牌后：" + poker);

        /*
            3.发牌

         */
        //定义4个集合存储玩家的牌和底牌
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();

        /*
            遍历集合poker，获取每一张牌
            使用poker集合的索引 % 3 给3个玩家轮流发牌
            剩余3张牌给底牌
            注意：
                应先判断底牌(i >= 51),否则牌就发没了
         */
        for (int i = 0; i < poker.size(); i++) {
            //获取每一张牌
            String p = poker.get(i);
            //轮流发牌
            if(i >= 51){
                dipai.add(p);//给底牌发牌
            }else if(i % 3 == 0){
                player1.add(p);//给玩家1发牌
            }else if(i % 3 == 1){
                player2.add(p);//给玩家2发牌
            }else{
                player3.add(p);//给玩家3发牌
            }
        }

        //4.看牌
        // Collections.sort(player1);
        System.out.println("刘德华的牌是：" + player1);
        System.out.println("周润发的牌是：" + player2);
        System.out.println("周星驰的牌是：" + player3);
        System.out.println("底牌是：" + dipai);

    }

}
