package com.bingai.mybatis.sqlsession;

/**
 * @author bingai
 * @create 2019-12-18 9:04
 */
public interface SqlSessionFactory {

    /**
     * 用于打开一个新的SqlSession对象
     * @return
     */
    SqlSession openSession();
}
