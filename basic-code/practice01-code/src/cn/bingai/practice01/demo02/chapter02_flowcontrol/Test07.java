package cn.bingai.practice01.demo02.chapter02_flowcontrol;
/*
根据消费计算折扣

【switch语句】注意事项
1.switch语句先计算括号中的表达式
2.根据表达式的值检测是否符合执行case后面的选择值，若是所有case的选择值皆不符合，则执行default所包含的语句，
  执行完毕即离开switch语句
3.如果某个case的选择值符合表达式的结果，就会执行该case所包含的语句，直接遇到break语句才离开
4.若是没有定义default要执行的语句，则什么也不会执行，直接离开switch语句。

 */
public class Test07 {
    public static void main(String[] args) {
        double money = 1500;
        String s = "";
        if(money >= 200){
            int grade = (int)money / 200;
            switch(grade){
                case 1:
                    s = "九五折";
                    break;
                case 2:
                    s = "九折";
                    break;
                case 3:
                    s = "八五折";
                    break;
                case 4:
                    s = "八三折";
                    break;
                case 5:
                    s = "八折";
                    break;
                case 6:
                    s = "七八折";
                    break;
                case 7:
                    s = "七五折";
                    break;
                case 8:
                    s = "七三折";
                    break;
                case 9:
                    s = "七折";
                    break;
                case 10:
                    s = "六五折";
                    break;
                default:
                    s = "六折";
            }

        }

        System.out.println("您累计消费金额为：" + money);
        System.out.println("您将享受" + s + "优惠");
    }
}
