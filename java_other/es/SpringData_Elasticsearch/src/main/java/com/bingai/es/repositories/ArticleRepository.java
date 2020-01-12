package com.bingai.es.repositories;

import com.bingai.es.entity.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author bingai
 * @create 2019-12-30 22:14
 */
public interface ArticleRepository extends ElasticsearchRepository<Article, Long> {

    List<Article> findByTitle(String title);

    List<Article> findByTitleOrContent(String title,String content);
    List<Article> findByTitleOrContent(String title, String content, Pageable pageable);


}



