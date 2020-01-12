package cn.bingai.practice01.demo02.chapter05_OOP2.test4;
/*
1.若子类重写了父类方法，就意味着子类里定义的方法彻底覆盖了父类的方法，
系统将不可能把父类里的方法转移到子类中：【编译看左，运行看右】

2.对于实例变量则不存在这样的现象，即使子类里定义了与父类完全相同的实例变量，
这个实例变量依然不会覆盖父类中定义的实例变量：【编译运行都看左】

 */
public class FieldMethodTest {
    public static void main(String[] args){
        Sub s = new Sub();
        System.out.println(s.count);//20，看new
        s.display();//20，调子类
        Base b = s;//多态性
        System.out.println(b == s);//true，引用数据类型，比较地址，地址相同
        System.out.println(b.count);//10，调父类
        b.display();//20，编译看左，执行看右
    }
}
    class Base {
        int count = 10;
        public void display() {
            System.out.println(this.count);//10
        }
    }


class Sub extends Base {
    int count = 20;
    public void display() {
        System.out.println(this.count);//20
    }
}