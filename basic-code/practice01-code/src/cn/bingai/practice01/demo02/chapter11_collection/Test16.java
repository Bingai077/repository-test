package cn.bingai.practice01.demo02.chapter11_collection;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author bingai
 * @create 2019-11-07 17:58
 */
public class Test16 {
    @Test
    public void test(){
        HashSet set = new HashSet();
        Person1 p1 = new Person1(1001,"AA");
        Person1 p2 = new Person1(1002,"BB");
        set.add(p1);
        set.add(p2);
        System.out.println(set);//[Person1{id=1002, name='BB'}, Person1{id=1001, name='AA'}]

        p1.name = "CC";
        System.out.println(set);//[Person1{id=1002, name='BB'}, Person1{id=1001, name='CC'}]
        /*boolean b = */set.remove(p1);
//        System.out.println(b);//false
        System.out.println(set);//[Person1{id=1002, name='BB'}, Person1{id=1001, name='CC'}]
        set.add(new Person1(1001,"CC"));
        System.out.println(set);//[Person1{id=1002, name='BB'}, Person1{id=1001, name='CC'}, Person1{id=1001, name='CC'}]
        set.add(new Person1(1001,"AA"));
        System.out.println(set);//[Person1{id=1002, name='BB'}, Person1{id=1001, name='CC'}, Person1{id=1001, name='CC'}, Person1{id=1001, name='AA'}]

    }
}

class Person1{
    int id;
    String name;

    public Person1() {
    }

    public Person1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person1 person1 = (Person1) o;

        if (id != person1.id) return false;
        return name != null ? name.equals(person1.name) : person1.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}