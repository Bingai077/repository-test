package cn.bingai.practice01.demo02.chapter12_Generic;

import org.junit.Test;

import java.util.ArrayList;

/**
 封装一个新闻类News，包含新闻标题，新闻作者，新闻内容，新闻类型三个属性，
 提供必要的访问器和修改器方法，重写toString方法，
 要求打印对象时输出格式为“标题；类型；作者”，
 要求只要新闻标题相同就判断为同一条新闻。

 在测试类中创建一个只能容纳该类对象的ArrayList集合，添加三条新闻。
 遍历集合，打印新闻标题，将新闻标题截取字符串到10个汉字的长度。

 * @author bingai
 * @create 2019-11-08 16:35
 */
public class Test02 {
    @Test
    public void test(){
        ArrayList<News> list = new ArrayList<>();
        list.add(new News("快船逆转擒开拓者","杂志",123));
        list.add(new News("国足将变阵？韦世豪有望踢主力 李可搭档买提江","杂志",123));
        list.add(new News("国足将变阵？韦世豪有望踢主力","杂志",123));

        for (News news : list) {
            if(news.getTitle().length() > 10){
                news.setTitle(news.getTitle().substring(0,10) + "...");
            }
            System.out.println(news.getTitle());
        }

    }
}

class News<T>{
    private String title;
    private T type;
    private T author;

    public News() {
    }

    public News(String title, T type, T author) {
        this.title = title;
        this.type = type;
        this.author = author;
    }

    @Override
    public String toString() {
        return  title + ";" + type + ";" + author ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News<?> news = (News<?>) o;

        return title != null ? title.equals(news.title) : news.title == null;
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    public T getAuthor() {
        return author;
    }

    public void setAuthor(T author) {
        this.author = author;
    }
}