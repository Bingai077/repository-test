package cn.bingai.practice01.demo02.chapter12_Generic.test4_extend;

import java.util.*;

/**
 * @author bingai
 * @create 2019-11-08 12:09
 */
public class Test {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Citizen>> map = new HashMap<String, ArrayList<Citizen>>();
        ArrayList<Citizen> list = new ArrayList<Citizen>();
        list.add(new Citizen("刘恺威"));
        list.add(new Citizen("杨幂"));
        list.add(new Citizen("小糯米"));
        map.put("刘恺威", list);
        Set<Map.Entry<String, ArrayList<Citizen>>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, ArrayList<Citizen>>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, ArrayList<Citizen>> entry = iterator.next();
            String key = entry.getKey();
            ArrayList<Citizen> value = entry.getValue();
            System.out.println("户主： " + key);
            System.out.println("家庭成员： " + value);
        }
    }
}

class Citizen{

    private String name;

    public Citizen() {
    }

    public Citizen(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "name='" + name + '\'' +
                '}';
    }
}
