package cn.bingai.practice01.demo02.chapter17_Java9_10_11NEW.Java9;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author bingai
 * @create 2019-11-16 11:36
 */
public class Java9Test {

    @Test
    public void test() {
        try {
            URL url = new URL("www.baidu.com");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    //java9特性五：钻石操作符的升级
    @Test
    public void test1() {
        //钻石操作符与匿名实现类在java 8中不能共存，在java9中可以
        Comparator<Object> com = new Comparator<>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };

        //jdk7中的新特性：类型推断
        ArrayList<String> list = new ArrayList<>();

    }

    //java9 特性六：try操作的升
    public static void main(String[] args) {

        //java8之前资源关闭的操作
//        InputStreamReader isr = null;
//        try {
//            isr = new InputStreamReader(System.in);
//            char[] chars = new char[20];
//            int len;
//            if((len = isr.read(chars)) != -1){
//                System.out.println(new String(chars, 0, len));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if(isr != null){
//                try {
//                    isr.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        //java8中资源关闭操作：Java 8中，可以实现资源的自动关闭
        //要求自动关闭的资源的初始化必须放在try的小括号中
//        try(InputStreamReader isr = new InputStreamReader(System.in)){
//            char[] chars = new char[20];
//            int len;
//            if((len = isr.read(chars)) != -1){
//                System.out.println(new String(chars, 0, len));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //java9中资源关闭操作：
        //需要自动关闭的资源的实例化可以放在try的一对小括号外
        //此时的资源变量是常量，声明为final的，不可更改
        InputStreamReader isr = new InputStreamReader(System.in);
        try (isr) {
            char[] chars = new char[20];
            int len;
            if ((len = isr.read(chars)) != -1) {
                System.out.println(new String(chars, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
