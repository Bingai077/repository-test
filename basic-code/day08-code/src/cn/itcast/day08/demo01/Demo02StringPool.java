package cn.itcast.day08.demo01;
/*
字符串常量池：程序中直接写上的双引号字符串，就在字符串常量池中。

对于基本类型来说，==是进行数值的比较
对于引用类型来说，==是进行【地址值】的比较

注意事项：
1.对于引用类型来说，==进行的是地址值的比较。
2.双引号直接写的字符串在常量池当中，new的不在池中。
 */
public class Demo02StringPool {

    public static void main(String[] args) {
        String str1 = "abc";//常量池，在堆中
        String str2 = "abc";//常量池

        char[] charArray = {'a', 'b', 'c'};
        String str3 = new String(charArray);//new出来的对象不在常量池中

        System.out.println(str1 == str2);//true
        System.out.println(str1 == str3);//false
        System.out.println(str2 == str3);//false

    }




}
