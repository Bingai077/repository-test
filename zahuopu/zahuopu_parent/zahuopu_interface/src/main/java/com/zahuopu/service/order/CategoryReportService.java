package com.zahuopu.service.order;

import com.zahuopu.pojo.order.CategoryReport;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @author bingai
 * @create 2020-01-15 9:11
 */
public interface CategoryReportService {

    public List<CategoryReport> categoryReport(LocalDate date);

    public void createData();

    public List<Map> category1Count(String date1,String date2);
}
