package cn.bingai.practice01.demo02.chapter11_collection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author bingai
 * @create 2019-11-06 18:47
 */
public class Test06 {

    public static void main(String[] args) {
        ArrayList<News> list = new ArrayList<>();
        list.add(new News("新闻一：中国多地遭雾霾笼罩空气质量再成热议话题"));
        list.add(new News("新闻二：春节临近北京“卖房热”"));

        Iterator<News> iterator = list.iterator();
        while(iterator.hasNext()){
            News news = iterator.next();
            if(news.getTitle().length() > 15){
                news.setTitle(news.getTitle().substring(0,14) + "...");
            }
            System.out.println(news);
        }


    }
}

class News{
    private String title;
    private String content;

    public News() {
    }

    public News(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return  title ;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}