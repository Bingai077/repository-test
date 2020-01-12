package cn.bingai.practice01.demo02.chapter12_Generic.test3_application;

import org.junit.Test;

import java.util.List;

/**
 * @author bingai
 * @create 2019-11-08 10:53
 */
public class DAOTest {
    @Test
    public void test1(){
        CustomerDAO dao1 = new CustomerDAO();

        dao1.add(new Customer());
        List<Customer> list = dao1.getForList(10);

        StudentDAO dao2 = new StudentDAO();
        dao2.add(new Student());
        Student index = dao2.getIndex(1);


    }
}
