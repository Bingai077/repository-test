package cn.bingai.practice01.demo02.chapter11_collection;

import java.util.HashSet;

/**创建Car类，包含name，price属性，构造器等方法，
 * 创建测试类，在main方法中创建Set接口的实现类，
 * 添加5个以上的Car对象，遍历集合元素，验证重复元素是否过滤了；
 * 如果没有过滤，实现过滤功能；
 * 把每个小车的price降10000元，再遍历，查看price是否已改变
 * @author bingai
 * @create 2019-11-06 17:04
 */
public class Test04 {
    public static void main(String[] args) {
        HashSet<Car> cars = new HashSet<>();
        cars.add(new Car("奔驰",500000));
        cars.add(new Car("宝马",450000));
        cars.add(new Car("保时捷",1500000));
        cars.add(new Car("本田",200000));
        cars.add(new Car("丰田",150000));
        cars.add(new Car("奔驰",400000));

        for (Car car : cars) {
            System.out.println(car);
        }
    }

}
class Car{
    private String name;
    private int price;

    public Car() {
    }

    public Car(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (price != car.price) return false;
        return name != null ? name.equals(car.name) : car.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + price;
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}