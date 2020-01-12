package com.bingai.dao;

import com.bingai.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author bingai
 * @create 2019-12-20 0:04
 */
public interface IAccountDao {

    /**
     * 查询所有账户，并且获取每个账户所属的用户信息
     * property：封装对象，column封装对象，select：指向
     * @return
     */
    @Select("select * from account")
    @Results(id="accountMap",value = {
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),
            @Result(property = "user",column = "uid",one = @One(select = "com.bingai.dao.IUserDao.findById",fetchType= FetchType.EAGER)),
    })
    List<Account> findAll();

    /**
     * 根据用户id查询账户信息
     * @param userId
     * @return
     */
    @Select("select * from account where uid = #{useId}")
    List<Account> findAccountByUid(Integer userId);
}
