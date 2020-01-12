package com.bingai.test;

import com.bingai.domain.Account;
import com.bingai.service.IAccountService;
import config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**测试queryRunner是否单例
 * @author bingai
 * @create 2019-12-21 9:17
 */
public class QueryRunnerTest {

    @Test
    public void testQueryRunner(){
        //1.获取容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.获取queryRunner对象
        QueryRunner runner = ac.getBean("runner",QueryRunner.class);
        QueryRunner runner1 = ac.getBean("runner",QueryRunner.class);
        System.out.println(runner == runner1);
    }


}
