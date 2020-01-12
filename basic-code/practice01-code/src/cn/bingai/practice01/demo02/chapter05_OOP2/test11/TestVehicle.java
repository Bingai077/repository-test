package cn.bingai.practice01.demo02.chapter05_OOP2.test11;
/*
    编写一个Java应用程序，设计一个汽车类Vehicle，包含的属性有车轮个数wheels和车重weight。小车类Car是Vehicle的子类，其中包含的属性有载人数loader。卡车类Truck是Car类的子类，其中包含的属性有载重量payload。
（1）每个类都有构造方法进行属性初识化
（2）每个类都输出相关数据的toString方法
（3）使用Test类中的main方法定义各类初始化数据后台打印相关数据

 */
public class TestVehicle {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle(8, 50000);
        Vehicle v2 = new SadanCar(4,15000,5);
        Vehicle v3 = new Truck(16,100000,5,120000);

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);

    }
}
