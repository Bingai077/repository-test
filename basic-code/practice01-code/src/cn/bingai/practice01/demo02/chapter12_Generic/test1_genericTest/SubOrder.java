package cn.bingai.practice01.demo02.chapter12_Generic.test1_genericTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bingai
 * @create 2019-11-07 23:28
 */
public class SubOrder extends Order<Integer> {//SubOrder:不是泛型类

    public static <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();

        for (E e : arr) {
            list.add(e);
        }
        return list;
    }

}
