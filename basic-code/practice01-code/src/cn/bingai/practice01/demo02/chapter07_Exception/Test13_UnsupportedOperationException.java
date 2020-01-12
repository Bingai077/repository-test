package cn.bingai.practice01.demo02.chapter07_Exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//UnsupportedOperationException 操作错误异常
public class Test13_UnsupportedOperationException {
    public static void main(String[] args) {
        String[] listArray = new String[2];
        List list = Arrays.asList(listArray);
        ArrayList list1 = new ArrayList(list);
        list1.add("hello");
        listArray[0] = "china";
        list.add("word");
        System.out.println(list.get(0) + "," + list.get(1));
    }
}
