package cn.itcast.travel.dao;

import cn.itcast.travel.domain.RouteImg;

import java.util.List;

/**
 * @author bingai
 * @create 2019-12-12 16:16
 */
public interface RouteImgDao {

    /**
     * 根据线路route的id查询图片
     * @param rid
     * @return
     */
    public List<RouteImg> findByRid(int rid);
}
