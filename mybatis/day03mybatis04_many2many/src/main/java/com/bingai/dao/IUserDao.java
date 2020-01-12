package com.bingai.dao;

import com.bingai.domain.User;

import java.util.List;

/**
 * @author bingai
 * @create 2019-12-18 11:35
 * 用户持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有，同时获取到用户下所有账户的信息
     * @return
     */
    List<User> findAll();


    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    User findById(Integer userId);



}
