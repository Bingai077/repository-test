package com.bingai.test;

import com.bingai.dao.ItemsDao;
import com.bingai.dao.impl.ItemsDaoImpl;
import com.bingai.domain.Items;
import org.junit.Test;

import java.util.List;

/**
 * @author bingai
 * @create 2019-12-08 22:32
 */
public class ItemsTest {
    @Test
    public void findAll() throws Exception{
        ItemsDao itemsDao = new ItemsDaoImpl();
        List<Items> list = itemsDao.findAll();
        for (Items s: list) {
            System.out.println(s.getName());
        }
    }
}
