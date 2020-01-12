package cn.bingai.practice01.demo02.chapter09_constantClass.test01_String;

/**
 * @author bingai
 * @create 2019-11-01 22:52
 */
public class StringTest1 {
        String str = new String("good");//String不可变
        char[] ch = { 't', 'e', 's', 't' };//数组地址可变
        public void change(String str, char ch[]) {
            str = "test2_exer ok";
            ch[0] = 'b';
        }
        public static void main(String[] args) {
            StringTest1 ex = new StringTest1();
            ex.change(ex.str, ex.ch);
            System.out.println(ex.str);//good
            System.out.println(ex.ch);//best
        }
}
