package cn.bingai.practice01.demo02.chapter11_collection;

import java.util.HashMap;
import java.util.Set;

/**
 1 ）封装一个汽车类，包含String  name、int  speed属性，在测试类中实例化三个对象：c1，c2，c3，分别设置name为：“奥拓”，“宝马”，“奔驰”，速度分别设置为：100,200,300
 2 ）使用Map集合对象m1将这三个汽车类对象保存成key，然后将int型的汽车价钱作为值保存在m1的value中，上述三款汽车分别对应的价钱是10000,500000,2000000
 3 ）遍历m1的键，打印name属性
 4 ）通过合适的方法，求出m1中“宝马”的价格，并打印结果；
 5 ）经过折旧，所有汽车都降价到原来的80%，请打印降价后“宝马”的价格

 * @author bingai
 * @create 2019-11-06 22:58
 */
public class Test13 {
    public static void main(String[] args) {
        HashMap<Automobile, Integer> map = new HashMap<>();
        Automobile a1 = new Automobile("奥拓", 100);
        Automobile a2 = new Automobile("宝马",200);
        Automobile a3 = new Automobile("奔驰",300);

        map.put(a1,10000);
        map.put(a2,500000);
        map.put(a3,2000000);

        Set<Automobile> set = map.keySet();
        for (Automobile automobile : set) {
            System.out.println(automobile);
        }

        System.out.println(map.get(a2));

        map.put(a1,8000);
        map.put(a2,400000);
        map.put(a3,1600000);

        System.out.println(map.get(a2));



    }
}

class Automobile{
    private String name;
    private int speed;

    public Automobile() {
    }

    public Automobile(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Automobile that = (Automobile) o;

        if (speed != that.speed) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + speed;
        return result;
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "name='" + name + '\'' +
                ", speed=" + speed +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}