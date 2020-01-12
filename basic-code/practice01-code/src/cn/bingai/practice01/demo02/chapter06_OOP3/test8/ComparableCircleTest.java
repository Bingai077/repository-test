package cn.bingai.practice01.demo02.chapter06_OOP3.test8;

public class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle c1 = new ComparableCircle(3.5);
        ComparableCircle c2 = new ComparableCircle(3.6);

        int compareValue = c1.compareTo(c2);
        if(compareValue > 0){
            System.out.println("c1半径大");
        }else if(compareValue < 0){
            System.out.println("c2半径大");
        }else{
            System.out.println("c1与c2一样大");
        }

        int compareValue1 = c1.compareTo(new String("AA"));
        System.out.println(compareValue1);

    }
}
