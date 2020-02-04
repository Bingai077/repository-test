package com.zahuopu.dao;

import com.zahuopu.pojo.goods.Spec;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.code.ORDER;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;


public interface SpecMapper extends Mapper<Spec> {


    /**
     * 根据商品分类查询规格列表
     * @param categoryName
     * @return
     */
    @Select("SELECT name,options FROM tb_spec WHERE template_id in (SELECT template_id FROM tb_category WHERE name=#{categoryName}) ORDER BY seq")
    public List<Map> findListByCategoryName(@Param("categoryName") String categoryName);


}
