package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Category;

import java.util.List;

/**
 * @author bingai
 * @create 2019-12-10 16:41
 */
public interface CategoryDao {

    /**
     * 查询所有
     * @return
     */
    public List<Category> findAll();

}
