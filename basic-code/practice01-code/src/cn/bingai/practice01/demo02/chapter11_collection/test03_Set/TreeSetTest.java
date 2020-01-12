package cn.bingai.practice01.demo02.chapter11_collection.test03_Set;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author bingai
 * @create 2019-11-05 21:50
 */
public class TreeSetTest {

    /*
        1.向TreeSet中添加的数据，要求是【相同类】的对象
        2.两种排序方式：自然排序(实现Comparable接口) 和 定制排序(Comparator)

        3.自然排序中，比较两个对象是否相同的标准为：compareTo()返回0，不再是equals().
        4.定制排序中，比较两个对象是否相同的标准为：compare()返回0，不再是equals().
     */

    @Test
    public void test(){
        TreeSet set = new TreeSet();
        //错误，不能添加不同类的对象
//        set.add(123);
//        set.add(456);
//        set.add("AA");
//        set.add(new User("bingai",18));

        //举例一：
//        set.add(34);
//        set.add(-34);
//        set.add(43);
//        set.add(11);
//        set.add(8);

        //举例二：
        set.add(new User("Bingai",18));
        set.add(new User("Mingming",16));
        set.add(new User("Bin-gai",20));
        set.add(new User("CoCo",19));
        set.add(new User("Bingo",22));
        set.add(new User("Bingo",25));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }



    @Test
    public void test1() {
        Comparator comparator = new Comparator() {
            //按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
//                    User u1 = (User)o1;
//                    User u2 = (User)o2;
//                    return Integer.compare(u1.getAge(),u2.getAge());

                    return  ((User) o1).getAge() - ((User) o2).getAge();
                }else{
                    throw new RuntimeException("输入数据类型不匹配");
                }
            }
        };

        TreeSet set = new TreeSet(comparator);
        set.add(new User("Bingai",18));
        set.add(new User("Mingming",16));
        set.add(new User("Bin-gai",22));
        set.add(new User("CoCo",19));
        set.add(new User("Bingo",22));
        set.add(new User("Bingo",25));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
