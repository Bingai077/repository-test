package cn.bingai.practice01.demo02.chapter09_constantClass;

import org.junit.Test;

/**
 * @author bingai
 * @create 2019-11-03 18:31
 */
public class Test12 {
    /*
            根据传入得路径，获取文件名。例如：D:\myfile\hello.java取出hello.java
            根据传入得路径，获取文件的类型名。例如：D:\myfile\hello.java取出.java

     */
    @Test
    public void test() {
        String str = "D:\\myfile\\hello.java";
        String[] arr = str.split("\\.");
        //System.out.println(Arrays.toString(arr));
        System.out.println(arr[1]);
        String[] arr1 = str.split("\\\\");
//        System.out.println(Arrays.toString(arr1));
        System.out.println(arr1[arr1.length - 1]);
    }


    /*
        编写java程序，随便输入两个单词，两个单词之间以空格隔开，输出时每个单词的首字母变为大写。
        如输入：“hello java”，输出为“Hello Java”

     */
    @Test
    public void test1() {
        String str = "hello java and hello word ";
        String str1 = toUpperStartString(str);
        System.out.println(str1);

    }

    private String toUpperStartString(String str) {
        String str2 = new String();
        if (str.contains(" ")) {
            String[] arr = str.split(" ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1);
                if (i == arr.length - 1) {
                    str2 += arr[i];
                } else {
                    str2 += arr[i] + " ";
                }
            }
            return str2;

        } else {

            throw new RuntimeException("输入字符串中无空格");
        }

    }


    /*
        求出“hijavahehejavahejava”字符串里面包含几个“java字符串。”

     */
    @Test
    public void test2() {
        String str = "hijavahehejavahejava";
        String str1 = "java";
        int count = countStrContains(str, str1);
        System.out.println(count);
    }

    private int countStrContains(String str, String str1) {
        int count = 0;
        int index = 0;

        if (str.length() >= str1.length()) {
            //int indexOf(String str,int fromIndex)：从fromIndex指定位置开始，获取str在字符串中出现的位置
            while ((index = str.indexOf(str1,index)) != -1) {
                index += str1.length();
                count++;
            }
            return count;
        } else {
            return 0;
        }

    }


    /*
        输入一句5个字的话，然后将它逆序输出。例如：
            原数组：我爱你中国
            逆序输出：国中你爱我
            提示：先声明一个字符串数组，每个汉字作为字符串数组的一个元素，然后再从数组末尾开始循环输出。


     */
    @Test
    public void test3() {
        String str = "我爱你中国";
        StringBuffer sb = new StringBuffer(str);
        System.out.println(sb.reverse());

    }

}
