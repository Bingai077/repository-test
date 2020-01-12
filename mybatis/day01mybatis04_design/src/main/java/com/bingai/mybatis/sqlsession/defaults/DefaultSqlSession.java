package com.bingai.mybatis.sqlsession.defaults;

import com.bingai.mybatis.cfg.Configuration;
import com.bingai.mybatis.sqlsession.SqlSession;
import com.bingai.mybatis.sqlsession.proxy.MapperProxy;
import com.bingai.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author bingai
 * @create 2019-12-18 9:44
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration cfg;
    private Connection connection;

    public DefaultSqlSession(Configuration cfg){
        this.cfg = cfg;
        connection = DataSourceUtil.getConnection(cfg);
    }

    /**
     * 用于创建代理对象
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T)Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),new Class[]{daoInterfaceClass},new MapperProxy(cfg.getMappers(),connection));

    }

    /**
     * 用于释放资源
     */
    public void close() {
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
