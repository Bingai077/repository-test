package com.bingai.es;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;

/**
 * @author bingai
 * @create 2019-12-30 17:11
 */
public class ElasticSearchClientTest {

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


    /**
     * 创建索引库
     * @throws Exception
     */
    @Test
    public void createIndex() throws Exception{
       //3.使用client对象创建一个索引库
        client.admin().indices().prepareCreate("index_hello").get();
        //4.关闭client对象
        client.close();

    }


    //设置Mappings
    @Test
    public void setMappings() throws Exception{

        //3.创建一个mapping信息，应该是一个json数据，可以是字符串，也可以是XcontextBuilder对象
        /*
        {
        "article":{
                "properties":{
                    "id":{
                        "type":"long",
                        "store":true
                    },
                    "title":{
                        "type":"text",
                        "store":true,
                        "index":true,
                        "analyzer":"ik_smart"
                    },
                    "content":{
                        "type":"text",
                        "store":true,
                        "index":true,
                        "analyzer":"ik_smart"
				    }
			    }

	         }
        }
         */
        XContentBuilder builder = XContentFactory.jsonBuilder()
            .startObject()
                .startObject("article")
                    .startObject("properties")
                        .startObject("id")
                            .field("type","long")
                            .field("store",true)
                        .endObject()
                        .startObject("title")
                            .field("type","text")
                            .field("store",true)
                            .field("analyzer","ik_smart")
                        .endObject()
                        .startObject("content")
                            .field("type","text")
                            .field("store",true)
                            .field("analyzer","ik_smart")
                        .endObject()
                    .endObject()
                .endObject()
            .endObject();
        //4.使用client向es服务器发送mapping信息
        client.admin().indices()
                //设置要做映射的索引
                .preparePutMapping("index_hello")
                //设置要做映射的type
                .setType("article")
                //mapping信息，可以是XContentBuilder对象也可以是json格式字符串
                .setSource(builder)
                .get();

        //5.关闭Client对象
        client.close();

    }


    //添加文档（方式一）——通过XContentBuilder
    @Test
    public void testAddDocument() throws Exception{

        //1.创建一个Settings对象
        //2.创建一个Client对象

        //3.创建一个文档对象，创建一个json格式的字符串,或者使用XContent
        XContentBuilder builder = XContentFactory.jsonBuilder()
                .startObject()
                    .field("id",2l)
                    .field("title","今冬首个棉裤预警发布,全国五成地区需棉裤护体2222222222222")
                    .field("content","又快又聪明！京张高铁“C位出道”正式开通运营")
                .endObject();

        //4.使用Client对象把文档添加到索引库中,id不设置自动生成
        client.prepareIndex("index_hello","article","2").setSource(builder).get();

        //5.关闭client
        client.close();

    }


    //添加文档（方式二）——使用Jackson转换实体
    @Test
    public void testAddDocument2() throws Exception{
        //创建一个Article对象
        Article article = new Article();
        //设置对象属性
        article.setId(3l);
        article.setTitle("大罢工持续近一月 马克龙致辞能否平“民愤”？");
        article.setContent("1909—2019 京张铁路今日变高铁 网友:致敬詹天佑");
        //把article对象转换成json格式字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonDocument = objectMapper.writeValueAsString(article);
        System.out.println(jsonDocument);
        //使用client对象把文档写入索引库
        client.prepareIndex("index_hello","article","3")
                .setSource(jsonDocument, XContentType.JSON)
                .get();

        //关闭客户端
        client.close();
    }


    //添加文档（方式二）——使用Jackson转换实体
    @Test
    public void testAddDocument3() throws Exception{
        for (int i = 4; i < 100; i++) {
            //创建一个Article对象
            Article article = new Article();
            //设置对象属性
            article.setId(i);
            article.setTitle("90年后，古田会议和今天的对话 “数”说2019" + i);
            article.setContent("数说中国 | 我国人民生活发生翻天覆地变化" + i);
            //把article对象转换成json格式字符串
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonDocument = objectMapper.writeValueAsString(article);
            System.out.println(jsonDocument);
            //使用client对象把文档写入索引库
            client.prepareIndex("index_hello","article",i + "")
                    .setSource(jsonDocument, XContentType.JSON)
                    .get();
        }


        //关闭客户端
        client.close();
    }












}
