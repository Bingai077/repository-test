package cn.bingai.practice01.demo02.chapter04_OOP1.test12;
/*
猜数字游戏：

一个类A有两个成员变量v、num，v有一个初值100。

定义一个方法guess，对A类的成员变量v，用num进行猜。

如果大了则提示大了，小了则提示小了。等于则提示猜测成功。

在main方法中测试

 */
public class Test {
    public static void main(String[] args) {
        Game game = new Game();

        game.setV(100);


        game.guess(90);
        game.guess(108);
        game.guess(100);


    }


}







