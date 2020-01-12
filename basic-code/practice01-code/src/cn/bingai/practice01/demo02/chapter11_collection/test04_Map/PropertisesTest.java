package cn.bingai.practice01.demo02.chapter11_collection.test04_Map;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author bingai
 * @create 2019-11-06 11:18
 */
public class PropertisesTest {
    //Properties:常用来处理配置文件。key和value都是String类型。
    public static void main(String[] args) throws Exception {
        Properties pros = new Properties();
        FileInputStream fis = new FileInputStream("D:\\IdeaProjects\\basic-code\\practice01-code\\jdbc.properties");
        pros.load(fis);//加载流对应文件

        String name = pros.getProperty("name");
        String password = pros.getProperty("password");
        System.out.println("name = " + name + ",password = " + password);

        fis.close();

    }

}
