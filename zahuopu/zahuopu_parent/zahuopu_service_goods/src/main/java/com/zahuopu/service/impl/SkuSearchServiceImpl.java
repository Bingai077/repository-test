package com.zahuopu.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zahuopu.dao.BrandMapper;
import com.zahuopu.dao.SpecMapper;
import com.zahuopu.service.goods.SkuSearchService;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bingai
 * @create 2020-01-19 19:35
 */
@Service
public class SkuSearchServiceImpl implements SkuSearchService {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private SpecMapper specMapper;


    public Map search(Map<String, String> searchMap) {

        //1.封装查询请求
        SearchRequest searchRequest = new SearchRequest("sku");
        searchRequest.types("doc");//设置查询类型

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();//布尔查询构建器

        //1.1关键字搜索
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("name", searchMap.get("keywords"));
        boolQueryBuilder.must(matchQueryBuilder);

        //1.2商品分类过滤
        if (searchMap.get("category") != null) {
            TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("categoryname.keyword", searchMap.get("category"));
            boolQueryBuilder.filter(termQueryBuilder);
        }

        //1.3商品品牌过滤
        if (searchMap.get("brand") != null) {
            TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("brandname.keyword", searchMap.get("brand"));
            boolQueryBuilder.filter(termQueryBuilder);
        }

        //1.4规格过滤
        for (String key : searchMap.keySet()) {
            if (key.contains("spec")) {//如果是规格参数
                MatchPhraseQueryBuilder matchPhraseQueryBuilder = QueryBuilders.matchPhraseQuery("spec", searchMap.get(key));
                boolQueryBuilder.must(matchPhraseQueryBuilder);
            }
        }

        //1.5价格过滤
        if (searchMap.get("price") != null) {
            String[] prices = searchMap.get("price").split("-");
            if (!prices[0].equals("0")) {//最低价格不等于0
                RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("price").gte(prices[0] + "00");//变元为分
                boolQueryBuilder.filter(rangeQueryBuilder);
            }
            if (!prices[1].equals("*")) {//如果价格有上限
                RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("price").lte(prices[1] + "00");
                boolQueryBuilder.filter(rangeQueryBuilder);
            }
        }


        searchSourceBuilder.query(boolQueryBuilder);

        //分页
        Integer pageNo = Integer.parseInt(searchMap.get("pageNo"));//页码
        Integer pageSize = 30;//页面条数
        int fromIndex = (pageNo - 1) * pageSize;//计算开始索引


        searchSourceBuilder.from(fromIndex);//开始索引
        searchSourceBuilder.size(pageSize);//每页记录数

        //排序
        String sort = searchMap.get("sort");//排序字段
        String sortOrder = searchMap.get("sortOrder");//排序规则

        if(!"".equals(sort)){
            searchSourceBuilder.sort(sort, SortOrder.valueOf(sortOrder));
        }


        //设置高亮
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("name").preTags("<font style='color:red'>").postTags("</font>");
        searchSourceBuilder.highlighter(highlightBuilder);




        searchRequest.source(searchSourceBuilder);

        //聚合查询（商品分类）
        TermsAggregationBuilder termsAggregationBuilder = AggregationBuilders.terms("sku_category").field("categoryname.keyword");
        searchSourceBuilder.aggregation(termsAggregationBuilder);

        //2.封装查询结果
        Map resultMap = new HashMap();

        try {
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits searchHits = searchResponse.getHits();
            long totalHits = searchHits.getTotalHits();
            System.out.println("记录数：" + totalHits);
            SearchHit[] hits = searchHits.getHits();

            //2.1 商品列表查询
            List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
            for (SearchHit hit : hits) {
                Map<String, Object> skuMap = hit.getSourceAsMap();

                //name高亮处理
                Map<String, HighlightField> highlightFields = hit.getHighlightFields();
                HighlightField name = highlightFields.get("name");
                Text[] fragments = name.fragments();
                skuMap.put("name",fragments[0].toString());//用高亮的内容替换原内容

                resultList.add(skuMap);
            }
            System.out.println(resultList);
            resultMap.put("rows", resultList);

            //2.2商品分类列表
            Aggregations aggregations = searchResponse.getAggregations();
            Map<String, Aggregation> aggregationMap = aggregations.getAsMap();
            Terms terms = (Terms) aggregationMap.get("sku_category");

            List<? extends Terms.Bucket> buckets = terms.getBuckets();
            List<String> categoryList = new ArrayList();
            for (Terms.Bucket bucket : buckets) {
                categoryList.add(bucket.getKeyAsString());
            }
            resultMap.put("categoryList", categoryList);


            String categoryName = "";//商品分类名称
            if (searchMap.get("category") == null) {//如果没有分类条件
                if (categoryList.size() > 0) {
                    categoryName = categoryList.get(0);//提取分类列表第一个分类
                }
            } else {
                categoryName = searchMap.get("category");//取出参数中的分类
            }


            //2.3 品牌列表
            if (searchMap.get("brand") == null) {
                List<Map> brandList = brandMapper.findListByCategoryName(categoryName);//查询品牌列表
                resultMap.put("brandList", brandList);
            }


            //2.4规格列表
            List<Map> specList = specMapper.findListByCategoryName(categoryName);//规格列表
            for (Map spec : specList) {
                String[] options = ((String) spec.get("options")).split(",");//规格选项列表
                spec.put("options", options);
            }
            resultMap.put("specList", specList);


            //2.5 页码
            long totalCount = searchHits.getTotalHits();//总记录数
            long pageCount = (totalCount % pageSize == 0) ? (totalCount / pageSize) : (totalCount / pageSize + 1);//总页数
            resultMap.put("totalPages",pageCount);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultMap;
    }
}
