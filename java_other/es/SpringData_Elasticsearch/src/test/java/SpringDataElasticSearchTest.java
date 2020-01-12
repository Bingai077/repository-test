import com.bingai.es.entity.Article;
import com.bingai.es.repositories.ArticleRepository;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

/**
 * @author bingai
 * @create 2019-12-30 22:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringDataElasticSearchTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ElasticsearchTemplate template;

    @Test
    public void createIndex() throws Exception{
        //创建索引，并配置映射关系
        template.createIndex(Article.class);
        //配置映射关系
        //template.putMapping(Article.class);
    }


    //添加/修改
    @Test
    public void addDocument() throws Exception{
        for (int i = 10; i <= 20; i++) {
            //创建一个Article对象
            Article article = new Article();
            article.setId(i);
            article.setTitle("习近平对京张高铁开通运营作出重要指示" + i);
            article.setContent("国家主席习近平将发表二〇二〇年新年贺词" + i);
            //把文档写入索引库
            articleRepository.save(article);

        }


    }


    //删除
    @Test
    public void deleteDocumentById() throws Exception{
        articleRepository.deleteById(1l);
        //全部删除
        //articleRepository.deleteAll();
    }

    //查询
    @Test
    public void findAll() throws Exception{
        Iterable<Article> articles = articleRepository.findAll();
        articles.forEach(article -> System.out.println(article));
    }

    @Test
    public void testFindById() throws Exception{
        Optional<Article> optional = articleRepository.findById(1l);
        Article article = optional.get();
        System.out.println(article);
    }


    @Test
    public void TestFindByTitle() throws Exception{
        List<Article> list = articleRepository.findByTitle("高铁开通啦");
        list.stream().forEach(article -> System.out.println(article));
    }

    @Test
    public void testFindByTitleOrContent() throws Exception{
        Pageable pageable = PageRequest.of(1, 15);
        articleRepository.findByTitleOrContent("高铁", "创造", pageable)
                .forEach(article -> System.out.println(article));
    }

    @Test
    public void testNativeSearchQuery() throws Exception{
        //创建一个查询对象
        NativeSearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.queryStringQuery("高铁开通啦").defaultField("title"))
                .withPageable(PageRequest.of(0,15))
                .build();
        //执行查询
        List<Article> list = template.queryForList(query, Article.class);
        list.forEach(article -> System.out.println(article));
    }
















}
