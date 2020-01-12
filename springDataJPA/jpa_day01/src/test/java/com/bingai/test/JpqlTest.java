package com.bingai.test;

import com.bingai.utils.JpaUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**测试jpql查询
 * @author bingai
 * @create 2019-12-31 16:18
 */
public class JpqlTest {

    private EntityManager em;
    private EntityTransaction tx;

    @Before
    public void init(){
        //1.获取entityManager对象
        em = JpaUtils.getEntityManager();
        //2.开启事务
        tx = em.getTransaction();
        tx.begin();
    }

    @After
    public void destory(){
        //4.提交事务
        tx.commit();
        //5.释放资源
        em.close();
    }


    /**
     * 查询全部
     *     jpql: from com.bingai.domain.Customer
     *     sql: select * from cst_customer
     */
    @Test
    public void testFindAll(){

        //3.查询全部
        String jpql = "from Customer";
        Query query = em.createQuery(jpql);//创建Query查询对象，query对象才是执行jpql的对象

        //发送查询，并封装结果集
        List list = query.getResultList();

        list.forEach(a -> System.out.println(a));



    }


    /**
     * sql：select * from cst_customer ORDER BY cust_id DESC
     * jpql：from Customer order by custId DESC
     * 排序查询：根据id倒序
     */
    @Test
    public void testFindAllByIDDesc(){

        //查询全部
        String jpql = "from Customer order by custId DESC";
        Query query = em.createQuery(jpql);//创建Query查询对象，query对象才是执行jpql的对象

        //发送查询，并封装结果集
        List list = query.getResultList();
        list.forEach(a -> System.out.println(a));
    }

    /**
     * 使用jpql查询，统计客户总人数
     * sql：select COUNT(cust_id) from cst_customer
     * jpql： from Customer
     */
    @Test
    public void testPaged(){
        //统计查询
        String jpql = "select count(custId) from Customer";
        Query query = em.createQuery(jpql);//创建Query查询对象，query对象才是执行jpql的对象
        //对参数赋值
        //发送查询，并封装结果集;
        Object result = query.getSingleResult();
        System.out.println(result);
    }


    /**
     * 使用jpql分页查询
     * sql：select * from cst_customer limit ?,?
     * jpql： from Customer
     * 设置索引和起始页
     */
    @Test
    public void testCount(){
        //统计查询
        String jpql = "from Customer";
        Query query = em.createQuery(jpql);//创建Query查询对象，query对象才是执行jpql的对象
        //对参数赋值--分页参数
        //起始索引
        query.setFirstResult(0);
        //每页查询的条数
        query.setMaxResults(2);

        //发送查询，并封装结果集;
        List list = query.getResultList();
        list.forEach(a -> System.out.println(a));

    }

    /**
     * 使用jpql条件查询，查询客户名称以“张”开头的客户
     * sql：select * from cst_customer where cust_name like "张%"
     * jpql： from Customer where custName like "张%"
     */
    @Test
    public void testCondition(){
        //统计查询
        String jpql = "from Customer where custName like ?";
        Query query = em.createQuery(jpql);//创建Query查询对象，query对象才是执行jpql的对象
        //对参数赋值--占位符参数
        //第一个参数：占位符的索引位置（从1开始），第二个参数：取值
        query.setParameter((int) 1,"张%");
        //发送查询，并封装结果集;
        List list = query.getResultList();
        list.forEach(a -> System.out.println(a));

    }

























}
