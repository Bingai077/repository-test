package com.bingai.mapper;

import com.bingai.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author bingai
 * @create 2020-01-03 17:54
 */
@Mapper
public interface UserMapper {

    public List<User> queryUserList();
}
