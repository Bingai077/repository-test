package com.bingai.repository;

import com.bingai.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author bingai
 * @create 2020-01-03 18:55
 */
public interface UserRepository extends JpaRepository<User,Long> {

    public List<User> findAll();
}
