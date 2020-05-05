package com.xuecheng.manage_cms_client.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.CmsPageParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author bingai
 * @create 2020-02-06 19:39
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {

    @Autowired
    CmsPageRepository cmsPageRepository;

    @Test
    public void testFindAll(){
        List<CmsPage> all = cmsPageRepository.findAll();
        System.out.println(all);
    }

    //分页查询
    @Test
    public void testFindPage(){
        //分页参数
        int page = 0;
        int size = 10;
        Pageable pageable = PageRequest.of(page,size);
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
        System.out.println(all);
    }

    //自定义条件查询
    @Test
    public void testFindAllByExample(){
        //分页参数
        int page = 0;
        int size = 10;
        Pageable pageable = PageRequest.of(page,size);

        //条件值对象
        CmsPage cmsPage = new CmsPage();
        //要查询5a751fab6abb5044e0d19ea1站点的页面
//        cmsPage.setSiteId("5a751fab6abb5044e0d19ea1");
        //设置模板id条件
//        cmsPage.setTemplateId("5a925be7b00ffc4b3c1578b5");
        //设置页面别名
        cmsPage.setPageAliase("轮播");

        //条件匹配器
//        ExampleMatcher exampleMatcher = ExampleMatcher.matching();
        //重新赋值
//        exampleMatcher = exampleMatcher.withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());
        //ExampleMatcher.GenericPropertyMatchers.contains()包含关键字
        //ExampleMatcher.GenericPropertyMatchers.startsWith()前缀匹配

        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());



        //定义Example<存放条件的类型>
        Example<CmsPage> example = Example.of(cmsPage,exampleMatcher);

        Page<CmsPage> content = cmsPageRepository.findAll(example, pageable);
        System.out.println(content);

    }


    //添加
    @Test
    public void testInsert(){
        //定义实体类
        CmsPage cmsPage = new CmsPage();
        cmsPage.setSiteId("s01");
        cmsPage.setTemplateId("t01");
        cmsPage.setPageName("测试页面");
        cmsPage.setPageCreateTime(new Date());
        List<CmsPageParam> cmsPageParams = new ArrayList<>();
        CmsPageParam cmsPageParam = new CmsPageParam();
        cmsPageParam.setPageParamName("param1");
        cmsPageParam.setPageParamValue("value1");
        cmsPageParams.add(cmsPageParam);
        cmsPage.setPageParams(cmsPageParams);
        cmsPageRepository.save(cmsPage);
        System.out.println(cmsPage);
    }

    //修改
    @Test
    public void testUpdate(){

        //查询对象
        Optional<CmsPage> optional = cmsPageRepository.findById("5e3c0c499962403e90b9416f");
        if(optional.isPresent()){
            CmsPage cmsPage = optional.get();
            //设置要修改的值
            cmsPage.setPageName("测试页面007");
            //...
            CmsPage save = cmsPageRepository.save(cmsPage);
            System.out.println(save);
        }
    }

    //根据页面名称查询
    @Test
    public void testfindByPageName(){
        CmsPage cmsPage = cmsPageRepository.findByPageName("测试页面");
        System.out.println(cmsPage);
    }


}
