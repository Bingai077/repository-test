package cn.bingai.practice01.demo02.chapter15_Reflection.Test1_Reflection;

import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

/**
 * 了解类的加载器
 * @author bingai
 * @create 2019-11-13 18:04
 */
public class ClassLoaderTest {

    @Test
    public void test1(){

        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        //调用系统类加载器的getParent():获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);

        //调用扩展类加载器的getParent():无法获取引导类加载器
        //引导类加载器主要负责加载java核心类库，无法加载自定义类
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);


    }

    /*
        Properties:用来读取配置文件
     */
    @Test
    public void test2() throws Exception {
        Properties pros = new Properties();

        //此时的文件默认在当前的module下
        //读取配置文件的方式一：
//        FileInputStream fis = new FileInputStream("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter15_Reflection\\Test1_Reflection\\jdbc.properties");
//        pros.load(fis);

        //读取配置文件的方式二：使用ClassLoader
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("cn/bingai/practice01/demo02/chapter15_Reflection/Test1_Reflection/jdbc.properties");
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");

        System.out.println("user=" + user + ", password=" + password);

    }
}
