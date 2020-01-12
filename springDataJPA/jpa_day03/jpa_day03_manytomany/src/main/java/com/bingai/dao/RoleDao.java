package com.bingai.dao;

import com.bingai.domain.Role;
import com.bingai.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author bingai
 * @create 2020-01-02 22:42
 */
public interface RoleDao extends JpaRepository<Role,Long>,JpaSpecificationExecutor<User> {
}
