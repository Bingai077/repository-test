package cn.bingai.practice01.demo02.chapter06_OOP3.test10;

public class Test {

    public static void main(String[] args) {

        Circle cir1 = new Circle(3.65);
        Circle cir2 = new Circle(5.20);
        System.out.println("cir1的面积是：" + cir1.area() + ",周长是：" + cir1.perimeter());
        System.out.println("cir2的面积是：" + cir2.area() + ",周长是：" + cir2.perimeter());

        Cylinder cy1 = new Cylinder(5.20,5.20);
        Cylinder cy2 = new Cylinder(3.56,6.50);

        System.out.println("底圆周长是：" + cy1.perimeter() +
                "cy1的体积是：" + cy1.volume() + "cy1的表面积是：" + cy1.area()) ;
        System.out.println( "底圆周长是：" + cy2.perimeter() +
                "cy2的体积是：" + cy2.volume() + "cy2的表面积是：" + cy2.area()) ;



    }

}
