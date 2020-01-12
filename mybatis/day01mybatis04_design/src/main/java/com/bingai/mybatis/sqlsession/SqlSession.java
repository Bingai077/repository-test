package com.bingai.mybatis.sqlsession;

/**自定义Mybatis中和数据库交互的核心类
 * 它里面可以创建dao接口的代理对象
 * @author bingai
 * @create 2019-12-18 9:06
 */
public interface SqlSession {

    /**
     * 根据参数创建一个代理对象
     * @param daoInterfaceClass
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    /**
     * 释放资源
     */
    void close();
}
