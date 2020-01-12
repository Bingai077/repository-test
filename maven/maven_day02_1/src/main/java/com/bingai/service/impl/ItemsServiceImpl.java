package com.bingai.service.impl;

import com.bingai.dao.ItemsDao;
import com.bingai.domain.Items;
import com.bingai.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author bingai
 * @create 2019-12-27 22:59
 */

@Service
public class ItemsServiceImpl implements ItemsService{

    @Autowired
    private ItemsDao itemsDao;

    public Items findById(Integer id) {
        return itemsDao.findById(id);
    }



}
