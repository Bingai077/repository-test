package cn.itcast.day07.demo05;

import java.util.ArrayList;

/*
题目：
定义以指定格式打印集合的方法(ArrayList类型作为参数)，
使用{}扩起集合，使用@分隔每个元素。格式参照 {元素@元素@元素}。

System.out.println(List);  [10,20,30]
printArrayList(List);      {10@20@30}


 */
public class Demo03ArrayListPrint {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("陈");
        list.add("斌");
        list.add("杰");
        list.add("陈斌杰");
        System.out.println(list);//[陈, 斌, 杰, 陈斌杰]

        printArrayList(list);

    }
    /*
    定义方法的三要素：
    返回值类型：只是进行打印而已，没有运算，没有结果，所以用void
    方法名称：printArrayList
    参数列表：ArrayList

     */
    public static void printArrayList(ArrayList<String> list){
        //{10@20@30}
        System.out.print("{");
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            if (i == list.size() - 1) {
                System.out.println(name + "}");
            } else {
                System.out.print(name + "@");

            }
        }

    }


}
