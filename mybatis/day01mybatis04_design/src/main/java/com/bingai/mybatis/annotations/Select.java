package com.bingai.mybatis.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**查询的注解
 * @author bingai
 * @create 2019-12-18 10:35
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Select {
    /**
     * 配置sql语句
     * @return
     */
    String value();
}
