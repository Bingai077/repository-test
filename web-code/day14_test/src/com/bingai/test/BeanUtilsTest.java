package com.bingai.test;

import com.bingai.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @author bingai
 * @create 2019-11-27 23:30
 */
public class BeanUtilsTest {
    @Test
    public void test(){

        User user = new User();
        try {
            //BeanUtils.setProperty(user,"username","zhangsan");
            BeanUtils.setProperty(user,"hehe","male");
            System.out.println(user);
            String gender = BeanUtils.getProperty(user, "hehe");
            System.out.println(gender);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
