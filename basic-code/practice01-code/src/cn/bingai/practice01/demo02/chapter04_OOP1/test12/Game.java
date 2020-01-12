package cn.bingai.practice01.demo02.chapter04_OOP1.test12;

public class Game {
    private int num;
    private int v ;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public void guess(int num) {
        if (num > v) {
            System.out.println("大了");
        } else if (num < v) {
            System.out.println("小了");
        }else{
            System.out.println("恭喜，猜对了");
        }
    }


}
