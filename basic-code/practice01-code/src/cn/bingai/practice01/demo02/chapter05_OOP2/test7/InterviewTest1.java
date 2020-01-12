package cn.bingai.practice01.demo02.chapter05_OOP2.test7;
//考查多态的笔试题目：
//【编译看左，运行看右】
public class InterviewTest1 {

	public static void main(String[] args) {
		Base base = new Sub();//多态
		base.add(1, 2, 3);//sub_1,重写

		Sub s = (Sub)base;
		s.add(1,2,3);//sub_2，重载
	}
}

class Base {
	public void add(int a, int... arr) {
		System.out.println("base");
	}
}

class Sub extends Base {

	public void add(int a, int[] arr) {//重写
		System.out.println("sub_1");
	}

	public void add(int a, int b, int c) {
		System.out.println("sub_2");//重载
	}

}