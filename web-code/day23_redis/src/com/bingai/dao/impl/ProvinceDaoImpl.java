package com.bingai.dao.impl;

import com.bingai.dao.ProvinceDao;
import com.bingai.domain.Province;
import com.bingai.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author bingai
 * @create 2019-12-05 16:22
 */
public class ProvinceDaoImpl implements ProvinceDao {

    //1.声明成员变量 jdbctemplete
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> findAll() {
        //1.定义sql
        String sql = "select * from province";
        //2.执行sql
        List<Province> list = template.query(sql, new BeanPropertyRowMapper<>(Province.class));

        return list;
    }
}
