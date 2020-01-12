package cn.bingai.practice01.demo02.chapter02_flowcontrol;
/*
    对学生成绩大于60分的，输出“合格”。低于60分的，输出“不合格” 。


 */
public class Test18 {
    public static void main(String[] args) {
        int score = 60;
        switch (score/60){
            case 0:
                System.out.println("不及格");
                break;
            case 1:
                System.out.println("及格");
                break;
            default:
                System.out.println("输入有误，请重新输入！");
                break;

        /*switch (score/10){
                case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("不及格");
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                System.out.println("及格");
                break;
            default:
                System.out.println("输入有误，请重新输入！");
                break;*/

        }
    }
}
