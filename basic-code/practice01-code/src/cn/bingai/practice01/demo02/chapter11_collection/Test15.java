package cn.bingai.practice01.demo02.chapter11_collection;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 定义一个 Employee 类。
 * 该类包含： private 成员变量 name,age,birthday，其中 birthday 为
 * MyDate 类的对象；
 * 并为每一个属性定义 getter, setter 方法；
 * 并重写 toString 方法输出 name, age, birthday
 * MyDate 类包含:
 * private 成员变量 year,month,day；并为每一个属性定义 getter, setter
 * 方法；
 * 创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中（下一章：
 * TreeSet 需使用泛型来定义）
 * 分别按以下两种方式对集合中的元素进行排序，并遍历输出：
 * 1). 使 Employee 实现 Comparable 接口，并按 name 排序
 * 2). 创建 TreeSet 时传入 Comparator 对象，按生日日期的先后排序
 *
 * @author bingai
 * @create 2019-11-07 16:47
 */
public class Test15 {
    public static void main(String[] args) {

        TreeSet set = new TreeSet(new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                //方式二：
//                if (o1 instanceof Employee && o2 instanceof Employee) {
//                    Employee e1 = (Employee) o1;
//                    Employee e2 = (Employee) o2;
//
//                    return e1.getBirthday().compareTo(e2);
//
//                } else {
//                    throw new RuntimeException("输入数据类型不匹配！");
//                }


                    //方式一：
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    if (e1.getBirthday().getYear() != e2.getBirthday().getYear()) {
                        return Integer.compare(e1.getBirthday().getYear(), e2.getBirthday().getYear());
                    } else if (e1.getBirthday().getMonth() != e2.getBirthday().getMonth()) {
                        return Integer.compare(e1.getBirthday().getMonth(), e2.getBirthday().getMonth());
                    } else {
                        return Integer.compare(e1.getBirthday().getDay(), e2.getBirthday().getDay());
                    }
                } else {
                    throw new RuntimeException("输入数据类型不匹配！");
                }
                }
            });

        set.add(new Employee("斌改",18,new MyDate(1999, 9,9)));
        set.add(new Employee("斌gou",20,new MyDate(2009, 8,8)));
        set.add(new Employee("明明",19,new MyDate(2010, 8,9)));
        set.add(new Employee("梅西",21,new MyDate(2004, 6,6)));
        set.add(new Employee("科比",35,new MyDate(1978, 8,30)));
        set.add(new Employee("科比",35,new MyDate(1978, 8,31)));
        set.add(new Employee("科比2",35,new MyDate(1978, 7,30)));
        set.add(new Employee("科比1",35,new MyDate(1978, 8,29)));

        for( Object o :set)

            {
                System.out.println(o);
            }

        }
    }

    class Employee implements Comparable {

        private String name;
        private int age;
        private MyDate birthday;

        public Employee() {
        }

        public Employee(String name, int age, MyDate birthday) {
            this.name = name;
            this.age = age;
            this.birthday = birthday;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", birthday=" + birthday +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public MyDate getBirthday() {
            return birthday;
        }

        public void setBirthday(MyDate birthday) {
            this.birthday = birthday;
        }

        @Override
        public int compareTo(Object o) {
            if (o instanceof Employee) {
                Employee e = (Employee) o;
                return this.name.compareTo(e.name);
            } else {
                throw new RuntimeException("输入数据类型不匹配！");
            }

        }
    }

    class MyDate /*implements Comparable*/ {
        private int year;
        private int month;
        private int day;

        public MyDate() {
        }

        public MyDate(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        @Override
        public String toString() {
            return "MyDate{" +
                    "year=" + year +
                    ", month=" + month +
                    ", day=" + day +
                    '}';
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

//        @Override
//        public int compareTo(Object o) {
//            if (o instanceof Employee) {
//                Employee e = (Employee) o;
//                if (this.getYear() != e.getBirthday().getYear()) {
//                    return Integer.compare(this.getYear(), e.getBirthday().getYear());
//                } else if (this.getMonth() != e.getBirthday().getMonth()) {
//                    return Integer.compare(this.getMonth(),e.getBirthday().getMonth());
//                } else {
//                    return Integer.compare(this.getDay(), e.getBirthday().getDay());
//                }
//            } else {
//                throw new RuntimeException("输入数据类型不匹配！");
//            }
//        }
    }