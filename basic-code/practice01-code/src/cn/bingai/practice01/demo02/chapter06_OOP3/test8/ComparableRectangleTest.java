package cn.bingai.practice01.demo02.chapter06_OOP3.test8;

public class ComparableRectangleTest {
    public static void main(String[] args) {
        ComparableRectangle c1 = new ComparableRectangle(3.0, 4.0);
        ComparableRectangle c2 = new ComparableRectangle(3.0, 5.0);
        int i = c1.compareTo(c2);
        if(i>0){
            System.out.println("c1面积大");
        }else if(i<0){
            System.out.println("c2面积大");
        }else{
            System.out.println("c1与c2一样大" );
        }


    }
}
