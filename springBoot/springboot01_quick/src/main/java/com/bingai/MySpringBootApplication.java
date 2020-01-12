package com.bingai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**引导类
 * @author bingai
 * @create 2020-01-03 9:48
 */
//声明该类是一个SpringBoot引导类
@SpringBootApplication
public class MySpringBootApplication {

    //main是java程序的入口
    public static void main(String[] args) {
        //run方法 表示运行SpringBoot的引导类 run方法的参数是SpringBoot引导类的字节码对象
        SpringApplication.run(MySpringBootApplication.class);
    }



}
