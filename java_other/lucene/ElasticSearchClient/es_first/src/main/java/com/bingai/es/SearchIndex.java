package com.bingai.es;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.IdsQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.search.MultiMatchQuery;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;

import javax.management.Query;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.Map;

/**
 * @author bingai
 * @create 2019-12-30 18:58
 */
public class SearchIndex {
    private TransportClient client;

    @Before
    public void init() throws Exception{
        //1.创建一个Settings对象，相当于是一个配置信息，主要是配置集群的名称
        Settings settings = Settings.builder().put("cluster.name","my-elasticsearch").build();
        //2.创建一个客户端Client对象
        client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"),9301))
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"),9302))
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"),9303));

    }

    private void search(QueryBuilder queryBuilder) throws Exception{
        //3.使用client执行查询
        SearchResponse searchResponse = client.prepareSearch("index_hello")
                .setTypes("article")
                .setQuery(queryBuilder)
                //设置分页信息
                .setFrom(0)
                //每页显示的行数
                .setSize(5)
                .get();
        //4.得到查询结果
        SearchHits searchHits = searchResponse.getHits();
        //5.取查询结果的总记录数
        System.out.println("查询结果的总记录数：" + searchHits.getTotalHits());

        //6.取查询结果列表
        Iterator<SearchHit> iterator = searchHits.iterator();
        while (iterator.hasNext()){
            SearchHit searchHit = iterator.next();
            //打印文档对象，以json格式输出
            System.out.println(searchHit.getSourceAsString());
            //取文档属性
            System.out.println("文档属性为：");
            Map<String, Object> document = searchHit.getSource();
            System.out.println(document.get("id"));
            System.out.println(document.get("title"));
            System.out.println(document.get("content"));

        }


        //7.关闭client
        client.close();
    }


    //根据id查询
    @Test
    public void testSearchById() throws Exception {

        //1.创建一个client对象
        //2.创建一个查询对象，使用QueryBuilds工具类创建QueryBuilder对象
        IdsQueryBuilder queryBuilder = QueryBuilders.idsQuery().addIds("1","2");

        search(queryBuilder);

    }


    //根据term查询-文档ID-关键词查询
    @Test
    public void testQueryByTerm() throws Exception{
        //创建一个QueryBuilder对象
        //参数1：要搜索的字段
        //参数2：要搜索的关键词
        QueryBuilder queryBuilder =  QueryBuilders.termQuery("title","全国");
        //执行查询
        search(queryBuilder);
    }

    //根据QueryString查询-字符串查询
    @Test
    public void testQueryStringQuery() throws Exception{
        //创建QueryBuilder对象，指定默认搜索域
        QueryBuilder queryBuilder = QueryBuilders.queryStringQuery("古田会议").defaultField("title");
        //执行查询
        search(queryBuilder,"title");
    }


    private void search(QueryBuilder queryBuilder,String highlightField) throws Exception{
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        //高亮显示的字段
        highlightBuilder.field(highlightField);
        highlightBuilder.preTags("<em>");
        highlightBuilder.postTags("</em>");

        //3.使用client执行查询
        SearchResponse searchResponse = client.prepareSearch("index_hello")
                .setTypes("article")
                .setQuery(queryBuilder)
                //设置分页信息
                .setFrom(0)
                //每页显示的行数
                .setSize(5)
                //设置高亮信息
                .highlighter(highlightBuilder)
                .get();


        //4.得到查询结果
        SearchHits searchHits = searchResponse.getHits();
        //5.取查询结果的总记录数
        System.out.println("查询结果的总记录数：" + searchHits.getTotalHits());

        //6.取查询结果列表
        Iterator<SearchHit> iterator = searchHits.iterator();
        while (iterator.hasNext()){
            SearchHit searchHit = iterator.next();
            //打印文档对象，以json格式输出
            System.out.println(searchHit.getSourceAsString());
            //取文档属性
            System.out.println("文档属性为：");
            Map<String, Object> document = searchHit.getSource();
            System.out.println(document.get("id"));
            System.out.println(document.get("title"));
            System.out.println(document.get("content"));
            System.out.println("*******高亮结果*******");
            Map<String, HighlightField> highlightFields = searchHit.getHighlightFields();
            System.out.println(highlightFields);
            //取title高亮显示的结果
            HighlightField field = highlightFields.get(highlightField);
            Text[] fragments = field.getFragments();
            if(fragments != null){
                String title = fragments[0].toString();
                System.out.println(title);
            }


        }


        //7.关闭client
        client.close();
    }






    //分页
    //在client对象执行查询前，设置分页信息，执行查询
    //分页设置两个值，一个是from、size
    //from：起始行号，size：每页记录数


    //高亮显示
    //设置字段、前缀、后缀


}
