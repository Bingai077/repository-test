package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Seller;

/**
 * @author bingai
 * @create 2019-12-12 16:28
 */
public interface SellerDao {
    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Seller findById(int id);
}
