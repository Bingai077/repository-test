package cn.bingai.practice01.demo02.chapter12_Generic.test5_exer2;

import java.util.List;

/**
 *
 定义一个测试类：
 创建 DAO 类的对象， 分别调用其 save、 get、 update、 list、 delete 方
 法来操作 User 对象，
 使用 Junit 单元测试类进行测试。


 * @author bingai
 * @create 2019-11-08 12:23
 */
public class Test {
    public static void main(String[] args) {
        DAO<User> user = new DAO<>();

        user.save("1001",new User(1001,20,"bingai"));
        user.save("1002",new User(1002,35,"Kobe"));
        user.save("1003",new User(1003,18,"Coco"));

        user.update("1003",new User(1003,20,"Mingming"));

        user.delete("1002");

        List<User> list = user.list();
//        System.out.println(list);
        list.forEach(System.out::println);





    }

}
