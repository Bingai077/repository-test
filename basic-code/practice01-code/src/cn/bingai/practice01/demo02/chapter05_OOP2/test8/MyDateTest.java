package cn.bingai.practice01.demo02.chapter05_OOP2.test8;

public class MyDateTest {
    public static void main(String[] args) {
        MyDate date1 = new MyDate(1998, 8, 8);
        MyDate date2 = new MyDate(1998, 8, 8);
        MyDate date3 = new MyDate(1998, 8, 9);

        System.out.println(date1.equals(date2));//true
        System.out.println(date1.equals(date3));//false


        char[] arr = new char[] { 'a', 'b', 'c' };
        System.out.println(arr);//abc
        int[] arr1 = new int[] { 1, 2, 3 };
        System.out.println(arr1);//[I@2ac1fdc4
        double[] arr2 = new double[] { 1.1, 2.2, 3.3 };
        System.out.println(arr2);//[D@5f150435

        Object o1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(o1);//1.0

        Object o2;
        if (true)
            o2 = new Integer(1);
        else
            o2 = new Double(2.0);
        System.out.println(o2);//1

        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);//false

        //Integer内部定义了IntegerCache结构，IntegerCache中定义了Integer[],
        //保存了从-128-127范围的整数,不用再new,目的：提高效率
        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n);//true
        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);//false，相当于new
    }
}
