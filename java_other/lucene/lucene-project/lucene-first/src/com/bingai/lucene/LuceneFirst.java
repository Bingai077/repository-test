package com.bingai.lucene;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.document.*;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.awt.*;
import java.io.File;

import java.util.Dictionary;


/**
 * @author bingai
 * @create 2019-12-28 19:43
 */
public class LuceneFirst {

    @Test
    public void createTndex() throws Exception{
        //第一步：创建一个 java 工程，并导入 jar 包。
        //第二步：创建一个 indexwriter 对象。
            //1） 指定索引库的存放位置 Directory 对象
            //2） 指定一个 IndexWriterConfig 对象。
        //第二步：创建 document 对象。
        //把索引库保存到内存中
        //Dictionary dictionary = new RAMDirectory();
        //把索引库保存到磁盘
        FSDirectory dictionary = FSDirectory.open(new File("D:\\IdeaProjects\\java_other\\lucene\\index").toPath());
        IndexWriterConfig config = new IndexWriterConfig(new IKAnalyzer());
        IndexWriter indexWriter = new IndexWriter(dictionary,config);

        //第三步：创建 field 对象，将 field 添加到 document 对象中。
        File dir = new File("D:\\Java全套资料\\09-Lucene\\01 Lucene\\02.参考资料\\searchsource");
        File[] files = dir.listFiles();
        for (File f : files){
            //取文件名
            String fileName = f.getName();
            //取文件路径
            String filePath = f.getPath();
            //文件的内容
            String fileContent = FileUtils.readFileToString(f, "utf-8");
            //文件大小
            long fileSize = FileUtils.sizeOf(f);
            //创建Field
            //参数1：域名称，参数2：域的内容，参数3：是否存储
            Field fieldName = new TextField("name", fileName, Field.Store.YES);
//            Field fieldPath = new TextField("path", filePath, Field.Store.YES);
            Field fieldPath = new StoredField("path",filePath);
            Field fieldContent = new TextField("content", fileContent, Field.Store.YES);
//            Field fieldSize = new TextField("size", fileSize+"", Field.Store.YES);
            Field fieldSizeValue = new LongPoint("size", fileSize);
            Field fieldSizeStore = new StoredField("size",fileSize);
            //创建文档对象
            Document document = new Document();
            //向文档对象中添加域
            document.add(fieldName);
            document.add(fieldPath);
            document.add(fieldContent);
            //document.add(fieldSize);
            document.add(fieldSizeValue);
            document.add(fieldSizeStore);

            //第四步：使用 indexwriter 对象将 document 对象写入索引库，此过程进行索引创建。并将索引和 document 对象写入索引库。
            indexWriter.addDocument(document);


        }
        //第五步：关闭 IndexWriter 对象。
        indexWriter.close();

    }


    @Test
    public void seachIndex() throws Exception{
        //第一步：创建一个 Directory 对象，也就是索引库存放的位置。
        FSDirectory dictionary = FSDirectory.open(new File("D:\\IdeaProjects\\java_other\\lucene\\index").toPath());
        //第二步： 创建一个 indexReader 对象，需要指定 Directory 对象。
        IndexReader indexReader = DirectoryReader.open(dictionary);
        //第三步：创建一个 indexsearcher 对象，需要指定 IndexReader 对象
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        //第四步： 创建一个 TermQuery 对象，指定查询的域和查询的关键词。
        Query query = new TermQuery(new Term("name","spring"));
        //第五步：执行查询。
        //参数1：查询对象  参数2：查询结果返回的最大记录数
        TopDocs topDocs = indexSearcher.search(query, 10);
        //第六步：返回查询结果。遍历查询结果并输出。
        System.out.println("查询总记录数：" + topDocs.totalHits);

        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc doc : scoreDocs) {
            //取文档Id
            int docId = doc.doc;
            //根据id取文档对象
            Document document = indexSearcher.doc(docId);
            System.out.println(document.get("name"));
            System.out.println(document.get("path"));
            System.out.println(document.get("size"));
            //System.out.println(document.get("content"));
            System.out.println("============================");
        }

        //第七步：关闭 IndexReader 对象
        indexReader.close();

    }

    @Test
    public void testTokenStream() throws Exception{
        //1.创建一个标准分析器对象
//        Analyzer analyzer = new StandardAnalyzer();
        Analyzer analyzer = new IKAnalyzer();
        //2.获得 tokenStream 对象
        TokenStream tokenStream = analyzer.tokenStream("", "斌改，公安局12月28日，2021年国际足联俱乐部世界杯（简称；世俱杯）和2023年亚足联亚洲杯承办城市揭晓。上海、天津、广州、武汉、沈阳、济南、杭州、大连等8座城市承办世俱杯；北京、天津、上海、重庆、成都、西安、大连、青岛、厦门、苏州等10座城市成为2023年亚洲杯承办城市。");
        //第一个参数：域名，可以随便给一个
        //第二个参数：要分析的文本内容
        CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
        //3.添加一个引用，可以获得每个关键词
        //4.添加一个偏移量的引用，记录了关键词的开始位置以及结束位置
        tokenStream.reset();
        //5.将指针调整到列表的头部
        while (tokenStream.incrementToken()){
            //6.遍历关键词列表，通过 incrementToken 方法判断列表是否结束
            System.out.println(charTermAttribute.toString());
        }
        //7.关闭tokenStream 对象
        tokenStream.close();
    }







}
