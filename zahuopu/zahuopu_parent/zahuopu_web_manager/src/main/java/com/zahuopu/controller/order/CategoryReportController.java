package com.zahuopu.controller.order;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zahuopu.pojo.order.CategoryReport;
import com.zahuopu.service.order.CategoryReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @author bingai
 * @create 2020-01-15 9:16
 */
@RestController
@RequestMapping("/categoryReport")
public class CategoryReportController {

    @Reference
    private CategoryReportService  categoryReportService;

    /**
     * 昨天的数据统计（商品类目）
     * @return
     */
    @GetMapping("/yesterday")
    public List<CategoryReport> yesterday(){
        //LocalDate localDate = LocalDate.now().minusDays(1);//得到昨天的日期
        LocalDate localDate = LocalDate.of(2019,4,15);
        return categoryReportService.categoryReport(localDate);
    }

    /**
     * 按日期统计一级分类数据
     * @param date1
     * @param date2
     * @return
     */
    @GetMapping("/category1Count")
    public List<Map> category1Count(String date1,String date2){
        return categoryReportService.category1Count(date1,date2);
    }




}
