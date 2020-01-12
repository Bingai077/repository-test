package cn.bingai.practice01.demo01;

/*
题目：809*??=800*??+9*??+1

其中??代表的两位数,8*??的结果为两位数，9*??的结果为3位数。求??代表的两位数，及809*??后的结果。

程序解析：for循环的使用

 */
public class Test42 {
    public static void main(String[] args) {

        for (int i = 10; i < 100; i++) {
            if (8 * i < 100 && 9 * i > 100) {
                if (809 * i == 800 * i + 9 * i + 1) {
                    System.out.println("??代表的数为：" + i);
                } else {
                    System.out.println("找不到符合题目的数");
                }


            }
        }

    }
}
