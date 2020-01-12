package cn.bingai.practice01.demo02.chapter11_collection;

import java.util.*;

/**
 斗地主案例：有序版本
 1.准备牌
 2.洗牌
 3.发牌
 4.排序
 5.看牌
 * @author bingai
 * @create 2019-11-07 23:40
 */
public class Test17 {
    public static void main(String[] args) {

        HashMap<Integer, String> poker = new HashMap<>();//存整副牌

        ArrayList<Integer> pokerIndex = new ArrayList<>();//存牌的序号

        List<String> color = List.of("♥", "♦", "♣", "♠");
        List<String> number = List.of("2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");

        int index = 0;
        poker.put(index,"❤❤");
        pokerIndex.add(index);
        index++;
        poker.put(index,"ღღ");
        pokerIndex.add(index);
        for (String n : number) {
            for (String c : color) {
                index++;
                poker.put(index ,c + n);
                pokerIndex.add(index);
            }
        }

        System.out.println("组装好的牌为：" + poker);
        System.out.println("组装好的牌的索引为：" + pokerIndex);

        Collections.shuffle(pokerIndex);
        System.out.println("洗牌后的索引为：" + pokerIndex);

        ArrayList<Integer> player1 = new ArrayList<>();
        ArrayList<Integer> player2 = new ArrayList<>();
        ArrayList<Integer> player3 = new ArrayList<>();
        ArrayList<Integer> dipai = new ArrayList<>();

        for (int i = 0; i < pokerIndex.size(); i++) {
            if(i >= 51){
                dipai.add(pokerIndex.get(i));
            }else if (i % 3 == 0){
                player1.add(pokerIndex.get(i));
            }else if(i % 3 == 1){
                player2.add(pokerIndex.get(i));
            }else{
                player3.add(pokerIndex.get(i));
            }
        }


        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);
        Collections.sort(dipai);

        System.out.println("斌改的牌：" + lookPoker(poker,player1));
        System.out.println("明明的牌：" + lookPoker(poker,player2));
        System.out.println("陪客的牌：" + lookPoker(poker,player3));
        System.out.println("底牌：" + lookPoker(poker,dipai));

    }
    public static  ArrayList<String> lookPoker(HashMap<Integer,String> poker,ArrayList<Integer> list){
        ArrayList<String> list1 = new ArrayList<String>();
        for (Integer in : list) {
            list1.add(poker.get(in));
        }

        return list1;
    }



}
