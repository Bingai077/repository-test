package cn.bingai.practice01.demo02.chapter11_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 请从键盘随机输入10个整数保存到List中，并按倒序、从大到小的顺序显示出来
 * @author bingai
 * @create 2019-11-06 15:27
 */
public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入10个数：");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(sc.nextInt());
        }
        sc.close();

        System.out.println("输入的数是：" + list);
        Collections.reverse(list);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 instanceof Integer && o2 instanceof Integer){
                    return -Integer.compare(o1,o2);
                }else{
                    throw new RuntimeException("输入数据类型错误");
                }
            }
        });
        System.out.println("倒序+排序后的数是："+list);

    }
}
