package com.bingai.mybatis.utils;

import com.bingai.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**用于创建数据源的工具类
 * @author bingai
 * @create 2019-12-18 10:09
 */
public class DataSourceUtil {

    /**
     * 用于获取一个连接
     * @param cfg
     * @return
     */
    public static Connection getConnection(Configuration cfg){
        try {
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(),cfg.getUsername(),cfg.getPassword());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
