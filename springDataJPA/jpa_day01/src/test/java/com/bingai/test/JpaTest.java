package com.bingai.test;

import com.bingai.domain.Customer;
import com.bingai.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.jar.JarEntry;

/**
 * @author bingai
 * @create 2019-12-31 10:40
 */
public class JpaTest {
    /**
     * 测试jpa保存
     * Jpa的操作步骤：
     *      1.加载配置文件，创建工厂（实体管理器工厂）对象
     *      2.通过实体管理类工厂获得实体管理器
     *      3.获取事务对象，开启事务
     *      4.完成增删改查操作
     *      5.提交事务（回滚事务）
     *      6.关闭资源
     */
    @Test
    public void testSave(){
        //1.加载配置文件，创建工厂（实体管理器工厂）对象
        //EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");
        //2.通过实体管理类工厂获得实体管理器
        //EntityManager em = factory.createEntityManager();

        EntityManager em = JpaUtils.getEntityManager();

        //3.获取事务对象，开启事务
        EntityTransaction tx = em.getTransaction();//获取事务对象
        tx.begin();//开启事务
        //4.完成增删改查操作
        Customer customer = new Customer();
        customer.setCustName("张三");
        customer.setCustIndustry("外贸");
        em.persist(customer);//保存
        //5.提交事务（回滚事务）
        tx.commit();
        //6.关闭资源
        em.close();
        //factory.close();

    }


    /**
     * 根据id查询客户
     *  使用find方法查询：
     *      1.查询的对象就是当前客户对象本身
     *      2.在调用find方法的时候，就会发送sql语句查询数据库
     *
     * 立即加载：
     *      1.得到的是对象本身
     *      2.使用的时候才加载
     *
     */
    @Test
    public  void testFindById(){
        //1.通过工具类获取entityManger
        EntityManager em = JpaUtils.getEntityManager();
        //2.开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //3.增删改查--根据id查询客户
        /**
         * find:根据id查询数据
         *      class：查询结果需要包装的实体类类型的字节码
         *      id：查询的主键的取值
         */
        Customer customer = em.find(Customer.class, 1L);
        //System.out.println(customer);
        //4.提交事务
        tx.commit();
        //5.释放资源
        em.close();
    }


    /**
     * 【常用】
     * 根据id查询客户
     *      使用getReference方法
     *          1.获取的对象是一个动态代理对象
     *          2.调用getReference方法不会立即发送sql语句对象
     *              当调用查询结果对象的时候，才会发送查询的sql语句，什么时候用，什么时候发送sql语句查询数据库
     * 延迟加载（懒加载）
     *  得到的是一个动态代理对象
     *  什么时候用，什么时候才会加载
     */
    @Test
    public  void testReference(){
        //1.通过工具类获取entityManger
        EntityManager em = JpaUtils.getEntityManager();
        //2.开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //3.增删改查--根据id查询客户
        /**
         *Reference:根据id查询数据
         *      class：查询结果需要包装的实体类类型的字节码
         *      id：查询的主键的取值
         */
        Customer customer = em.getReference(Customer.class, 1L);
        System.out.println(customer);
        //4.提交事务
        tx.commit();
        //5.释放资源
        em.close();
    }

    /**
     * 删除客户的案例
     */
    @Test
    public  void testRemove(){
        //1.通过工具类获取entityManger
        EntityManager em = JpaUtils.getEntityManager();
        //2.开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //3.增删改查--删除客户
        //根据id查询客户
        Customer customer = em.find(Customer.class, 1L);
        //调用remove方法完成删除操作
        em.remove(customer);

        //4.提交事务
        tx.commit();
        //5.释放资源
        em.close();
    }


    /**
     * 更新客户的操作
     */
    @Test
    public  void testUpdate(){
        //1.通过工具类获取entityManger
        EntityManager em = JpaUtils.getEntityManager();
        //2.开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //3.增删改查--更新操作
        //根据id查询客户
        Customer customer = em.find(Customer.class, 1L);
        System.out.println(customer);
        //更新客户merge方法
        customer.setCustIndustry("IT");
        em.merge(customer);


        //4.提交事务
        tx.commit();
        //5.释放资源
        em.close();
    }

}