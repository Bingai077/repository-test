package com.bingai.test;

import com.bingai.dao.CustomerDao;
import com.bingai.dao.LinkManDao;
import com.bingai.domain.Customer;
import com.bingai.domain.LinkMan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @author bingai
 * @create 2020-01-02 23:37
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ObjectQueryTest {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private LinkManDao linkManDao;

    //could not initialize proxy - no Session
    //测试对象导航查询（查询一个对象的时候，通过此对象查询所有的关联对象）
    @Transactional//解决java代码中no Session问题
    @Test
    public void testQuery1(){
        //查询客户
        Customer customer = customerDao.getOne(1L);
        //对象导航查询，此客户下的所有联系人、
        Set<LinkMan> linkMans = customer.getLinkMans();

        for (LinkMan linkMan : linkMans) {
            System.out.println(linkMan);
        }

    }


    /**
     * 对象导航查询：
     *      默认使用的是延迟加载的形式查询的
     *          调用get方法并不会立即发送查询，而是在使用关联对象的时候才会查询
     *      延迟加载！
     *  修改配置：将延迟加载改为立即加载
     *      fetch，需要配置多表映射关系在注解上
     *
     */

    @Transactional//解决java代码中no Session问题
    @Test
    public void testQuery2(){
        //查询客户
        Customer customer = customerDao.findOne(1L);
        //对象导航查询，此客户下的所有联系人、
        Set<LinkMan> linkMans = customer.getLinkMans();

        System.out.println(linkMans.size());

    }

    /**
     *
     * 从联系人对象导航查询他的所属客户
     *      默认立即加载
     *
     */
    @Transactional//解决java代码中no Session问题
    @Test
    public void testQuery3(){
        //查询客户
        LinkMan linkMan = linkManDao.findOne(2L);
        //对象导航查询，所属客户
        Customer customer = linkMan.getCustomer();

        System.out.println(customer);

    }


}
