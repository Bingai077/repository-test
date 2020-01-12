package com.bingai.lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.FSDirectory;
import org.junit.Before;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;

/**
 * @author bingai
 * @create 2019-12-29 12:08
 */
public class IndexManager {

    private IndexWriter indexWriter;

    @Before
    public void init() throws Exception{
        //创建一个IndexWriter对象，需要使用IKAnalyzer作为分析器
       indexWriter = new IndexWriter(FSDirectory.open(new File("D:\\IdeaProjects\\java_other\\lucene\\index").toPath()),new IndexWriterConfig(new IKAnalyzer()));
    }

    //添加文档
    @Test
    public void addDocument() throws Exception{
//        //创建一个IndexWriter对象，需要使用IKAnalyzer作为分析器
//        IndexWriter indexWriter = new IndexWriter(FSDirectory.open(new File("D:\\IdeaProjects\\java_other\\lucene\\index").toPath()),new IndexWriterConfig(new IKAnalyzer()));

        //创建一个Document对象
        Document document = new Document();
        //向对象中添加域
        document.add(new TextField("name","新添加的文件", Field.Store.YES));
        document.add(new TextField("content","新添加的文件", Field.Store.NO));
        document.add(new StoredField("path","D:\\IdeaProjects\\java_other\\lucene\\hello"));
        //把文档写入索引库
        indexWriter.addDocument(document);
        //关闭索引库
        indexWriter.close();
    }

    //删除全部索引库
    @Test
    public void deleteAllDoucument() throws Exception{
        //删除全部文档
        indexWriter.deleteAll();
        //关闭索引库
        indexWriter.close();
    }

    //根据查询删除
    @Test
    public void deleteDoucmentByQuery() throws Exception{
        indexWriter.deleteDocuments(new Term("name","apache"));
        indexWriter.close();
    }

    //更新索引库
    @Test
    public void updateDocument() throws Exception{
        //创建一个新的文档对象
        Document document = new Document();
        //向文档对象中添加域
        document.add(new TextField("name","更新之后的文档",Field.Store.YES));
        document.add(new TextField("name1","更新之后的文档",Field.Store.YES));
        document.add(new TextField("name2","更新之后的文档",Field.Store.YES));
        //更新操作
        indexWriter.updateDocument(new Term("name","spring"),document);
        //关闭索引库
        indexWriter.close();

    }





}
