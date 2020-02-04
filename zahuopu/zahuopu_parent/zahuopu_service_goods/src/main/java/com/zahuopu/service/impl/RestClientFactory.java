package com.zahuopu.service.impl;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author bingai
 * @create 2020-01-19 19:27
 */
public class RestClientFactory {


    public static RestHighLevelClient getRestHighLevelClient(String hostname,int port){

        HttpHost http = new HttpHost(hostname,port,"http");
        RestClientBuilder restClientBuilder = RestClient.builder(http);//rest构建器
        return new RestHighLevelClient(restClientBuilder);//高级客户端连接

    }

}
