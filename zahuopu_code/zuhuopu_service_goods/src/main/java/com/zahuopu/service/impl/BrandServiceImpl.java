package com.zahuopu.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zahuopu.dao.BrandMapper;
import com.zahuopu.entity.PageResult;
import com.zahuopu.pojo.goods.Brand;
import com.zahuopu.service.goods.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * @author bingai
 * @create 2020-01-10 18:17
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    //查询品牌信息
    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    //分页
    @Override
    public PageResult<Brand> findPage(int page, int size) {
        PageHelper.startPage(page, size);
        Page<Brand> pageResult = (Page<Brand>) brandMapper.selectAll();
        return new PageResult<>(pageResult.getTotal(), pageResult.getResult());
    }

    //品牌条件查询
    @Override
    public List<Brand> findList(Map<String, Object> searchMap) {

        Example example = createExample(searchMap);
        return brandMapper.selectByExample(example);

    }

    //条件+分页查询
    @Override
    public PageResult<Brand> findPage(Map<String, Object> searchMap, int page, int size) {

        PageHelper.startPage(page, size);
        Example example = createExample(searchMap);
        Page<Brand> pageResult = (Page<Brand>) brandMapper.selectByExample(example);
        return new PageResult<>(pageResult.getTotal(), pageResult.getResult());

    }

    //根据ID查询品牌
    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    //新增品牌
    @Override
    public void add(Brand brand) {
        brandMapper.insertSelective(brand);
    }

    //更新品牌
    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    //删除品牌
    @Override
    public void delete(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }


    //封装条件查询
    private Example createExample(Map<String, Object> searchMap){
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();

        if (searchMap != null) {
            //模糊查询
            if (searchMap.get("name") != null && !"".equals(searchMap.get("name"))) {
                criteria.andLike("name", "%" + (String) searchMap.get("name") + "%");
            }
            //精确匹配
            if (searchMap.get("letter") != null && !"".equals(searchMap.get("letter"))) {
                criteria.andEqualTo("letter", (String) searchMap.get("letter"));
            }

        }

        return example;
    }




}
