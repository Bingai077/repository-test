package cn.bingai.practice01.demo02.chapter11_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**

 1.	生成10个随机数，值在100到200之间；
 2.	将这十个数存入HashSet集合中（有可能集合的长度小于10）。
 3.	将这个HashSet集合转换成ArrayList集合
 4.	重新为ArrayList集合排序，按照从小到大的顺序；
 5.	使用foreach遍历集合；


 * @author bingai
 * @create 2019-11-06 22:46
 */
public class Test12 {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        for (int i = 0; i < 10; i++) {
            set.add((int)(Math.random() * 100 + 100));
        }
        System.out.println(set);
        ArrayList list = new ArrayList();
        list.addAll(set);
        System.out.println(list);

        Collections.sort(list);
        for (Object o : list) {
            System.out.println(o);
        }
    }

}
