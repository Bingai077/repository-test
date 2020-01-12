package com.bingai.mybatis.io;


import java.io.InputStream;

/**使用类加载器读取配置文件的类
 * @author bingai
 * @create 2019-12-18 8:58
 */
public class Resources {

    /**
     * 根据传入参数获取字节输入流
     * @param filePath
     * @return
     */
    public static InputStream getResourceAsStream(String filePath){
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}

