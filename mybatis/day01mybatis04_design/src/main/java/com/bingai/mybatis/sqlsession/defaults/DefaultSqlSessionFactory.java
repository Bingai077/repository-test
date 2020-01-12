package com.bingai.mybatis.sqlsession.defaults;

import com.bingai.mybatis.cfg.Configuration;
import com.bingai.mybatis.sqlsession.SqlSession;
import com.bingai.mybatis.sqlsession.SqlSessionFactory;

/**SqlSessionFactory接口的实现类
 * @author bingai
 * @create 2019-12-18 9:40
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory{

    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg){
        this.cfg = cfg;
    }
    /**
     * 用于创建一个新的连接
     * @return
     */
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
