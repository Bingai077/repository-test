package com.bingai.demo;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author bingai
 * @create 2020-01-11 20:50
 */
public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = "LTAI4FjbwbL3BCgbYhJ6xqqy";
        String accessKeySecret = "EiEOd7Ud1n4ANcaIWCBYL6q8GwkKJh";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 上传文件流。
        InputStream inputStream = new FileInputStream("C:\\Users\\Bai-gai\\Documents\\美图图库\\1.jpg");
        ossClient.putObject("zahuopu520", "a.jpg", inputStream);

        // 关闭OSSClient。
        ossClient.shutdown();
    }

}
