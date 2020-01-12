package com.bingai.day12.demo07.Integer;

import java.util.ArrayList;

/*
    自动装箱与自动拆箱：
        基本数据类型和包装类之间可以自动相互转换
        JDK1.5之后出现的新特性


 */
public class Demo02Integer {
    public static void main(String[] args) {
        /*
            自动装箱：直接把int类型的整数赋值给包装类
            Integer in = 1;相当于 Integer in = new Integer(1);

         */
        Integer in = 1;

        /*
            自动拆箱：in是包装类，无法直接参与运算，可以自动转换为基本数据类型的数据，在参与运算
            in + 2;就相当于 in.invalue() + 3 = 3;
            in = in + 2;就相当于 in = new Integer(3) 自动装箱

         */
        in = in + 2;
        System.out.println(in);

        //ArrayList集合无法存储整数，可以存储Integer包装类
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);//自动装箱  List.add(new Integer(1))
        int i = list.get(0);//自动拆箱 List.get(0).inValue();

    }
}
