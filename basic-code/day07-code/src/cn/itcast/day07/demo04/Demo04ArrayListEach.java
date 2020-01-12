package cn.itcast.day07.demo04;

import java.util.ArrayList;

public class Demo04ArrayListEach {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("陈");
        list.add("斌");
        list.add("杰");

        //集合遍历,快捷方式，List.fori
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));//get取值
        }

    }


}
