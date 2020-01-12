package com.bingai.test;

import com.bingai.dao.RoleDao;
import com.bingai.dao.UserDao;
import com.bingai.domain.Role;
import com.bingai.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.AssertFalse;
import java.io.OutputStreamWriter;


/**
 * @author bingai
 * @create 2020-01-02 23:02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ManyToManyTest {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;


    /**
     * 保存一个用户，保存一个角色
     *
     * 多对多放弃维护权：被动的一方放弃
     *
     */
    @Transactional
    @Rollback(false)
    @Test
    public void testAdd(){

        User user = new User();
        user.setUserName("张三");

        Role role = new Role();
        role.setRoleName("java程序员");

        //配置用户到角色关系，可以对中间表中的数据进行维护 1-1
        user.getRoles().add(role);//配置用户到角色的关系

        //配置角色到用户的关系，可以对中间表的数据进行维护 1-1
        role.getUsers().add(user);//配置角色到用户的关系

        userDao.save(user);
        roleDao.save(role);
    }



    //测试级联添加（保存一个用户的同时保存用户的关联角色）
    @Transactional
    @Rollback(false)
    @Test
    public void testCasCadeAdd(){

        User user = new User();
        user.setUserName("张三");

        Role role = new Role();
        role.setRoleName("java程序员");

        //配置用户到角色关系，可以对中间表中的数据进行维护 1-1
        user.getRoles().add(role);//配置用户到角色的关系

        //配置角色到用户的关系，可以对中间表的数据进行维护 1-1
        role.getUsers().add(user);//配置角色到用户的关系

        userDao.save(user);

    }

    //测试级联删除（删除一个用户的同时删除用户的关联角色）
    @Transactional
    @Rollback(false)
    @Test
    public void testCasCadeRemove(){

        //查询1号用户
        User user = userDao.findOne((long) 1);
        //删除用户
        userDao.delete(user);
    }


}
