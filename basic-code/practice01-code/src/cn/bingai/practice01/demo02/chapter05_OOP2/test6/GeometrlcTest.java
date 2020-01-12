package cn.bingai.practice01.demo02.chapter05_OOP2.test6;
/*
定义三个类，父类GeometricObject代表几何形状，子类Circle代表圆形， MyRectangle代表矩形。

定义一个测试类GeometricTest，
编写equalsArea方法测试两个对象的面积是否相等（注意方法的参数类型，利用动态绑定技术），
编写displayGeometricObject方法显示对象的面积（注意方法的参数类型，利用动态绑定技术）。
 */
public class GeometrlcTest {
    public static void main(String[] args) {
        GeometrlcTest test = new GeometrlcTest();

        GeometrlcObject g1 = new Circle("白色",1.0,5.0);
        GeometrlcObject g2 = new MyRectangle("黑色",0.8,5.0,6.0);


        test.displayDeometricObject(g1);
        test.displayDeometricObject(g2);
        System.out.println(test.equalsArea(g1,g2));
    }

    public boolean equalsArea(GeometrlcObject o1,GeometrlcObject o2){
        return  o1.findArea() == o2.findArea();
    }

    public void displayDeometricObject(GeometrlcObject o){
        System.out.println("面积为" + o.findArea());
    }
}
