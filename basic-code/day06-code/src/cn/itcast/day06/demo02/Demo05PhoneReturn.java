package cn.itcast.day06.demo02;

public class Demo05PhoneReturn {
    public static void main(String[] args) {

        Phone two = getPhone();
        System.out.println(two.price);//8388.0
        System.out.println(two.brand);//iPhone
        System.out.println(two.color);//玫瑰金




    }


    public static Phone getPhone(){
        Phone one = new Phone();
        one.brand = "iPhone";
        one.price = 8388.0;
        one.color = "玫瑰金";

        return one;

    }
}
