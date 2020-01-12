package cn.bingai.practice01.demo02.chapter15_Reflection.Test2_allConstructor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @author bingai
 * @create 2019-11-13 19:26
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnontation {

    String value() default "hello";


}
