package com.bingai.service;

import com.bingai.domain.Province;

import java.util.List;

/**
 * @author bingai
 * @create 2019-12-05 16:23
 */
public interface ProvinceService {
    public List<Province> findAll();

    public String findAllJson();
}
