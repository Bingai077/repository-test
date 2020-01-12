package com.bingai.dao;

import com.bingai.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author bingai
 * @create 2019-12-19 20:50
 * 在mybatis中针对CRUD一共有四个注解
 * @select @Insert @Update @Delete
 */
@CacheNamespace(blocking = true)
public interface IUserDao {

    /**
     * 查询所有用户
     * @return
     * 注释中id是主键
     */
    @Select("select * from user")
    @Results(id = "userMap",value = {
            @Result(id=true,column = "id",property = "userId"),
            @Result(column = "username",property = "userName"),
            @Result(column = "sex",property = "userSex"),
            @Result(column = "address",property = "userAddress"),
            @Result(column = "birthday",property = "userBirthday"),
            @Result(property = "accounts",column = "id",
                    many = @Many(select = "com.bingai.dao.IAccountDao.findAccountByUid",fetchType = FetchType.LAZY)),
    })
    List<User> findAll();

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    @Select("select * from user where id=#{id}")
    @ResultMap(value = {"userMap"})//标准写法
    User findById(Integer userId);

    /**
     * 根据用户名称模糊查询
     * @param username
     * @return
     */
    @Select("Select * from user where username like #{username}")
    @ResultMap("userMap")
    List<User> findUserByName(String username);

}
