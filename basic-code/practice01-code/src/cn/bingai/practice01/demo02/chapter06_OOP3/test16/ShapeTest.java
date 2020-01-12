package cn.bingai.practice01.demo02.chapter06_OOP3.test16;

public class ShapeTest {
    public static void main(String[] args) {
        Shape tri = new Triangle("红",3,4,5);
        Shape cir = new Circle("白",3);

        System.out.println(tri.toString());
        System.out.println("三角形周长为：" + tri.celPerimeter());
        System.out.println(cir.toString());
        System.out.println("圆周长为：" + cir.celPerimeter());

    }
}
