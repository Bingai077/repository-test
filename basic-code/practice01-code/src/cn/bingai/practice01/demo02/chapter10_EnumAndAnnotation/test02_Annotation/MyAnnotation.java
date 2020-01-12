package cn.bingai.practice01.demo02.chapter10_EnumAndAnnotation.test02_Annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author bingai
 * @create 2019-11-04 15:51
 */
//@Inherited
//@Documented
@Repeatable(MyAnnotations.class)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE,TYPE_PARAMETER,TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String value() default "hello";
}
