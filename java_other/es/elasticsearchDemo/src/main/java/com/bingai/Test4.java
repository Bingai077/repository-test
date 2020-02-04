package com.bingai;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;

/**过滤查询
 * @author bingai
 * @create 2020-01-19 16:32
 */
public class Test4 {

    public static void main(String[] args) throws IOException {

        //1.连接rest接口
        HttpHost http = new HttpHost("127.0.0.1",9200,"http");
        RestClientBuilder restClientBuilder = RestClient.builder(http);
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(restClientBuilder);


         /*
        #过滤查询（不计算文档匹配度得分）
        GET sku/_search
        {
          "query": {
            "bool":{
              "filter":[
                {
                "match":{"brandName":"小米"}
                }
              ]
            }
          }
        }

          */
        //2.封装查询请求
        SearchRequest searchRequest = new SearchRequest("sku");
        searchRequest.types("doc");//设置查询类型

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();//布尔查询构建器

        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("brandname.keyword", "小米");
        boolQueryBuilder.filter(termQueryBuilder);

        searchSourceBuilder.query(boolQueryBuilder);

        searchRequest.source(searchSourceBuilder);



        //3.封装查询结果
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits searchHits = searchResponse.getHits();
        long totalHits = searchHits.getTotalHits();
        System.out.println("记录数："+ totalHits);
        SearchHit[] hits = searchHits.getHits();
        for (SearchHit hit : hits) {
            String source = hit.getSourceAsString();
            System.out.println(source);
        }

        restHighLevelClient.close();

    }
}
