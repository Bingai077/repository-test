package cn.bingai.practice01.demo02.chapter11_collection;

import java.util.HashSet;

/**
 封装一个新闻类，包含标题、作者、新闻内容和发布时间，新闻标题如下：
 新闻一：中国多地遭雾霾笼罩空气质量再成热议话题
 新闻二：民进党台北举行“火大游行”
 新闻三：春节临近北京“卖房热”
 新闻四：春节临近北京“卖房热”
 完成如下要求（共50分，每小题10分）：
 1）完成对新闻类的设计，要求在初始化新闻类对象时 ，通过构造传参的形式对新闻标题赋值，并要求实例化四个对象，标题内容如题。
 2）要求打印新闻对象时，直接打印新闻标题；
 3）要求使用equals方法比较新闻时，只要标题相同，就认为是同一新闻，请输出新闻一与新闻二的比较结果，新闻三与新闻四的比较结果。
 4）将新闻对象存入HashSet集合中，并且遍历集合，打印新闻类对象；
 5）打印集合中新闻数量。

 * @author bingai
 * @create 2019-11-06 19:51
 */
public class Test09 {
    public static void main(String[] args) {

        HashSet<New> news = new HashSet<>();
        news.add(new New("中国多地遭雾霾笼罩空气质量再成热议话题"));
        news.add(new New("民进党台北举行“火大游行”"));
        news.add(new New("春节临近北京“卖房热”"));
        news.add(new New("春节临近北京“卖房热”"));

        System.out.println(news.size());//3
        for (New ne : news) {
            System.out.println(ne);
        }
    }
}

class New{
    private String title;

    public New() {
    }

    public New(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        New aNew = (New) o;

        return title != null ? title.equals(aNew.title) : aNew.title == null;
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "New{" +
                "title='" + title + '\'' +
                '}';
    }

    public void setTitle(String title) {
        this.title = title;
    }
}