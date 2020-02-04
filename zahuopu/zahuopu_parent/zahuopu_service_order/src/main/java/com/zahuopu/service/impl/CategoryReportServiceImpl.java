package com.zahuopu.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zahuopu.dao.CategoryReportMappper;
import com.zahuopu.pojo.order.CategoryReport;
import com.zahuopu.service.order.CategoryReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @author bingai
 * @create 2020-01-15 9:13
 */
@Service(interfaceClass = CategoryReportService.class)
public class CategoryReportServiceImpl implements CategoryReportService {

    @Autowired
    private CategoryReportMappper categoryReportMappper;

    @Override
    public List<CategoryReport> categoryReport(LocalDate date) {
        return categoryReportMappper.categoryReport(date);
    }


    /**
     * 定时任务-生成统计数据
     */
    @Override
    @Transactional
    public void createData() {
        //查询2019.4.15类目统计数据
        LocalDate localDate = LocalDate.of(2019,4,15);
        List<CategoryReport> categoryReports = categoryReportMappper.categoryReport(localDate);


        //保存到tb_category_report
        for (CategoryReport categoryReport : categoryReports) {
            categoryReportMappper.insert(categoryReport);
        }

    }

    /**
     * 按日期统计一级分类数据
     * @param date1
     * @param date2
     * @return
     */
    @Override
    public List<Map> category1Count(String date1, String date2) {
        return categoryReportMappper.category1Count(date1,date2);
    }

}
