package com.bingai.dao;

import com.bingai.domain.Role;

import java.util.List;

/**
 * @author bingai
 * @create 2019-12-19 15:09
 */
public interface IRoleDao {

    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll();
}
