package com.xuecheng.manage_cms_client.dao;

import com.xuecheng.manage_cms_client.service.PageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author bingai
 * @create 2020-02-10 23:31
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PageServiceTest {

    @Autowired
    PageService pageService;

    @Test
    public void testGetPageHtml(){
        String pageHtml = pageService.getPageHtml("5e3eca687c2ac54adc790a31");
        System.out.println(pageHtml);
    }

}
