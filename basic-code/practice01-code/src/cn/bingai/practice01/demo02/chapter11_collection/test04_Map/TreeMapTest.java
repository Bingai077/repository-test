package cn.bingai.practice01.demo02.chapter11_collection.test04_Map;

import cn.bingai.practice01.demo02.chapter11_collection.test03_Set.User;
import org.junit.Test;

import java.util.*;

/**
 * @author bingai
 * @create 2019-11-06 10:49
 */
public class TreeMapTest {

    //向TreeMap中添加key-value，要求key必须是由同一个类创建的对象
    //因为要按照【key】进行排序：自然排序，定制排序


    //定制排序
    @Test
    public void test2() {


        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    //return ((User) o1).getAge() - ((User) o2).getAge();
                    return Integer.compare(((User) o1).getAge(),((User) o2).getAge());
                }else {
                    throw new RuntimeException("输入数据类型不对");
                }

            }
        });

        User u1 = new User("bingai", 18);
        User u2 = new User("bingo", 19);
        User u3 = new User("Coco", 16);
        User u4 = new User("Ming", 17);
        User u5 = new User("Tom", 20);

        map.put(u1, 98);
        map.put(u2, 85);
        map.put(u3, 72);
        map.put(u4, 99);
        map.put(u5, 100);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "===" + entry.getValue());

        }


    }


    //自然排序
    @Test
    public void test1(){
        TreeMap map = new TreeMap();
        User u1 = new User("bingai", 18);
        User u2 = new User("bingo", 19);
        User u3 = new User("Coco", 16);
        User u4 = new User("Ming", 17);
        User u5 = new User("Tom", 20);

        map.put(u1,98);
        map.put(u2,85);
        map.put(u3,72);
        map.put(u4,99);
        map.put(u5,100);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "===" + entry.getValue());

        }

    }
}
