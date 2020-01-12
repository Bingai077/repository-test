package com.zahuopu.service.goods;

import com.zahuopu.entity.PageResult;
import com.zahuopu.pojo.goods.Brand;

import java.util.List;
import java.util.Map;

/**
 * @author bingai
 * @create 2020-01-07 23:37
 */
public interface BrandService {

    public List<Brand> findAll();

    public PageResult<Brand> findPage(int page,int size);

    public List<Brand> findList(Map<String,Object> searchMap);

    public PageResult<Brand> findPage(Map<String,Object> searchMap,int page,int size);

    public Brand findById(Integer id);

    public void add(Brand brand);

    public void update(Brand brand);

    public void delete(Integer id);


}

