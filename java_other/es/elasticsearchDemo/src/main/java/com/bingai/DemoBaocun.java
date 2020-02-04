package com.bingai;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/** 封装对象
 * @author bingai
 * @create 2020-01-19 16:32
 */
public class DemoBaocun {

    private static final String url = "jdbc:mysql://localhost:3306/zahuopu_goods";
    private static final String name = "com.mysql.jdbc.Driver";
    private static final String username = "root";
    private static final String password = "root";





    public static void main(String[] args) throws IOException, SQLException {

        Connection connection = JdbcConnectionUtil.getConnection(url, name, username, password);
        Statement statement = connection.createStatement();





        //2.封装请求对象


        BulkRequest bulkRequest = new BulkRequest();

        //1.连接rest接口
        HttpHost http = new HttpHost("127.0.0.1",9200,"http");
        RestClientBuilder restClientBuilder = RestClient.builder(http);
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(restClientBuilder);



        ResultSet id = statement.executeQuery("select id from tb_sku");
        ResultSet name = statement.executeQuery("select name from tb_sku");
        ResultSet brandName = statement.executeQuery("select brand_name from tb_sku");
        ResultSet categoryName = statement.executeQuery("select category_name from tb_sku");
        ResultSet price = statement.executeQuery("select price from tb_sku");
        ResultSet saleNum = statement.executeQuery("select sale_num from tb_sku");
        ResultSet commentNum = statement.executeQuery("select comment_num from tb_sku");
        ResultSet spec1 = statement.executeQuery("select spec from tb_sku");



        IndexRequest indexRequest = new IndexRequest("sku","doc","5");
        Map skuMap = new HashMap();
        skuMap.put("name","华为mate20 pro");
        skuMap.put("brandName","华为");
        skuMap.put("categoryName","手机");
        skuMap.put("price",1010221);
        //skuMap.put("createTime","2020‐01-19");
        skuMap.put("saleNum",101021);
        skuMap.put("commentNum",10102321);
        Map spec=new HashMap();
        spec.put("网络制式","移动4G");
        spec.put("屏幕尺寸","5");
        skuMap.put("spec",spec);
        indexRequest.source(skuMap);


        bulkRequest.add(indexRequest);


        //3.获取执行结果
        //IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        int status = bulkResponse.status().getStatus();
        System.out.println(status);

        restHighLevelClient.close();


    }
}
