package cn.bingai.practice01.demo02.chapter09_constantClass;

import org.junit.Test;

/**
 * 获取一个字符串在另一个字符串中出现的次数。
 * 比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
 *
 * @author bingai
 * @create 2019-11-02 22:53
 */
public class Test03pro {

    @Test
    public void test() {

        String str = "ababababababababababababababab";
        String str1 = "ababa";
        //int count = countString(str, str1);
        int count1 = countString1(str, str1);

        //System.out.println(count);
        System.out.println(count1);


    }

    //错误的 error
    /*private int countString(String str, String str1) {
        String[] arr = str.split(str1);

        return arr.length;
    }*/

    //String substring(int beginIndex)： 返回一个新的字符串， 它是此字符串的从
                                        //beginIndex开始截取到最后的一个子字符串。
    //int indexOf(String str,int fromIndex)：从fromIndex指定位置开始，获取str在字符串中出现的位置
    private int countString1(String str, String str1) {
        if(str.length() >= str1.length()){
            int count = 0;
            int index = 0;

            //方式一：
//            while((index = str.indexOf(str1)) != -1){
//                str = str.substring(index + str1.length());
//                count++;
//            }

            //方式二：
            while((index = str.indexOf(str1,index)) != -1){
                index += str1.length();
                count++;
            }

            return count;

        }else{
            return 0;
        }


    }
}
