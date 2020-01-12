package com.bingai.mybatis.sqlsession;

import com.bingai.mybatis.cfg.Configuration;
import com.bingai.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.bingai.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**用于创建一个SqlSessionFactoryBuilder对象
 * @author bingai
 * @create 2019-12-18 9:02
 */
public class SqlSessionFactoryBuilder {

    /**
     * 根据参数的字节输入流来构建一个SqlSessionFactory工厂
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config){

        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(cfg);
    }
}
