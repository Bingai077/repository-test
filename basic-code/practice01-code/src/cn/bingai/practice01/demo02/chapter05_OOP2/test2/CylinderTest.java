package cn.bingai.practice01.demo02.chapter05_OOP2.test2;

public class CylinderTest {
    public static void main(String[] args) {

        Circle circle = new Circle();
        Cylinder cylinder = new Cylinder();

        circle.setRadius(3.0);
        double arae1 = circle.findArae(circle.getRadius());
        System.out.println("面积为：" + arae1);



        cylinder.setLength(5.0);
        cylinder.setRadius(2.0);

        double arae = cylinder.findArae(cylinder.getRadius());
        System.out.println("表面积为：" + arae);

        double volume = cylinder.findVolume(cylinder.getRadius());
        System.out.println("体积为：" + volume);


    }

}
