package cn.itcast.travel.service;

import cn.itcast.travel.domain.Category;

import java.util.List;

/**
 * @author bingai
 * @create 2019-12-10 16:46
 */
public interface CategoryService {
    public List<Category> findAll();
}
