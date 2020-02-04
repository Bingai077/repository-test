package com.bingai;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;

/**范围查询
 * @author bingai
 * @create 2020-01-19 16:32
 */
public class Test7 {

    public static void main(String[] args) throws IOException {

        //1.连接rest接口
        HttpHost http = new HttpHost("127.0.0.1",9200,"http");
        RestClientBuilder restClientBuilder = RestClient.builder(http);
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(restClientBuilder);


        /**
         * #范围查询
         * GET sku/_search
         * {
         *   "query": {
         *     "range": {
         *       "price": {
         *         "gte": 10000,
         *         "lte": 20000
         *       }
         *     }
         *   }
         * }
         */
        //2.封装查询请求
        SearchRequest searchRequest = new SearchRequest("sku");
        searchRequest.types("doc");//设置查询类型

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();//query:

//        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("name","手机");
//        searchSourceBuilder.query(matchQueryBuilder);

        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("price").gte("10000").lte("20000");
        searchSourceBuilder.query(rangeQuery);

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
