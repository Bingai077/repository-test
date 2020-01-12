package com.bingai.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.interceptor.CacheOperationInvoker;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

/**和事务管理相关的工具类
 * 它包含了开启事务、提交事务、回滚事务和释放连接
 *
 * @author bingai
 * @create 2019-12-21 14:32
 */
@Component("txManager")
@Aspect
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.bingai.service.impl.*.*(..))")
    private void pt1(){}


    /**
     * 开启事务
     */

    public void beginTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 提交事务
     */

    public void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */

    public void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放连接
     */

    public void release(){
        try {
            //还回连接池中
            connectionUtils.getThreadConnection().close();
            connectionUtils.removeConnection();//解绑
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Around("pt1()")
    public Object aroundAdvice(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try {
            //1.获取参数
            Object[] args = pjp.getArgs();
            //2.开启事务
            this.beginTransaction();
            //3.执行方法
            rtValue = pjp.proceed(args);
            //4.提交事务
            this.commit();

            //返回结果
            return rtValue;
        }catch (Throwable t){
            //5.回滚事务
            this.rollback();
            throw new RuntimeException(t);
        }finally {
            //6.释放
            this.release();
        }
    }

}
