package cn.bingai.practice01.demo02.chapter06_OOP3.test14;

public class Test5Cellphone {
    public static void main(String[] args) {
        new Test5Cellphone().alarmclock(new Bell() {
            @Override
            public void sound() {
                System.out.println("懒猪起床了。");
            }
        });
    }


    public void alarmclock(Bell bell){
        bell.sound();
    }
}

interface Bell{
    public abstract void sound();
}



