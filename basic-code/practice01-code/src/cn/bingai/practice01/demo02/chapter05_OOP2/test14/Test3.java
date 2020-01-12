package cn.bingai.practice01.demo02.chapter05_OOP2.test14;

class Fu {
    boolean show(char a) {
        System.out.println(a);
        return true;
    }
}


public class Test3 extends Fu{
    public static void main(String[] args) {
        int i = 0;
        Fu f = new Test3();
        Test3 d = new Test3();
        for (f.show('A'); f.show('B') && (i < 2); f.show('C')) {
            i++;//A B
            d.show('D');
        }
    }

    boolean show(char a) {
        System.out.println(a);
        return false;
    }

}
