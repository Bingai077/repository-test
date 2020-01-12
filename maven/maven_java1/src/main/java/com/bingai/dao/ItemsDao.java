package com.bingai.dao;

import com.bingai.domain.Items;

import java.sql.SQLException;
import java.util.List;

/**
 * @author bingai
 * @create 2019-12-08 22:16
 */
public interface ItemsDao {
    public List<Items> findAll() throws Exception;

}
