package cn.itcast.day06.demo02;

public class Demo02PhoneTwo {
    public static void main(String[] args) {
        //根据Phone类，创建一个名为one的对象
        //格式：类名称 对象名 = new 类名称();

        Phone one = new Phone();
        System.out.println(one.brand);//null
        System.out.println(one.color);//null
        System.out.println(one.price);//0.0
        System.out.println("=============");


        one.brand = "iPhone";
        one.color = "白色";
        one.price = 5399.99;
        System.out.println(one.brand);//iPhone
        System.out.println(one.color);//白色
        System.out.println(one.price);//5399.0
        System.out.println("=============");

        one.call("乔布斯");
        one.sendMessage();
        System.out.println("=============");


        Phone two = new Phone();
        System.out.println(two.brand);//null
        System.out.println(two.color);//null
        System.out.println(two.price);//0.0
        System.out.println("=============");


        two.brand = "三星";
        two.color = "蓝色";
        two.price = 4399.99;
        System.out.println(two.brand);//三星
        System.out.println(two.color);//蓝色
        System.out.println(two.price);//4399.99
        System.out.println("=============");

        two.call("欧巴");
        two.sendMessage();


    }

}
