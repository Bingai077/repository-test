package com.bingai;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**分组查询
 * @author bingai
 * @create 2020-01-19 16:32
 */
public class Test5 {

    public static void main(String[] args) throws IOException {

        //1.连接rest接口
        HttpHost http = new HttpHost("127.0.0.1",9200,"http");
        RestClientBuilder restClientBuilder = RestClient.builder(http);
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(restClientBuilder);


         /*
        #分组查询
        GET sku/_search
        {
          "size": 0,
          "aggs": {
            "sku_category": {
              "terms": {
                "field": "categoryName"
              }
            },
            "sku_brand": {
              "terms": {
                "field": "brandName"
              }
            }
          }
        }

          */
        //2.封装查询请求
        SearchRequest searchRequest = new SearchRequest("sku");
        searchRequest.types("doc");//设置查询类型
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        TermsAggregationBuilder termsAggregationBuilder = AggregationBuilders.terms("sku_category").field("categoryName");
        searchSourceBuilder.aggregation(termsAggregationBuilder);
        searchSourceBuilder.size(0);

        searchRequest.source(searchSourceBuilder);


        /**
         *"aggregations" : {
         *     "sku_category" : {
         *       "doc_count_error_upper_bound" : 0,
         *       "sum_other_doc_count" : 0,
         *       "buckets" : [
         *         {
         *           "key" : "手机",
         *           "doc_count" : 3
         *         },
         *         {
         *           "key" : "电视",
         *           "doc_count" : 2
         *         }
         *       ]
         *     }
         */
        //3.封装查询结果
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        Aggregations aggregations = searchResponse.getAggregations();
        Map<String, Aggregation> aggregationMap = aggregations.getAsMap();
        Terms terms =(Terms) aggregationMap.get("sku_category");

        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        for (Terms.Bucket bucket : buckets) {
            System.out.println(bucket.getKeyAsString() + ":" + bucket.getDocCount());
        }


        restHighLevelClient.close();

    }
}
