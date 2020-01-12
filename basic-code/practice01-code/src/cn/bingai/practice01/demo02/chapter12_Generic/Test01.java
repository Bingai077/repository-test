package cn.bingai.practice01.demo02.chapter12_Generic;

import org.junit.Test;

/**
 开发一个泛型Apple类，要求有一个重量属性weight在测试类中实例化不同的泛型对象，
 要求对象a1的这一属性是String类型，
 对象a2的这一属性是Integer型，a3的这一属性是Double型。
 分别为a1，a2，a3的重量属性赋值为：”500克”，500,500.0，
 在测试类中通过对象调用访问器得到属性值并输出。
 另外思考，为什么a2和a3的属性需要是Integer和Double而不是int和double？

 * @author bingai
 * @create 2019-11-08 16:27
 */
public class Test01 {

    @Test
    public void test(){
        Apple<String> a1 = new Apple<>();
        Apple<Integer> a2 = new Apple<>();
        Apple<Double> a3 = new Apple<>();

        a1.setWeight("500克");
        a2.setWeight(500);
        a3.setWeight(500.0);

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);


    }


}

class Apple<T>{
    private T weight;

    public Apple() {
    }

    public Apple(T weight) {
        this.weight = weight;
    }

    public T getWeight() {
        return weight;
    }

    public void setWeight(T weight) {
        this.weight = weight;
    }


    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                '}';
    }
}
