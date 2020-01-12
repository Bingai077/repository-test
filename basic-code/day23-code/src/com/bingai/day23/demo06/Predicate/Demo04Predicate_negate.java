package com.bingai.day23.demo06.Predicate;

import java.util.function.Predicate;

/*
    需求：判断一个字符串的长度是否大于5
        如果字符串的长度大于5，那么返回false
        如果字符串的长度不大于5，那么返回true
       所以我们可以使用取反符号！对判断的结果取反

       Predicate接口中有一个方法negate，也表示取反的意思
         default Predicate<T> negate() {
            return (t) ‐> !test2_exer(t);
         }
 */
public class Demo04Predicate_negate {
    /*
            定义一个方法，方法的参数，传递一个字符串，
            使用Predicate接口判断字符串的长度是否大于5

         */
    public static boolean checkString(String s, Predicate<String> pre) {
        //return !pre.test2_exer(s)
        return pre.negate().test(s);//等价于return !pre.test2_exer(s);

    }

    public static void main(String[] args) {
        //定义一个字符串
        String s = "abcd";
        //调用checkString方法，参数传递字符串和Lambda表达式
        boolean b = checkString(s, (String str) -> {
            //一个用于判断字符串的长度是否大于5
            return str.length() > 5;
        });
        System.out.println(b);
    }



}
