package cn.bingai.practice01.demo02.chapter05_OOP2.test14;

class Fu1 {
    int num = 4;

    void show() {
        System.out.println("showFu");
    }
}

class Zi extends Fu1 {
    int num = 5;

    void show() {
        System.out.println("showZi");
    }
}

public class Test4 {
    public static void main(String[] args) {
        Fu1 f = new Zi();
        Zi z = new Zi();
        System.out.println(f.num);//4
        System.out.println(z.num);//5
        f.show();//showZi
        z.show();//showZi
    }


}
