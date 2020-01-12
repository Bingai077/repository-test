package cn.itcast.day06.demo02;

public class Demo04PhoneParam {
    public static void main(String[] args) {

        Phone one = new Phone();
        one.price = 8388.0;
        one.brand = "iPhone";
        one.color = "土豪金";

        method(one);//传递进去的参数其实是地址值


    }

    public static void method(Phone param){//任何类型都能作为参数，对象也不例外
        System.out.println(param.brand);//iPhone
        System.out.println(param.price);//8388.0
        System.out.println(param.color);//土豪金

    }

}
