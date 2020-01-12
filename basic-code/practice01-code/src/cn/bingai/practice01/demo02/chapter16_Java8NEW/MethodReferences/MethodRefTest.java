package cn.bingai.practice01.demo02.chapter16_Java8NEW.MethodReferences;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 *
 * 1.使用情景：当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用
 *
 * 2.方法引用，本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例。所以
 *   方法引用，也是函数式接口的实例。
 *
 * 3.使用格式： 类(或对象):: 方法名
 *
 * 4.具体分为如下三种情况：
 *   对象 :: 非静态方法
 *   类 :: 静态方法
 *
 *   类 :: 非静态方法
 *
 * 5.方法引用使用要求：要求接口中的抽象方法的形参列表和返回值类型与
 *                        方法引用的方法的形参列表和返回值类型相同(针对情况1和情况2)
 *
 *
 *
 * Created by shkstart.
 */
public class MethodRefTest {

	// 情况一：对象 :: 实例方法
	//Consumer中的void accept(T t)
	//PrintStream中的void println(T t)
	@Test
	public void test1() {
		Consumer<String> con1 = str -> System.out.println(str);
		con1.accept("北京");

		System.out.println();

		Consumer<String> con2 = System.out :: println;
		con2.accept("宁波");
	}
	
	//Supplier中的T get()
	//Employee中的String getName()
	@Test
	public void test2() {
		Employee emp = new Employee(1001, "Bingai", 23, 12000);

		Supplier<String> sup1 = () -> emp.getName();
		System.out.println(sup1.get());

		System.out.println();
		Supplier<String> sup2 = emp :: getName;
		System.out.println(sup2.get());

	}

	// 情况二：类 :: 静态方法
	//Comparator中的int compare(T t1,T t2)
	//Integer中的int compare(T t1,T t2)
	@Test
	public void test3() {
		Comparator<Integer> com1 = (o1,o2) -> Integer.compare(o1,o2);
		System.out.println(com1.compare(12, 21));

		System.out.println();

		Comparator<Integer> com2 = Integer::compareTo;
		System.out.println(com2.compare(12,10));

	}
	
	//Function中的R apply(T t)
	//Math中的Long round(Double d)
	@Test
	public void test4() {
		Function<Double,Long> func = new Function<Double, Long>() {
			@Override
			public Long apply(Double d) {
				return Math.round(d);
			}
		};

		Function<Double,Long> func1 = d -> Math.round(d);
		System.out.println(func1.apply(123.333));

		Function<Double,Long> func2 = Math :: round;
		System.out.println(func2.apply(123521.25455412542));


	}

	// 情况三：类 :: 实例方法 
	// Comparator中的int comapre(T t1,T t2)
	// String中的int t1.compareTo(t2)
	@Test
	public void test5() {
		Comparator<String> com1 = (s1,s2) -> s1.compareTo(s2);
		System.out.println(com1.compare("abc", "abb"));

		Comparator<String> com2 = String::compareTo;
		System.out.println(com2.compare("abc", "abb"));

	}

	//BiPredicate中的boolean test(T t1, T t2);
	//String中的boolean t1.equals(t2)
	@Test
	public void test6() {
		BiPredicate<String,String>  bip1 = (s1,s2) -> s1.equals(s2);
		System.out.println(bip1.test("abc", "abc"));

		BiPredicate<String,String> bip2 = String :: equals;
		System.out.println(bip2.test("abc", "abd"));

	}
	
	// Function中的R apply(T t)
	// Employee中的String getName();
	@Test
	public void test7() {
		Function<Employee,String> func1 = (emp) -> emp.getName();
		System.out.println(func1.apply(new Employee(1001, "bingai")));

		Function<Employee,String> func2 = Employee :: getName;
		System.out.println(func2.apply(new Employee(1002,"Coco")));

	}

}
